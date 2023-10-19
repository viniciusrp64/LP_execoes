import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo6 {
    public static void main(String[] args) {
        String nomeClasse = "Exemplo6";
        try {
            verificarValor();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            try {
                escritor(e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            try {
                escritor(e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                escritor(e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        }
    }

    private static void verificarValor() throws IllegalArgumentException {
        int valor = -10;
        if (valor < 0) {
            throw new IllegalArgumentException("ABCDEFG 900: O valor não pode ser negativo.");
        }
    }

    private static void escritor(String mensagem, String nomeClasse) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("log.txt", true));
        buffWrite.write("Ocorreu uma exceção na classe " + nomeClasse + ": " + mensagem + "\n");
        buffWrite.close();
    }
}
