package agency.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import agency.entity.Estado;
import agency.entity.Cidade;
import agency.ui.util.Carregadores;
import agency.ui.util.MaskFieldUtil;

public class TelaCadArtistaController implements Initializable {
//<editor-fold defaultstate="collapsed" desc="VARS FXML">

    @FXML
    private AnchorPane pndados;
    @FXML
    private VBox pnpesquisa;
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
    private TextField txcodigo;
    @FXML
    private TextField txcpf;
    @FXML
    private TextField txnome;
    @FXML
    private TextField txtelefone;
    @FXML
    private TextField txemail;
    @FXML
    private TextField txcep;
    @FXML
    private TextField txlogradouro;
    @FXML
    private TextField txbairro;
    @FXML
    private ComboBox<Estado> cbuf;
    @FXML
    private ComboBox<Cidade> cbcidade;
    @FXML
    private TextField txnumero;
    @FXML
    private TextField txrg;
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
    private TableColumn<?, ?> tccpf;
    @FXML
    private TableColumn<?, ?> tctelefone;
    @FXML
    private ComboBox<String> cbgenero;
//</editor-fold>

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //estadoInicial();
        Carregadores.carregaGenero(cbgenero);

        Carregadores.carregaUF(cbuf);

        cbuf.setOnAction(e -> Carregadores.carregaCidade(cbuf, cbcidade));

        //colocar máscara
        try {
            // MaskFieldUtil.onlyAlfaNumericValue(txnome);
            MaskFieldUtil.cpfField(txcpf);
            MaskFieldUtil.foneField(txtelefone);
            MaskFieldUtil.cepField(txcep);
            // MaskFieldUtil.onlyAlfaNumericValue(txlogradouro);
            // MaskFieldUtil.onlyAlfaNumericValue(txbairro);
            // MaskFieldUtil.onlyAlfaNumericValue(txbusca);
        } catch (Exception e) {

        }
    }

//<editor-fold defaultstate="collapsed" desc="ESTADOS DE LAYOUT">
    private void estadoInicial() {
        pndados.setDisable(true);
        pnpesquisa.setDisable(false);

        btconfirmar.setDisable(true);
        btcancelar.setDisable(false);
        btapagar.setDisable(true);
        btalterar.setDisable(true);
        btnovo.setDisable(false);
        ObservableList<Node> componentes = pndados.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
        }
        cbuf.setValue(null);//não sei se funciona
        cbcidade.setValue(null);
    }

    private void estadoEdicao() {
        pnpesquisa.setDisable(true);
        btalterar.setDisable(true);
        btapagar.setDisable(true);
        btnovo.setDisable(true);
        txcodigo.setDisable(true);

        pndados.setDisable(false);
        btconfirmar.setDisable(false);
        btcancelar.setDisable(false);
    }

    //</editor-fold>
}
