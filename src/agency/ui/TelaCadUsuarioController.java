package agency.ui;

import agency.controllers.CtrUsuario;
import agency.entity.Usuario;
import agency.ui.util.Acesso;
import agency.ui.util.Carregadores;
import agency.ui.util.MaskFieldUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

public class TelaCadUsuarioController implements Initializable {

    private int estado = 0;

    //<editor-fold defaultstate="collapsed" desc="FXML VARS">
    @FXML
    private Label lbnome;
    @FXML
    private TextField tfnome;
    @FXML
    private Label lbcpf;
    @FXML
    private TextField tfcpf;
    @FXML
    private Label lbrg;
    @FXML
    private TextField tfrg;
    @FXML
    private Label lbtelefone;
    @FXML
    private TextField tftelefone;
    @FXML
    private Label lbpermissao;
    @FXML
    private ComboBox<String> cbpermissao;
    @FXML
    private Label lblogin;
    @FXML
    private TextField tflogin;
    @FXML
    private Label lbsenha;
    @FXML
    private TextField tfsenha;
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
    private VBox vbox1;
    @FXML
    private VBox vbBuscaTable;
    @FXML
    private TextField tfbusca;
    @FXML
    private Button btbusca;
    @FXML
    private TableView<Usuario> tv;
    @FXML
    private TableColumn tcLogin;
    @FXML
    private TableColumn tcSenha;
    @FXML
    private TableColumn tcPermissao;
    @FXML
    private TableColumn tcNome;
    @FXML
    private TableColumn tcCpf;
    @FXML
    private TextField tfcod;
    @FXML
    private VBox vboxdados;

//</editor-fold>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoInicial();
        mascara();
        Carregadores.carregaPermissao(cbpermissao);
        carregaTabela("");

    }

    private void carregaTabela(String filtro) {
        CtrUsuario ctr = new CtrUsuario();
        ArrayList<Usuario> usuarios = ctr.getUsuarios(filtro);
        ObservableList<Usuario> modelo;
        modelo = FXCollections.observableArrayList(usuarios);
        tv.setItems(modelo);
        
        tcCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        tcLogin.setCellValueFactory(new PropertyValueFactory("login"));
        tcNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcPermissao.setCellValueFactory(new PropertyValueFactory("permissao"));
    }

    //<editor-fold defaultstate="collapsed" desc="Estados de layout">
    private void mascara() {
        MaskFieldUtil.cpfField(tfcpf);
        MaskFieldUtil.foneField(tftelefone);
    }

    private void limpaCampos() {
        tfcpf.setText("");
        tflogin.setText("");
        tfnome.setText("");
        tfrg.setText("");
        tfsenha.setText("");
        tftelefone.setText("");
        tfbusca.setText("");
        cbpermissao.setValue("");
    }

    private void estadoInicial() {
        //if (Acesso.getPermissao() == -1) {
        //textfields
        vboxdados.setDisable(true);

        //botões
        btalterar.setDisable(true);
        btapagar.setDisable(true);
        btcancelar.setDisable(false);
        btconfirmar.setDisable(true);
        btnovo.setDisable(false);
        btbusca.setDisable(true);

        //tabela e busca
        vbBuscaTable.setDisable(true);

        //código
        tfcod.setDisable(true);

        estadoInicialLabel();
        estadoInicialTextField();
        //}

    }

    private void estadoEdicao() {
        btalterar.setDisable(true);
        btapagar.setDisable(true);
        btcancelar.setDisable(false);
        btconfirmar.setDisable(false);
        btnovo.setDisable(true);
        btbusca.setDisable(true);
        vboxdados.setDisable(false);
    }

    /*Talvez n precise
    private void estadoBusca() {
        btalterar.setDisable(false);
        btapagar.setDisable(false);
        btcancelar.setDisable(false);
        btconfirmar.setDisable(false);
        btnovo.setDisable(false);
        btbusca.setDisable(false);
    }
     */
    private void estadoInicialLabel() {
        lbcpf.setStyle("-fx-text-fill: black;");
        lblogin.setStyle("-fx-text-fill: black;");
        lbnome.setStyle("-fx-text-fill: black;");
        lbpermissao.setStyle("-fx-text-fill: black;");
        lbrg.setStyle("-fx-text-fill: black;");
        lbsenha.setStyle("-fx-text-fill: black;");
        lbtelefone.setStyle("-fx-text-fill: black;");
    }

    private void estadoInicialTextField() {
        tfcpf.setStyle("-fx-border-width: 0;");
        tflogin.setStyle("-fx-border-width: 0;");
        tfnome.setStyle("-fx-border-width: 0;");
        tfrg.setStyle("-fx-border-width: 0;");
        tfsenha.setStyle("-fx-border-width: 0;");
        tftelefone.setStyle("-fx-border-width: 0;");
    }
