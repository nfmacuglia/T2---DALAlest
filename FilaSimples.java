public class FilaSimples {
    private No cabeca;
    private No cauda;

    public FilaSimples() {
        cabeca = null;
        cauda = null;
    }

    
    public boolean estaVazia() {
        return cabeca == null;
    }

   
    public void enfileirar(int valor) {
        No novo = new No(valor);

        if (estaVazia()) {
           
            cabeca = novo;
            cauda = novo;
        } else {
            
            cauda.prox = novo;
            cauda = novo;
        }
    }

    
    public int desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        int valor = cabeca.valor;

        
        cabeca = cabeca.prox;

        
        if (cabeca == null) {
            cauda = null;
        }

        return valor;
    }

    
    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }

        No atual = cabeca;

        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }

        System.out.println();
    }
}