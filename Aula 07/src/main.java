import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        // Exemplo1
        try {
            divisao(4, 0);
        } catch (ArithmeticException e) {
            System.err.println("Erro de divisão: " + e.getMessage());
            escreverNoLog("Erro de divisão: " + e.getMessage());
        }

        // Exemplo2
        try {
            int[] vetor = new int[3];
            vetor[4] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro de índice: " + e.getMessage());
            escreverNoLog("Erro de índice: " + e.getMessage());
        }

        // Exemplo3
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.err.println("Erro de ponteiro nulo: " + e.getMessage());
            escreverNoLog("Erro de ponteiro nulo: " + e.getMessage());
        }

        // Exemplo4
        try {
            String numeroString = "A";  // String que não é um número válido
            //String numeroString = "1";  // String que é um número válido
            converteNumero(numeroString);
        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão: " + e.getMessage());
            escreverNoLog("Erro de conversão: " + e.getMessage());
        }
    }

    private static void divisao(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisão por zero.");
        }
        int resultado = dividendo / divisor;
        System.out.println("Resultado da divisão: " + resultado);
    }

    private static void converteNumero(String numeroString) {
        int numeroInt = Integer.parseInt(numeroString);
        System.out.println("Número convertido: " + numeroInt);
    }

    private static void escreverNoLog(String mensagem) {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter("log.txt", true))) {
            buffWrite.write(mensagem + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
