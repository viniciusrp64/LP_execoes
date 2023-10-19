import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Exemplo2 {
    public static void main(String[] args) {
        String nomeClasse = "Exemplo2";
        try {
            // Código que pode lançar uma exceção
            FileReader file = new FileReader("arquivo.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
            try {
                escritor("Arquivo não encontrado: " + e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        } catch(Exception e){
            System.err.println("Minha exceção pai: " + e.getMessage());
            try {
                escritor("Minha exceção pai: " + e.getMessage(), nomeClasse);
            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo de log: " + ex.getMessage());
            }
        }
    }

    public static void escritor(String mensagem, String nomeClasse) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("log2.txt", true));
        buffWrite.write("Ocorreu uma exceção na classe " + nomeClasse + ": " + mensagem + "\n");
        buffWrite.close();
    }
}
