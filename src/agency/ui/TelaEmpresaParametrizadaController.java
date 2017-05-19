package agency.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TelaEmpresaParametrizadaController implements Initializable {

    @FXML
    private TextField tfnome;
    @FXML
    private TextField tfrazao;
    @FXML
    private TextField tfcnpj;
    @FXML
    private TextField tftelefone;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfendereco;
    @FXML
    private TextField tfbairro;
    @FXML
    private TextField tfcep;
    @FXML
    private Button btbuscar;
    @FXML
    private VBox tfcidade;
    @FXML
    private ChoiceBox<?> cbuf;
    @FXML
    private Button btimagem;
    @FXML
    private Button btconfirmar;
    @FXML
    private Button btcancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
