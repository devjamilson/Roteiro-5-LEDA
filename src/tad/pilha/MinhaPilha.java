package tad.pilha;

public class MinhaPilha<T> implements PilhaIF<T> {

    private int tamanho;
    private Object[] elementos;
    private int topo;

    public MinhaPilha(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new Object[tamanho];
        this.topo = -1;
    }

    public MinhaPilha() {
        this(10); // Default size of 10
    }

    @Override
    public void empilhar(T item) throws PilhaCheiaException {
        if (estaCheia()) {
            throw new PilhaCheiaException("A pilha está cheia");
        }
        
        topo++;
        elementos[topo] = item;
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        
        T itemDesempilhado = (T) elementos[topo];
        elementos[topo] = null;
        topo--;
        return itemDesempilhado;
    }

    @Override
    public T topo() {
        if (estaVazia()) {
            return null;
        }
        
        return (T) elementos[topo];
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    @Override
    public boolean estaCheia() {
        return topo == tamanho - 1;
    }

    @Override
    public PilhaIF<T> multitop(T elemento) {
        PilhaIF<T> novaPilha = new MinhaPilha<>();
        
        while (!estaVazia()) {
            T item = desempilhar();
            novaPilha.empilhar(item);
            
            if (item.equals(elemento)) {
                break;
            }
        }
        
        while (!novaPilha.estaVazia() && !novaPilha.topo().equals(elemento)) {
            novaPilha.desempilhar();
        }
        
        return novaPilha;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        MinhaPilha<?> outraPilha = (MinhaPilha<?>) obj;
        
        if (topo != outraPilha.topo) {
            return false;
        }
        
        for (int i = 0; i <= topo; i++) {
            if (!elementos[i].equals(outraPilha.elementos[i])) {
                return false;
            }
        }
        
        return true;
    }
}