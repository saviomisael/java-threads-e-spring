package br.com.alura;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteMultiplasThreads {
    public static void main(String[] args) {
        Instant inicio = Instant.now();

        try (
//                ExecutorService executorService = Executors.newFixedThreadPool(10)
//                 e.g. a cada 100 threads virtuais é utilizado apenas 1 thread do so
                ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor() // mais rápidas / não mapeia threads para o sistema operacional
        ) {
            for (int i = 1; i <= 10000; i++) {
                var tarefa = new ExecutorTarefa();

                executorService.execute(tarefa);
            }
        }

        Instant fim = Instant.now();

        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Duração em segundos: " + duracao.getSeconds());
    }
}
