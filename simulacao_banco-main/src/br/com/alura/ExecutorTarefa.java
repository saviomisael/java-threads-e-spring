package br.com.alura;

public class ExecutorTarefa implements Runnable {
    private static int CONTADOR = 0;

    @Override
    public void run() {
        CONTADOR++;
        System.out.println("Tarefa número " + CONTADOR + " inicializada");
    }
}
