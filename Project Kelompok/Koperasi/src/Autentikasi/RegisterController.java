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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import koperasi.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Desi Chrisdamayanti Lubis; 11417018; 42TI
 */
public class RegisterController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton btnSignUp;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton btnSignIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleButtonRegister(ActionEvent event) {
        if(name.getText().length()==0 
                || email.getText().length()==0 
                || username.getText().length()==0 
                || password.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Isi semua field!");  
        }else if(password.getText().length() > 10){
            JOptionPane.showMessageDialog(null, "Password maksimal 10 karakter");
        }else{
            Session session=NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql="INSERT INTO User(nama, email, username, password,role) values (:nama,:email,:username,:password, 1)";
            Query q=session.createSQLQuery(hql);
            q.setParameter("nama", name.getText());
            q.setParameter("email", email.getText());
            q.setParameter("username", username.getText());
            q.setParameter("password", password.getText());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }

    @FXML
    private void HandleButtonLogin(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        layout.getChildren().setAll(root);
    }
    
}
