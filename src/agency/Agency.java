package agency;

import agency.controllers.CtrUsuario;
import agency.db.Banco;
import agency.ui.util.Acesso;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Agency extends Application {
    public static Acesso a = new Acesso();
    @Override
    public void start(Stage stage) throws Exception {        
         if (Banco.con.getMaxPK("usuario", "usu_cod") == 0) {
            CtrUsuario c = new CtrUsuario();
            c.gravar(-1, "Administrador", "", "", "", "admin", "admin");
            a.setPermissao(-1);            
            a.setCod(4);
        }
         a.setCod(4);
        //tentar verificar a permissão do usuario aqui
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadArtista.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadEvento.fxml"));
/*99%*/// Parent root = FXMLLoader.load(getClass().getResource("ui/TelaLogin.fxml"));
/*80%*/ Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadUsuario.fxml"));


        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

//        <editor-fold defaultstate="collapsed" desc="Usuario Teste">
//        Usuario u /*= new Usuario(0, STYLESHEET_MODENA, STYLESHEET_CASPIAN,
//                STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA,
//                STYLESHEET_MODENA)*/;
//        //u.gravar();
//        u = new Usuario(1, 0, "Estilo Merda", "lalalalalalala",
//                "lalala", "lalala", "lalala",
//                "lalala");
//        u.alterar();
//        </editor-fold>
    }

    public static void main(String[] args) {
        if (Banco.conectar()) {
            launch(args);
        }
    }

}
