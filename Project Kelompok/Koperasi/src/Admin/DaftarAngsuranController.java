/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import koperasi.entity.Angsuran;
import koperasi.util.NewHibernateUtil;
import model.AngsuranList;
import model.SimpananList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class DaftarAngsuranController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<AngsuranList> angsuranTable;
    @FXML
    private TableColumn<AngsuranList, Integer> no;
    @FXML
    private TableColumn<AngsuranList, String> namaPeminjam;
    @FXML
    private TableColumn<AngsuranList, String> jumlahAngsuran;
    @FXML
    private TableColumn<AngsuranList, Date> tanggalAngsuran;
    @FXML
    private JFXButton btnSimpanan;
    @FXML
    private JFXButton btnPinjaman;
    @FXML
    private JFXButton btnAngsuran;
    @FXML
    private JFXButton btnBarang;
    @FXML
    private JFXButton btnTransaksi;
    @FXML
    private JFXButton btnLaporan;
    @FXML
    private JFXButton btnKeluar;
    
    ObservableList list = FXCollections.observableArrayList();
    public static AngsuranList angsuran = null;
    @FXML
    private JFXButton btnSimpanPinjam;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Angsuran";
        Query q=session.createQuery(hql);
        List lst=q.list();
        int num = 0;
        for (Object o : lst) {
            Angsuran a = (Angsuran) o;
            list.add(new AngsuranList(++num,
                    a.getUser().getNama(),
                    a.getJumlahangsuran(),
                    a.getTanggalangsuran()));
        }
        session.getTransaction().commit();
        session.close();
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        namaPeminjam.setCellValueFactory(new PropertyValueFactory<>("namaPeminjam"));
        jumlahAngsuran.setCellValueFactory(new PropertyValueFactory<>("jumlahAngsuran"));
        tanggalAngsuran.setCellValueFactory(new PropertyValueFactory<>("tanggalAngsuran"));
        angsuranTable.setItems(list);
    }    

    @FXML
    private void HandleButtonSimpanan(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarSimpanan.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonPinjaman(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarPinjaman.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonAngsuran(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarAngsuran.fxml"));
        
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

    @FXML
    private void HandleButtonSimpanPinjam(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/DaftarSimpanan.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}
