import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/vista/cuestionario.fxml")
        );

        Scene scene = new Scene(loader.load());

        // Configurar la ventana
        stage.setTitle("Cuestionario UDP - Desarrollo de Software");
        stage.setScene(scene);
        stage.setResizable(false); // opcional
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
