package controlador;

import entidades.ClienteUDP;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorCuestionario {

    @FXML private Label lblPregunta;
    @FXML private Label lblResultado;
    @FXML private TextField txtRespuesta;
    @FXML private Button btnValidar;

    private ClienteUDP cliente = new ClienteUDP();
    private int idPreguntaActual;

    @FXML
    private void initialize() {
        btnValidar.setDisable(true); // Bloqueado al inicio
    }

    @FXML
    private void cargarPregunta() {
        try {
            String respuesta = cliente.enviar("PEDIR_PREGUNTA");
            String[] partes = respuesta.split("\\|");

            idPreguntaActual = Integer.parseInt(partes[0]);
            lblPregunta.setText(partes[1]);

            txtRespuesta.clear();          // Limpiar campo
            lblResultado.setText("");      // Limpiar resultado
            lblResultado.setStyle("");     // Quitar color previo
            btnValidar.setDisable(false);  // Habilitar botón

        } catch (Exception e) {
            lblPregunta.setText("Error de conexión");
        }
    }

    @FXML
    private void enviarRespuesta() {
        try {
            String mensaje =
                    "RESPONDER|" + idPreguntaActual + "|" + txtRespuesta.getText();

            String resultado = cliente.enviar(mensaje);

            if (resultado.equalsIgnoreCase("CORRECTO")) {
                lblResultado.setText("CORRECTO ✅");
                lblResultado.setStyle("-fx-text-fill: green;");
            } else {
                lblResultado.setText("INCORRECTO ❌");
                lblResultado.setStyle("-fx-text-fill: red;");
            }

        } catch (Exception e) {
            lblResultado.setText("Error al validar");
            lblResultado.setStyle("-fx-text-fill: black;");
        }
    }
}