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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import koperasi.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class EditController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private JFXTextField namaProduk;
    @FXML
    private JFXTextField stok;
    @FXML
    private JFXTextField harga;
    @FXML
    private JFXTextArea deskripsi;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnBarang;
    @FXML
    private JFXButton btnTransaksi;
    @FXML
    private JFXButton btnLaporan;
    @FXML
    private JFXButton btnKeluar;
    ObservableList list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData();
    }    
    
    private void setData(){
        namaProduk.setText(DaftarBarangController.barang.getNama());
        stok.setText(DaftarBarangController.barang.getStok());
        harga.setText(DaftarBarangController.barang.getHarga());
        deskripsi.setText(DaftarBarangController.barang.getDeskripsi());
    }

    @FXML
    private void HandleButtonUpdate(ActionEvent event) throws IOException {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "update barang set nama=:nama , stok=:stok , harga=:harga , deskripsi=:deskripsi where idbarang=:idbarang";
            Query q = session.createSQLQuery(hql);
            q.setParameter("nama", namaProduk.getText());
            q.setParameter("stok", stok.getText());
            q.setParameter("harga", harga.getText());
            q.setParameter("deskripsi", deskripsi.getText());
            q.setParameter("idbarang", DaftarBarangController.barang.getIdBarang());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            
            Stage stage = new Stage();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarBarang.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
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
