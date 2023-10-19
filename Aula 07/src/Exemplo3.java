import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo3 {
    public static void main(String[] args) {
        String nomeClasse = "Exemplo3";
        try {
            // Código que pode lançar uma exceção
            //int[] array = new int[5];
            //int valor = array[10];
            String x = null;
            System.out.println(x.toUpperCase());
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.err.println("Exceção: " + e.getMessage());
            try {
                escritor("Exceção: " + e.getMessage(), nomeClasse);
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
