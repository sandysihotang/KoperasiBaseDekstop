/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autentikasi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import koperasi.entity.User;
import koperasi.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton btnSignUp;
    public static Integer idLogin;
    int role;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleButtonLogin(ActionEvent event) throws IOException {
        if (username.getText().length() == 0 || password.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Username Atau Password Harus Di isi!");
        } else {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "FROM User U WHERE U.username= :username AND U.password= :password";
            Query q = session.createQuery(hql);
            q.setParameter("username", username.getText());
            q.setParameter("password", password.getText());
            List results = q.list();
            session.getTransaction().commit();
            session.close();
            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Akun anda tidak terdaftar!");
            } else {
                for (Object u : results) {
                    User uu = (User) u;
                    idLogin = uu.getIduser();
                    role = uu.getRole();
                }
                if (role == 1) {
                    AnchorPane root = FXMLLoader.load(getClass().getResource("/Admin/Dashboard.fxml"));
                    layout.getChildren().setAll(root);
                } else {
                    AnchorPane root = FXMLLoader.load(getClass().getResource("/Customer/Dashboard.fxml"));
                    layout.getChildren().setAll(root);
                }
            }
        }
    }

    @FXML
    private void HandleButtonRegister(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        layout.getChildren().setAll(root);
    }
    
}
