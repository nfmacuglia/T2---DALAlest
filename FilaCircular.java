
public class FilaCircular {

    private No fim;

    public FilaCircular() {
        fim = null;
    }

    public boolean estaVazia() {
        return fim == null;
    }

    public void enfileirar(int valor) {
        No novo = new No(valor);

        if (estaVazia()) {
            fim = novo;
            fim.prox = fim;
        } else {
            novo.prox = fim.prox;
            fim.prox = novo;
            fim = novo;
        }
    }

    public int desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        No inicio = fim.prox;
        int valor = inicio.valor;

        if (inicio == fim) {
            fim = null;
        } else {
            fim.prox = inicio.prox;
        }

        return valor;
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }

        No atual = fim.prox;

        do {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        } while (atual != fim.prox);

        System.out.println();
    }
}
