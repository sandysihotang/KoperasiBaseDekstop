/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import koperasi.entity.Simpanan;
import koperasi.util.NewHibernateUtil;
import model.SimpananList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class DaftarSimpananController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TableView<SimpananList> simpananTable;
    @FXML
    private TableColumn<SimpananList, Integer> no;
    @FXML
    private TableColumn<SimpananList, String> namaPeminjam;
    @FXML
    private TableColumn<SimpananList, String> jumlahSimpanan;
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
    
    public static SimpananList simpanan = null;
    @FXML
    private JFXButton btnSimpanPinjam;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDataTable();
    }    
    
    private void setDataTable(){
        bersihkanData();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Simpanan";
        Query q = session.createQuery(hql);
        List lst = q.list();
        session.getTransaction().commit();
        session.close();
        int num = 0;
        for (Object lst1 : lst) {
            Simpanan s = (Simpanan) lst1;
            list.add(new SimpananList(++num, s.getUser().getNama(), s.getJumlahsimpanan()));
        }

        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        namaPeminjam.setCellValueFactory(new PropertyValueFactory<>("namaPeminjam"));
        jumlahSimpanan.setCellValueFactory(new PropertyValueFactory<>("jumlahSimpanan"));

        simpananTable.setItems(list);
        simpananTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setitem();
            }
        });
    }
    
    private void bersihkanData() {
        for (int i = 0; i < simpananTable.getItems().size(); i++) {
            simpananTable.getItems().clear();
        }
    }

    private void setitem() {
        if (simpananTable.getSelectionModel().getSelectedItem() != null) {
            simpanan = simpananTable.getSelectionModel().getSelectedItem();
        }
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
