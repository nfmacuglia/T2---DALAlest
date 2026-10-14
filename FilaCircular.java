public class FilaCircular {

    private No cauda;

    public FilaCircular() {
        cauda = null;
    }

    public boolean estaVazia() {
        if (cauda == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enfileirar(int valor) {
        No novo = new No(valor);

        if (cauda == null) {
            cauda = novo;
            cauda.prox = novo;
        } else {
            novo.prox = cauda.prox;
            cauda.prox = novo;
            cauda = novo;
        }
    }

    public int desenfileirar() {
        if (cauda == null) {
            System.out.println("Fila vazia");
            return -1;
        }

        No primeiro = cauda.prox;
        int valor = primeiro.valor;

        if (primeiro == cauda) {
            cauda = null;
        } else {
            cauda.prox = primeiro.prox;
        }

        return valor;
    }

    public void imprimir() {
        if (cauda == null) {
            System.out.println("Fila vazia");
        } else {
            No atual = cauda.prox;

            while (atual != cauda) {
                System.out.print(atual.valor + " ");
                atual = atual.prox;
            }

            System.out.println(cauda.valor);
        }
    }

    public FilaCircular[] dividir() {
        FilaCircular impares = new FilaCircular();
        FilaCircular pares = new FilaCircular();

        if (cauda == null) {
            return new FilaCircular[] { impares, pares };
        }

        No ultimo = cauda;      
        No atual = cauda.prox;  

        No primeiroImpar = null;
        No ultimoImpar = null;
        No primeiroPar = null;
        No ultimoPar = null;

        boolean ehImpar = true; 
        boolean terminou = false;

        while (!terminou) {
            No proximo = atual.prox;

            if (atual == ultimo) {
                terminou = true;
            }

            if (ehImpar) {
                if (ultimoImpar == null) {
                    primeiroImpar = atual;      
                } else {
                    ultimoImpar.prox = atual;
                }
                ultimoImpar = atual;
            } else {
             
                if (ultimoPar == null) {
                    primeiroPar = atual;       
                } else {
                    ultimoPar.prox = atual;
                }
                ultimoPar = atual;
            }

            ehImpar = !ehImpar; 
            atual = proximo;    
        }

        if (ultimoImpar != null) {
            ultimoImpar.prox = primeiroImpar;
        }
        if (ultimoPar != null) {
            ultimoPar.prox = primeiroPar;
        }

        impares.cauda = ultimoImpar;
        pares.cauda = ultimoPar;

        cauda = null; 

        return new FilaCircular[] { impares, pares };
    }
}