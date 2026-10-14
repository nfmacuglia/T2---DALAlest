
public class FilaCircular {

    private No cauda;

    public FilaCircular() {
        cauda = null;
    }

    public boolean estaVazia() {
        return cauda == null;
    }

    public void enfileirar(int valor) {
        No novo = new No(valor);

        if (estaVazia()) {
            cauda = novo;
            cauda.prox = cauda;
        } else {
            novo.prox = cauda.prox;
            cauda.prox = novo;
            cauda = novo;
        }
    }

    public int desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        No inicio = cauda.prox;
        int valor = inicio.valor;

        if (inicio == cauda) {
            cauda = null;
        } else {
            cauda.prox = inicio.prox;
        }

        return valor;
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }

        No atual = cauda.prox;

        do {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        } while (atual != cauda.prox);

        System.out.println();
    }
}
