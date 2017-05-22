package agency.ui;

import agency.ui.util.Acesso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

public class TelaPrincipalController implements Initializable {

    @FXML
    private Label lbLogin;
    @FXML
    private Accordion pnMenu;
    @FXML
    private TitledPane tpCadastro;
    @FXML
    private TitledPane tpInscricao;
    @FXML
    private TitledPane tpPresenca;
    @FXML
    private TitledPane tpImpresso;
    @FXML
    private TitledPane tpUtilitarios;
    @FXML
    private TitledPane tpAjuda;
    @FXML
    private HBox pnDados;
    @FXML
    private Label lbUsuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switch(agency.Agency.a.getPermissao()){
            case 0://permissão 0
                 
                break;
            case 1://permissão 1
                
                break;
            case -1://permissão -1
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Switch default.");
        }
    }

    @FXML
    private void btnFechar(ActionEvent event) {
    }

    @FXML
    private void mouseDragged(MouseEvent event) {
    }

    @FXML
    private void mousePassed(MouseEvent event) {
    }

    @FXML
    private void clkAlunos(MouseEvent event) {
    }

    @FXML
    private void clkAtividades(MouseEvent event) {
    }

    @FXML
    private void clkCursos(MouseEvent event) {
    }

    @FXML
    private void clkEvento(MouseEvent event) {
    }

    @FXML
    private void clkAdesao(MouseEvent event) {
    }

    @FXML
    private void clkFuncionarios(MouseEvent event) {
    }

    @FXML
    private void clkProfessor(MouseEvent event) {
    }

    @FXML
    private void clkTipoAtividades(MouseEvent event) {
    }

    @FXML
    private void clkNovaInscricao(MouseEvent event) {
    }

    @FXML
    private void clkAbrirInscricao(MouseEvent event) {
    }

    @FXML
    private void clkEmitirLista(MouseEvent event) {
    }

    @FXML
    private void clkLancarFaltas(MouseEvent event) {
    }

    @FXML
    private void clkRelatorioBasico(MouseEvent event) {
    }

    @FXML
    private void clkRelatorioAnaliticos(MouseEvent event) {
    }

    @FXML
    private void clkBackup(MouseEvent event) {
    }

    @FXML
    private void clkRestauracao(MouseEvent event) {
    }

    @FXML
    private void clkUsuario(MouseEvent event) {
        
    }

}
