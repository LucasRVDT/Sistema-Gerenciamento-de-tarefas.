package br.edu.iff.ccc.bsi.webdev.exceptions;

@SuppressWarnings("serial")
public class TarefaNotFoundException extends RuntimeException {

    public TarefaNotFoundException() {
        super("Erro ao buscar tarefa");
    }

    public TarefaNotFoundException(String message) {
        super(message);
    }
}