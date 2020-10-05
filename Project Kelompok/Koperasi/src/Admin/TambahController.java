/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static javax.management.Query.value;
import javax.swing.JOptionPane;
import koperasi.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class TambahController implements Initializable {

    @FXML
    private ImageView gambar;
    @FXML
    private JFXTextField namaProduk;
    @FXML
    private JFXTextField stok;
    @FXML
    private JFXTextField harga;
    @FXML
    private JFXTextArea deskripsi;
    @FXML
    private JFXButton btnTambah;
    @FXML
    private JFXButton btnChoose;
    @FXML
    private JFXButton btnBarang;
    @FXML
    private JFXButton btnTransaksi;
    @FXML
    private JFXButton btnLaporan;
    @FXML
    private JFXButton btnKeluar;
    @FXML
    private AnchorPane layout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void HandleButtonTambah(ActionEvent event) throws IOException {
        if(namaProduk.getText().length() == 0 ||
                stok.getText().length() == 0 ||
                harga.getText().length() == 0 ||
                deskripsi.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Isi semua field!!!");
        }
        else{
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "INSERT INTO Barang(nama, stok, harga, deskripsi) VALUES (:nama, :stok, :harga, :deskripsi)";
            Query q = session.createSQLQuery(hql);
            q.setParameter("nama", namaProduk.getText());
            q.setParameter("stok", stok.getText());
            q.setParameter("harga", harga.getText());
            q.setParameter("deskripsi", deskripsi.getText());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            namaProduk.setText("");
            stok.setText("");
            harga.setText("");
            deskripsi.setText("");
            
            AnchorPane root = FXMLLoader.load(getClass().getResource("/Admin/DaftarBarang.fxml"));
            layout.getChildren().setAll(root);
        }
    }

    @FXML
    private void HandleButtonBarang(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarBarang.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonTransaksi(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarTransaksi.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonLaporan(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarLaporan.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonKeluar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Autentikasi/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
