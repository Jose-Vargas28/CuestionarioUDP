package entidades;

public class Pregunta {

    private int id;
    private String enunciado;
    private String respuestaCorrecta;

    public Pregunta(int id, String enunciado, String respuestaCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean validarRespuesta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());
    }
}