package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("João");
        var conta = new Conta(cliente, new BigDecimal(150));

        var operacao = new OperacaoSaque(conta, new BigDecimal(150));

//        Thread saqueDoJoao = new Thread(operacao::executa);
//        Thread saqueDaMaria = new Thread(operacao::executa);

        Thread saqueDoJoao = Thread.startVirtualThread(operacao::executa);
        Thread saqueDaMaria = Thread.startVirtualThread(operacao::executa);

        System.out.println(Thread.currentThread().getName());

        System.out.println("Saldo inicial: " + conta.getSaldo());
//
//        saqueDoJoao.start();
//        saqueDaMaria.start();

        try {
            // Espera threads terminarem
            saqueDoJoao.join();
            saqueDaMaria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
