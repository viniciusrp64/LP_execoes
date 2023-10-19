import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo5 {
    public static void main(String[] args) {
        String nomeClasse = "Exemplo5";
        String numeroString = "A";  // String que não é um número válido
        //String numeroString = "1";  // String que é um número válido
        converteNumero(numeroString, nomeClasse);
    }
    private static void converteNumero(String numeroString, String nomeClasse) {
        try {
            int numeroInt = Integer.parseInt(numeroString);
            System.out.println("Número convertido: " + numeroInt);
        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão: " + e.getMessage());
            try {
                escritor("Erro de conversão: " + e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        }
    }

    private static void escritor(String mensagem, String nomeClasse) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("log.txt", true));
        buffWrite.write("Ocorreu uma exceção na classe " + nomeClasse + ": " + mensagem + "\n");
        buffWrite.close();
    }
}
