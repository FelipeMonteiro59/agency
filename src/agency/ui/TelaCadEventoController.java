
package agency.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TelaCadEventoController implements Initializable {
//<editor-fold defaultstate="collapsed" desc="VARS FXML">
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
    private Button btrealizar;
    @FXML
    private Button btadiar;
    @FXML
    private AnchorPane pndados;
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
    private ComboBox<?> cbuf;
    @FXML
    private ComboBox<?> cbcidade;
    @FXML
    private TextField txnumero;
    @FXML
    private TextField txrg;
    @FXML
    private TextField txnomeeve;
    @FXML
    private DatePicker dpinicio;
    @FXML
    private DatePicker dpfinal;
    @FXML
    private Button btbuscarorg;
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
    private TextField txcepeve;
    @FXML
    private TextField txlogradouroeve;
    @FXML
    private TextField txbairroeve;
    @FXML
    private ComboBox<?> cbufeve;
    @FXML
    private ComboBox<?> cbcidadeeve;
    @FXML
    private TextField txnumeroeve;
    @FXML
    private TextField txreceber;
    @FXML
    private TextField txpagar;
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
    private TableColumn<?, ?> tccpf;
    @FXML
    private TableColumn<?, ?> tctelefone;
//</editor-fold>
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoInicial();
        
    }
    private void estadoInicial(){
        pndados.setDisable(true);
        pnpesquisa.setDisable(false);
        
        btadiar.setDisable(true);
        btrealizar.setDisable(true);
        btconfirmar.setDisable(true);
        btcancelar.setDisable(false);
        btapagar.setDisable(true);
        btalterar.setDisable(true);
        btnovo.setDisable(false);
        ObservableList <Node> componentes=pndados.getChildren(); //”limpa” os componentes
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  // textfield, textarea e htmleditor
                ((TextInputControl)n).setText("");
        }
        cbuf.setValue(null);//não sei se funciona
        cbcidade.setValue(null);
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
    private void evtCep(ActionEvent event) {
    }

    @FXML
    private void clkBuscar(ActionEvent event) {
    }

    @FXML
    private void clkTabela(MouseEvent event) {
    }
    
}
