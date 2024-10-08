package game;

public class Util {
    public static void wait(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void preencherVetor(double[][] operacao_saida) {
        for (int x = 0; x < 1000; x++) {
            operacao_saida[x][0] = 0.0;
            operacao_saida[x][1] = 0.0;
        }
    }
}

