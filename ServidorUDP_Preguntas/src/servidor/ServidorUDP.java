package servidor;

import entidades.BancoPreguntas;
import entidades.Pregunta;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

    private BancoPreguntas banco = new BancoPreguntas();

    public void iniciar(int puerto) throws Exception {

        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor de preguntas UDP activo...");

        while (true) {

            byte[] buffer = new byte[1024];
            DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
            socket.receive(entrada);

            String mensaje = new String(
                    entrada.getData(), 0, entrada.getLength()
            );

            String respuesta;

            if (mensaje.equals("PEDIR_PREGUNTA")) {
                Pregunta p = banco.obtenerPreguntaAleatoria();
                respuesta = p.getId() + "|" + p.getEnunciado();

            } else if (mensaje.startsWith("RESPONDER")) {

                String[] partes = mensaje.split("\\|");
                int id = Integer.parseInt(partes[1]);
                String respuestaUsuario = partes[2];

                Pregunta p = banco.obtenerPregunta(id);

                if (p != null && p.validarRespuesta(respuestaUsuario)) {
                    respuesta = "CORRECTO";
                } else {
                    respuesta = "INCORRECTO";
                }

            } else {
                respuesta = "ERROR";
            }

            byte[] bufferSalida = respuesta.getBytes();
            DatagramPacket salida = new DatagramPacket(
                    bufferSalida,
                    bufferSalida.length,
                    entrada.getAddress(),
                    entrada.getPort()
            );

            socket.send(salida);
        }
    }
}