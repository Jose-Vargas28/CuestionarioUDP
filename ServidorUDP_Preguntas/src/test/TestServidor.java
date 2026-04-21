package test;

import servidor.ServidorUDP;

public class TestServidor {
    public static void main(String[] args) throws Exception {
        new ServidorUDP().iniciar(5000);
    }
}