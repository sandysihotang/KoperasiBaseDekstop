/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import static Admin.DaftarBarangController.barang;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import koperasi.entity.Transaksi;
import koperasi.util.NewHibernateUtil;
import model.BarangList;
import model.TransaksiList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class DaftarTransaksiController implements Initializable {

    @FXML
    private TableView<TransaksiList> transaksiTable;
    @FXML
    private TableColumn<TransaksiList, Integer> no;
    @FXML
    private TableColumn<TransaksiList, String> namaBarang;
    @FXML
    private TableColumn<TransaksiList, String> namaPemesan;
    @FXML
    private TableColumn<TransaksiList, String> kodeTransaksi;
    @FXML
    private TableColumn<TransaksiList, Integer> jumlahBarang;
    @FXML
    private TableColumn<TransaksiList, String> totalHarga;
    @FXML
    private JFXButton btnBarang;
    @FXML
    private JFXButton btnTransaksi;
    @FXML
    private JFXButton btnLaporan;
    @FXML
    private JFXButton btnKeluar;

    ObservableList list = FXCollections.observableArrayList();
    public static TransaksiList transaksi = null;
    @FXML
    private AnchorPane layout;
    @FXML
    private JFXButton btnCetak;
    @FXML
    private JFXButton btnSimpanPinjam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDataTable();
    }

    private void setDataTable() {
        bersihkanData();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaksi";
        Query q = session.createQuery(hql);
        List lst = q.list();
        int num = 0;
        for (Object lst1 : lst) {
            Transaksi t = (Transaksi) lst1;
            list.add(new TransaksiList(++num, t.getBarang().getNama(), t.getUser().getNama(), t.getKodeTransaksi(), t.getJumlahBarang(), t.getTotalHarga()));
        }
        session.getTransaction().commit();
        session.close();
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        namaBarang.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        namaPemesan.setCellValueFactory(new PropertyValueFactory<>("namaPemesan"));
        kodeTransaksi.setCellValueFactory(new PropertyValueFactory<>("kodeTransaksi"));
        jumlahBarang.setCellValueFactory(new PropertyValueFactory<>("jumlahBarang"));
        totalHarga.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));

        transaksiTable.setItems(list);
        transaksiTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setItems();
            }
        });
    }

    private void bersihkanData() {
        for (int i = 0; i < transaksiTable.getItems().size(); i++) {
            transaksiTable.getItems().clear();
        }
    }

    private void setItems() {
        if (transaksiTable.getSelectionModel().getSelectedItem() != null) {
            transaksi = (TransaksiList) transaksiTable.getSelectionModel().getSelectedItem();
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
    private void HandleButtonCetak(ActionEvent event) throws FileNotFoundException, DocumentException {
        Document doc=new Document();
        PdfWriter.getInstance(doc,new FileOutputStream("./src/text.pdf"));
        doc.open();
        PdfPTable table=new PdfPTable(5);
        PdfPCell c1=new PdfPCell(new Phrase("Nama Barang"));
        table.addCell(c1);
        PdfPCell c2=new PdfPCell(new Phrase("Nama Pemesan"));
        table.addCell(c2);
        PdfPCell c3=new PdfPCell(new Phrase("Kode Transaksi"));
        table.addCell(c3);
        PdfPCell c4=new PdfPCell(new Phrase("Jumlah Barang"));
        table.addCell(c4);
        PdfPCell c5=new PdfPCell(new Phrase("Total Harga"));
        table.addCell(c5);
        table.setHeaderRows(1);
        
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Transaksi";
        Query q = session.createQuery(hql);
        List lst = q.list();
        int num = 0;
        for (Object lst1 : lst) {
            Transaksi t = (Transaksi) lst1;
            table.addCell(t.getBarang().getNama());
            table.addCell(t.getUser().getNama());
            table.addCell(t.getKodeTransaksi());
            table.addCell(t.getJumlahBarang().toString());
            table.addCell(t.getTotalHarga());
        }
        session.getTransaction().commit();
        session.close();
        doc.add(table);
        doc.close();
        JOptionPane.showMessageDialog(null, "Berhasil Menyimpan laporan");
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
