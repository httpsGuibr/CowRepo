package game;

public class Timer {

    private int[] timerArray; // Array para armazenar os segundos
    private static int duration;     // Duração em segundos
    public boolean running;         // Variável para controlar o estado do timer
    static int i = 0;
    public Timer(int duration) {
        Timer.duration = duration;
        timerArray = new int[duration];  // Define o tamanho do array baseado na duração
        running = true;  // Inicialmente, o timer está rodando
    }

    // Inicia o timer
    public void start() {
        for (i = 0; i < duration; i++) {
            if (!running) {
                System.out.println("Timer pausado.");
                break; // Sai do loop se o timer estiver pausado
            }

            timerArray[i] = duration - i;  // Preenche o array com o número de segundos restantes
            //System.out.println("Tempo: " + timerArray[i] + " segundos restantes");

            // Checa se o tempo chegou a 0
            if (timerArray[i] <= 1) {
                // Executa o bloco fornecido
            	stop(); // Para o timer

                return;  // Sai da função após executar o bloco
            }

            try {
                Thread.sleep(1000);  // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (running) {
            System.out.println("Timer finalizado.");
        }
    }

    // Método para parar o timer
    public void stop() {
        running = false;  // Define o estado do timer para pausado
    }

    // Método para obter o tempo restante
    public int getRemainingTime() {
        return timerArray[i] = duration - i; // Retorna o último valor no array se estiver rodando
    }
    // Método para verificar se o timer está rodando
    public boolean isRunning() {
        return running;
    }
}
