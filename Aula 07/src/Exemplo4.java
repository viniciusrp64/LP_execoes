import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo4 {
    public static void main(String[] args) {
        String nomeClasse = "Exemplo4";
        try {
            // Código que pode lançar uma exceção
            // ...
        } catch (Exception e) {
            System.err.println("Exceção: " + e.getMessage());
            try {
                escritor("Exceção: " + e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        } finally {
            // Código a ser executado sempre, mesmo se ocorrer uma exceção
            System.out.println("Bloco finally executado.");
            try {
                escritor("Bloco finally executado.", nomeClasse);
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
