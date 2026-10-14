import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
 
        // 1. Ler a linha digitada
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite os valores separados por espaço:");
        String linha = teclado.nextLine().trim();
        teclado.close();
 
        // 2. Criar as duas filas
        FilaSimples fila = new FilaSimples();
        FilaCircular circular = new FilaCircular();
 
        // 3. Separar os valores e colocar nas duas filas
        //    (se a linha estiver vazia, as filas ficam vazias)
        if (!linha.equals("")) {
            String[] valores = linha.split("\\s+");
 
            for (int i = 0; i < valores.length; i++) {
                int numero = Integer.parseInt(valores[i]);
                fila.enfileirar(numero);
                circular.enfileirar(numero);
            }
        }
 
        // 4. Imprimir a fila simples
        System.out.println("\n[Fila simples - FIFO]");
        fila.imprimir();
 
        // 5. Imprimir a fila circular
        System.out.println("\n[Fila circular - FIFO]");
        circular.imprimir();
 
        // 6. Dividir a fila circular e imprimir as duas partes
        FilaCircular[] partes = circular.dividir();
 
        System.out.println("\n[Dividir] posições ímpares:");
        partes[0].imprimir();
 
        System.out.println("[Dividir] posições pares:");
        partes[1].imprimir();
    }
}