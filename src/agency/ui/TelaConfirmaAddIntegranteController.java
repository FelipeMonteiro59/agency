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
import javafx.scene.layout.AnchorPane;

public class TelaConfirmaAddIntegranteController implements Initializable {

    @FXML
    private Button btconfirmar;
    @FXML
    private Button btcancelar;
    @FXML
    private TextField txcodigo1;
    @FXML
    private TextField txhrini;
    @FXML
    private TextField txminini;
    @FXML
    private TextField txhrfim;
    @FXML
    private TextField txminfim;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clkConfirmar(ActionEvent event) {
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
    }

}
