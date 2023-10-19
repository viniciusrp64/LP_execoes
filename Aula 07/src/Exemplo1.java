import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exemplo1 {
    public static void main(String[] args) throws IOException {
        String nomeClasse = "Exemplo1";
        System.out.println("Exceções");
        try {
            // Código que pode lançar uma exceção
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            String mensagem = "Ocorreu uma exceção na classe " + nomeClasse + ": " + e.getMessage();
            System.err.println(mensagem);
            escritor(mensagem);
        }

    }

    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("log.txt", true));
        buffWrite.write(path + "\n");
        buffWrite.close();
    }
}

