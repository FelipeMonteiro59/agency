package agency.ui.util;

import agency.controllers.CtrCidade;
import agency.controllers.CtrEstado;
import agency.entity.Cidade;
import agency.entity.Estado;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public abstract class Carregadores {
    
    public static void carregaPermissao(ComboBox cbpermissao){
        ArrayList<String> a = new ArrayList();
        a.add("Administrador");
        a.add("Usuário");
        ObservableList<String> modelo = FXCollections.observableArrayList(a);
        cbpermissao.setItems(modelo);
    }

    public static void carregaGenero(ComboBox cbgenero) {
        ArrayList<String> a = new ArrayList();
        a.add("Masculino");
        a.add("Feminino");
        ObservableList<String> modelo = FXCollections.observableArrayList(a);
        cbgenero.setItems(modelo);
    }

    public static void carregaUF(ComboBox cbuf) {
        CtrEstado ctre = new CtrEstado();
        ArrayList<Estado> est = ctre.get("");
        ObservableList<Estado> modelos;
        modelos = FXCollections.observableArrayList(est);
        cbuf.setItems(modelos);
        cbuf.setValue(null);
        //cbuf.setOnAction(e -> carregaCidade());
    }

    public static void carregaCidade(ComboBox cbuf, ComboBox cbcidade) {
        CtrCidade ctrc = new CtrCidade();
        CtrEstado ctre = new CtrEstado();
        ArrayList<Estado> est = new CtrEstado().get("est_sgl = '"
                + ctre.getSigla((Estado) cbuf.getValue()) + "'");//Estado selecionado
        ArrayList<Cidade> cid = ctrc.get("est_cod = "
                + ctre.getCod(est.get(0)));//cod do estado selecionado
        ObservableList<Cidade> modelos;
        modelos = FXCollections.observableArrayList(cid);
        cbcidade.setItems(modelos);
        cbcidade.setValue(null);
    }

}
