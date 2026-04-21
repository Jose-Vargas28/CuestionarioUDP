package entidades;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

    public String enviar(String mensaje) throws Exception {

        DatagramSocket socket = new DatagramSocket();
        InetAddress host = InetAddress.getByName("localhost");

        byte[] buffer = mensaje.getBytes();
        DatagramPacket paquete = new DatagramPacket(
                buffer, buffer.length, host, 5000
        );

        socket.send(paquete);

        byte[] bufferR = new byte[1024];
        DatagramPacket respuesta = new DatagramPacket(bufferR, bufferR.length);
        socket.receive(respuesta);

        socket.close();

        return new String(
                respuesta.getData(), 0, respuesta.getLength()
        );
    }
}