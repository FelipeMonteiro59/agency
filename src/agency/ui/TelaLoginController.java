package agency.ui;

import agency.controllers.CtrUsuario;
import agency.db.Banco;
import agency.ui.util.Acesso;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class TelaLoginController implements Initializable {
//<editor-fold defaultstate="collapsed" desc="FMXL VARS">
    @FXML
    private Button btentrar;
    @FXML
    private Button btcancelar;
    @FXML
    private Label lbverilogin;
    @FXML
    private Label lbverisenha;
    @FXML
    private TextField tflogin;
    @FXML
    private TextField tfsenha;
//</editor-fold>
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoInicial();
        if (Banco.con.getMaxPK("usuario", "usu_cod") == 0) {
            CtrUsuario c = new CtrUsuario();
            c.gravar(-1, "Administrador", "", "", "", "admin", "admin");
            Acesso.setPermissao(-1);
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="States">
    private void estadoInicial() {
        lbverilogin.setVisible(false);
        lbverisenha.setVisible(false);
       
        tflogin.setStyle("-fx-border-width: 0;");
        tfsenha.setStyle("-fx-border-width: 0;");
    }
    
    private void estadoLoginInvalido() {
        lbverilogin.setVisible(true);
        tflogin.setStyle("-fx-text-box-border: red;");
    }

    private void estadoSenhaInvalida() {
        lbverisenha.setVisible(true);
        tfsenha.setStyle("-fx-text-box-border: red;");
    }
    //</editor-fold>

    private boolean verifica() {
        //verificacões
        estadoInicial();
        int flag = new CtrUsuario().verificaUsuárioSenha(tflogin.getText(), tfsenha.getText());
        switch (flag) {
            case 1:
                estadoLoginInvalido();
                JOptionPane.showMessageDialog(null, "Login Inválido!");
                return false;
            case 2:
                estadoSenhaInvalida();
                JOptionPane.showMessageDialog(null, "Senha inválida!");
                return false;
            case 0:
                JOptionPane.showMessageDialog(null, "Acertou miserávi!");
                return true;
            default:
                estadoLoginInvalido();
                estadoSenhaInvalida();
                JOptionPane.showMessageDialog(null, "Login ou senha inválidos!");
                return false;
        }
    }
    
    @FXML
    private void clkEntrar(ActionEvent event) {
        if (verifica()) {
            Acesso.setPermissao(new CtrUsuario().getPermissao(tflogin.getText()));
            Acesso.setCod(new CtrUsuario().getCod(tflogin.getText()));
            if (Acesso.getPermissao() == -1) {
                JOptionPane.showMessageDialog(null, "Fazer Cadastro de novo usuário.");
                try {
                    Platform.exit();
                    Stage palco = new Stage();
                    palco.setScene(new Scene(FXMLLoader.load(getClass().getResource("TelaCadUsuario.fxml"))));
                    //palco.initModality(Modality.APPLICATION_MODAL);
                    //palco.initStyle(StageStyle.UNDECORATED);
                    //palco.setMaximized(true);
                    //palco.showAndWait();
                    palco.show();
                } catch (IOException e) {
                }

            } else {
                JOptionPane.showMessageDialog(null, "Execução normal com controle de acesso.");
                try {
                    Stage palco = new Stage();
                    palco.setScene(new Scene(FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"))));
                    palco.initModality(Modality.APPLICATION_MODAL);
                    palco.initStyle(StageStyle.UNDECORATED);
                    palco.setMaximized(true);
                    palco.showAndWait();
                } catch (IOException e) {
                }
            }
        }

    }
}
