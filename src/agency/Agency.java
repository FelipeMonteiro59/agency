package agency;

import agency.db.Banco;
import agency.entity.Usuario;
import agency.ui.util.Acesso;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Agency extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //tentar verificar a permissão do usuario aqui
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadArtista.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadEvento.fxml"));
/*99%*/// Parent root = FXMLLoader.load(getClass().getResource("ui/TelaLogin.fxml"));
/*80%*/ Parent root = FXMLLoader.load(getClass().getResource("ui/TelaCadUsuario.fxml"));

        Acesso.setPermissao(-1);
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
