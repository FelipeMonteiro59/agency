package agency.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TelaCadGrupoController implements Initializable {

    @FXML
    private Button btnovo;
    @FXML
    private Button btalterar;
    @FXML
    private Button btapagar;
    @FXML
    private Button btconfirmar;
    @FXML
    private Button btcancelar;
    @FXML
    private AnchorPane pndados;
    @FXML
    private TextField txcodigo;
    @FXML
    private TextField txgenero;
    @FXML
    private TextField txnome;
    @FXML
    private TextField txbanco;
    @FXML
    private TextField txagencia;
    @FXML
    private TextField txconta;
    @FXML
    private TextField txltitular;
    @FXML
    private TextField txcache;
    @FXML
    private Button btadd;
    @FXML
    private Button btdel;
    @FXML
    private TableView<?> tvintegrantes;
    @FXML
    private TableColumn<?, ?> tcinome;
    @FXML
    private TableColumn<?, ?> tcicpf;
    @FXML
    private TableColumn<?, ?> tcirg;
    @FXML
    private TableColumn<?, ?> tcitelefone;
    @FXML
    private TableColumn<?, ?> tciemail;
    @FXML
    private VBox pnpesquisa;
    @FXML
    private TextField txbusca;
    @FXML
    private Button btbuscar;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> tccodigo;
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

    @FXML
    private void clkNovo(ActionEvent event) {
    }

    @FXML
    private void clkAlterar(ActionEvent event) {
    }

    @FXML
    private void clkApagar(ActionEvent event) {
    }

    @FXML
    private void clkConfirmar(ActionEvent event) {
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
    }

    @FXML
    private void clkBuscar(ActionEvent event) {
    }

    @FXML
    private void clkTabela(MouseEvent event) {
    }

}
