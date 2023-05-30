package tad.fila;

public class MinhaFila implements FilaIF<Integer> {

    private int tamanho;
    private int cabeca;
    private int cauda;
    private Integer[] meusDados;

    public MinhaFila(int tamanhoInicial) {
        tamanho = tamanhoInicial;
        meusDados = new Integer[tamanho];
        cabeca = 0;
        cauda = 0;
    }

    public MinhaFila() {
        this(10); // Default size is 10
    }

    @Override
    public void enfileirar(Integer item) throws FilaCheiaException {
        if (isFull()) {
            throw new FilaCheiaException("A fila está cheia");
        }

        meusDados[cauda] = item;
        cauda = (cauda + 1) % tamanho;
    }

    @Override
    public Integer desenfileirar() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException("A fila está vazia");
        }

        Integer valorDesenfileirado = meusDados[cabeca];
        meusDados[cabeca] = null;
        cabeca = (cabeca + 1) % tamanho;

        return valorDesenfileirado;
    }

    @Override
    public Integer verificarCauda() {
        if (isEmpty()) {
            return null;
        }

        int caudaAnterior = (cauda - 1 + tamanho) % tamanho;
        return meusDados[caudaAnterior];
    }

    @Override
    public Integer verificarCabeca() {
        if (isEmpty()) {
            return null;
        }

        return meusDados[cabeca];
    }

    @Override
    public boolean isEmpty() {
        return cabeca == cauda;
    }

    @Override
    public boolean isFull() {
        return (cauda + 1) % tamanho == cabeca;
    }
}
