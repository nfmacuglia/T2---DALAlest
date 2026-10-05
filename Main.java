import java.util.Scanner;

// Main: lê os valores e testa a fila simples, a fila circular e o dividir.

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Leitura da entrada
        System.out.println("Digite os valores separados por espaço:");

        String linha = teclado.hasNextLine()
                ? teclado.nextLine().trim()
                : "";

        teclado.close();

        // Separa os valores digitados
        String[] valores = linha.isEmpty()
                ? new String[0]
                : linha.split("\\s+");

        // FILA SIMPLES

        FilaSimples fila = new FilaSimples();

        for (String valor : valores) {
            fila.enfileirar(Integer.parseInt(valor));
        }

        System.out.println("\n[Fila simples - FIFO]");
        fila.imprimir();

        // FILA CIRCULAR

        FilaCircular circular = new FilaCircular();

        for (String valor : valores) {
            circular.enfileirar(Integer.parseInt(valor));
        }

        System.out.println("\n[Fila circular - FIFO]");
        circular.imprimir();

        // DIVIDIR

        FilaCircular[] partes = circular.dividir();

        System.out.println("\n[Dividir] posições ímpares:");
        partes[0].imprimir();

        System.out.println("[Dividir] posições pares:");
        partes[1].imprimir();
    }
}