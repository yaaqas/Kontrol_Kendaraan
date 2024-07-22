package Proyek_PBO;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

abstract class Kendaraan {
    protected String merk;
    public Kendaraan(String merk) {
        this.merk = merk;
    }
    
    public abstract void bergerak();
}

class Mobil extends Kendaraan {
    private int jumlahPintu;
    public Mobil(String merk, int jumlahPintu) {
        super(merk);
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil " + merk + " bergerak");
    }

    public void klakson() {
        System.out.println("Tin tin!");
    }
}

class Sepeda extends Kendaraan {
    public Sepeda(String merk) {
        super(merk);
    }

    @Override
    public void bergerak() {
        System.out.println("Sepeda " + merk + " bergerak");
    }

    public void ringkasi() {
        System.out.println("Ring ring!");
    }
}

public class Proyek_PBO extends Application {
    private TextArea outputArea;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Membuat komponen GUI
        outputArea = new TextArea();
        Button mobilButton = new Button("Gerakkan Mobil");
        mobilButton.setOnAction(e -> gerakkanKendaraan(new Mobil("Toyota", 4)));
        Button sepedaButton = new Button("Gerakkan Sepeda");
        sepedaButton.setOnAction(e -> gerakkanKendaraan(new Sepeda("Polygon")));

        // Membuat tata letak VBox
        VBox root = new VBox(10);
        root.getChildren().addAll(outputArea, mobilButton, sepedaButton);

        // Membuat objek Scene dengan ukuran 400x300
        Scene scene = new Scene(root, 400, 300);

        // Mengatur judul stage
        primaryStage.setTitle("Manajemen Kendaraan App");

        // Menetapkan scene ke stage
        primaryStage.setScene(scene);

        // Menampilkan stage
        primaryStage.show();
    }

    private void gerakkanKendaraan(Kendaraan kendaraan) {
        // 9. Polymorphism
        kendaraan.bergerak();

        // Menampilkan output di area teks
        outputArea.appendText("Kendaraan " + kendaraan.merk + " bergerak\n");

        // 8. Class Relationship
        if (kendaraan instanceof Mobil) {
            ((Mobil) kendaraan).klakson();
        } else if (kendaraan instanceof Sepeda) {
            ((Sepeda) kendaraan).ringkasi();
        }
    }
}