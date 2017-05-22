package agency.ui;

import agency.controllers.CtrUsuario;
import agency.ui.util.Acesso;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        if (!new CtrUsuario().verificaUsuárioSenha(tflogin.getText(), tfsenha.getText())) {
            estadoLoginInvalido();
            estadoSenhaInvalida();
            return false;
        }
        return true;
    }

    @FXML
    private void clkEntrar(ActionEvent event) {
        if (verifica()) {
            agency.Agency.a.setPermissao(new CtrUsuario().getPermissao(tflogin.getText()));
            agency.Agency.a.setCod(new CtrUsuario().getCod(tflogin.getText()));
            if (agency.Agency.a.getPermissao() == -1) {
                JOptionPane.showMessageDialog(null, "Fazer Cadastro de novo usuário.");
                try {

                    Stage palco = (Stage) btentrar.getScene().getWindow();
                    palco.close();
                    palco.setScene(
                            new Scene(
                                    FXMLLoader.load(getClass().getResource("TelaCadUsuario.fxml"))));

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
                    Stage palco = (Stage) btentrar.getScene().getWindow();
                    palco.close();
                    palco.setScene(new Scene(FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"))));
//                    palco.initModality(Modality.APPLICATION_MODAL);
//                    palco.initStyle(StageStyle.UNDECORATED);
//                    palco.setMaximized(true);
//                    palco.showAndWait();
                    palco.show();
                } catch (IOException e) {
                }
            }
        }

    }
}
