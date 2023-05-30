package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T> {

    private NodoListaEncadeada<T> cabeca;
    private NodoListaEncadeada<T> cauda;
    private int tamanho;

    public ListaEncadeadaImpl() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public NodoListaEncadeada<T> search(T chave) {
        NodoListaEncadeada<T> current = cabeca;

        while (current != null && !current.getChave().equals(chave)) {
            current = current.getProximo();
        }

        return current;
    }

    @Override
    public void insert(T chave) {
        NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);

        if (isEmpty()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        }

        tamanho++;
    }

    @Override
    public NodoListaEncadeada<T> remove(T chave) {
        if (isEmpty()) {
            return null;
        }

        NodoListaEncadeada<T> removedNode = null;

        if (cabeca.getChave().equals(chave)) {
            removedNode = cabeca;
            cabeca = cabeca.getProximo();
            if (cabeca == null) {
                cauda = null;
            }
        } else {
            NodoListaEncadeada<T> current = cabeca;
            NodoListaEncadeada<T> previous = null;

            while (current != null && !current.getChave().equals(chave)) {
                previous = current;
                current = current.getProximo();
            }

            if (current != null) {
                removedNode = current;
                previous.setProximo(current.getProximo());
                if (current == cauda) {
                    cauda = previous;
                }
            }
        }

        if (removedNode != null) {
            tamanho--;
        }

        return removedNode;
    }

    @Override
    public T[] toArray(Class<T> clazz) {
        throw new UnsupportedOperationException("Precisa implementar!");
    }

    @Override
    public String imprimeEmOrdem() {
        StringBuilder values = new StringBuilder();
        NodoListaEncadeada<T> current = cabeca;

        while (current != null) {
            values.append(current.getChave()).append(", ");
            current = current.getProximo();
        }

        if (values.length() > 2) {
            values.setLength(values.length() - 2);
        }

        return values.toString();
    }

    @Override
    public String imprimeInverso() {
        StringBuilder values = new StringBuilder();
        NodoListaEncadeada<T> current = cauda;

        while (current != null) {
            values.append(current.getChave()).append(", ");
            current = current.getAnterior();
        }

        if (values.length() > 2) {
            values.setLength(values.length() - 2);
        }

        return values.toString();
    }

    @Override
    public NodoListaEncadeada<T> sucessor(T chave) {
        throw new UnsupportedOperationException("Precisa implementar!");
    }

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

}