//</editor-fold>

    private boolean verificação() {
        int flag = 0;
        if (tfcpf.getText().isEmpty()) {
            lbcpf.setStyle("-fx-text-fill: red;");
            tfcpf.setStyle("-fx-text-box-border: red;");
            flag = 1;
        }
        if (tflogin.getText().isEmpty()) {
            lblogin.setStyle("-fx-text-fill: red;");
            tflogin.setStyle("-fx-text-box-border: red;");
            flag = 1;
        } else {
            if (new CtrUsuario().verificaUsuárioSenha(tflogin.getText(), "")) {
                lblogin.setStyle("-fx-text-fill: red;");
                tflogin.setStyle("-fx-text-box-border: red;");
                JOptionPane.showMessageDialog(null, "Este login já existe! Tente outro.");
                flag = 1;
            }
        }
        if (tfnome.getText().isEmpty()) {
            lbnome.setStyle("-fx-text-fill: red;");
            tfnome.setStyle("-fx-text-box-border: red;");
            flag = 1;
        }
        if (tfrg.getText().isEmpty()) {
            lbrg.setStyle("-fx-text-fill: red;");
            tfrg.setStyle("-fx-text-box-border: red;");
            flag = 1;
        }
        if (tfsenha.getText().isEmpty()) {
            lbsenha.setStyle("-fx-text-fill: red;");
            tfsenha.setStyle("-fx-text-box-border: red;");
            flag = 1;
        }
        if (tftelefone.getText().isEmpty()) {
            lbtelefone.setStyle("-fx-text-fill: red;");
            tftelefone.setStyle("-fx-text-box-border: red;");
            flag = 1;
        }
        if (cbpermissao.getValue() == null) {
            lbpermissao.setStyle("-fx-text-fill: red;");
            cbpermissao.setStyle("-fx-border-color: red;");
            flag = 1;
        }
        if (flag == 1) {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
            return false;
        } else {
            return true;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Clk events">
    @FXML
    private void clknovo(ActionEvent event) {
        estadoEdicao();
        limpaCampos();
        estadoInicialLabel();
        estadoInicialTextField();

    }

    @FXML
    private void clkalterar(ActionEvent event) {
        estadoEdicao();
        estadoInicialLabel();
        estadoInicialTextField();
    }

    @FXML
    private void clkapagar(ActionEvent event) {
        if (JOptionPane.showConfirmDialog(null, "Certeza que deseja excluir este registro?") == 0) {
            //excluir
        } else {
            //cancelar
        }
    }

    @FXML
    private void clkconfirmar(ActionEvent event) {
        if (verificação()) {
            if (tfcod.getText().compareTo("") == 0) { //esta gravando 
                new CtrUsuario().gravar(cbpermissao.getSelectionModel().getSelectedIndex(),
                        tfnome.getText(), tfcpf.getText(), tfrg.getText(),
                        tftelefone.getText(), tflogin.getText(),
                        tfsenha.getText());
            } else { //esta editando
                new CtrUsuario().alterar(Integer.parseInt(tfcod.getText()),
                        cbpermissao.getSelectionModel().getSelectedIndex(),
                        tfnome.getText(), tfcpf.getText(), tfrg.getText(),
                        tftelefone.getText(), tflogin.getText(),
                        tfsenha.getText());
            }
        }
    }

    @FXML
    private void clkcancelar(ActionEvent event) {
        limpaCampos();
        estadoInicial();

        /*
        JOptionPane.showMessageDialog(null, "Fechar tela. Tratar permissao");
        if(Acesso.getPermissao()==-1)
            JOptionPane.showMessageDialog(null, "fechar o sistema todo");
        else
            JOptionPane.showMessageDialog(null, tv);*/
    }

    //</editor-fold>
    @FXML
    private void clkteste(ActionEvent event) {
        System.out.println(cbpermissao.getSelectionModel().getSelectedIndex());
    }
}
