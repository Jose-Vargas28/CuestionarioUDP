package entidades;

import java.util.ArrayList;
import java.util.List;

public class BancoPreguntas {

    private List<Pregunta> preguntas = new ArrayList<>();

    public BancoPreguntas() {
        preguntas.add(new Pregunta(
                1,
                "¿Qué es un requisito funcional?",
                "Es una función que debe cumplir el sistema"
        ));

        preguntas.add(new Pregunta(
                2,
                "¿Qué es el ciclo de vida del software?",
                "Son las etapas por las que pasa un software desde su creación hasta su mantenimiento"
        ));
    }

    public Pregunta obtenerPregunta(int id) {
        for (Pregunta p : preguntas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Pregunta obtenerPreguntaAleatoria() {
        return preguntas.get((int) (Math.random() * preguntas.size()));
    }
}