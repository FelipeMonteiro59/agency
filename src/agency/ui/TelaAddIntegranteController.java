/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TelaAddIntegranteController implements Initializable {

    @FXML
    private TextField tfbuscar;
    @FXML
    private Button btbuscar;
    @FXML
    private CheckBox cknome;
    @FXML
    private CheckBox ckcache;
    @FXML
    private CheckBox ckgenero;
    @FXML
    private CheckBox ckintegrante;
    @FXML
    private Button btconfirmar;
    @FXML
    private Button btcancelar;
    @FXML
    private TableView<?> tvgrupo;
    @FXML
    private TableColumn<?, ?> tcnome;
    @FXML
    private TableColumn<?, ?> tcgenero;
    @FXML
    private TableColumn<?, ?> tccache;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
