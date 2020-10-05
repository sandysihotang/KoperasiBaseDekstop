/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
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
import javax.swing.JOptionPane;
import koperasi.entity.Barang;
import koperasi.util.NewHibernateUtil;
import model.BarangList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class DaftarBarangController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TableColumn<BarangList, Integer> no;
    @FXML
    private JFXButton btnTambah;
    @FXML
    private JFXButton btnUbah;
    @FXML
    private JFXButton btnHapus;
    @FXML
    private JFXButton btnBarang;
    @FXML
    private JFXButton btnTransaksi;
    @FXML
    private JFXButton btnLaporan;
    @FXML
    private JFXButton btnKeluar;
    @FXML
    private TableColumn<BarangList, String> namaBarang;
    @FXML
    private TableColumn<BarangList, String> stok;
    @FXML
    private TableColumn<BarangList, String> harga;
    @FXML
    private TableColumn<BarangList, String> deskripsi;
    
    ObservableList list = FXCollections.observableArrayList();
    public static BarangList barang = null;
    @FXML
    private TableView<BarangList> barangTable;
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
        String hql = "from Barang";
        Query q = session.createQuery(hql);
        List lst = q.list();
        session.getTransaction().commit();
        session.close();
        int num = 0;
        for(Object lst1 : lst){
            Barang b = (Barang)lst1;
            list.add(new BarangList(++num, b.getIdbarang(), b.getNama(), b.getStok(), b.getHarga(), b.getDeskripsi()));
        }

        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        namaBarang.setCellValueFactory(new PropertyValueFactory<>("nama"));
        stok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        harga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        
        barangTable.setItems(list);
        barangTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setItems();
            }
        });
    }
    
    private void bersihkanData(){
        for (int i = 0; i < barangTable.getItems().size(); i++) {
            barangTable.getItems().clear();
        }
    }
    
    private void setItems(){
        if (barangTable.getSelectionModel().getSelectedItem() != null) {
            barang = (BarangList) barangTable.getSelectionModel().getSelectedItem();
        }
    }
    
    @FXML
    private void HandleButtonTambah(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Admin/Tambah.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleButtonUbah(ActionEvent event) throws IOException {
        if (barang == null) {
            JOptionPane.showMessageDialog(null, "Pilih row yang akan diedit");
        } else {
            Stage stage = new Stage();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Admin/Edit.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void HandleButtonHapus(ActionEvent event) throws IOException {
        if (barang == null) {
            JOptionPane.showMessageDialog(null, "Pilih row yang akan dihapus");
        } else {
            Stage stage = new Stage();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/Admin/Hapus.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
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
