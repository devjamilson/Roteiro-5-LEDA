package tad.conjuntoDinamico;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

    private List<Integer> elementos;

    public MeuConjuntoDinamico() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public void inserir(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (!elementos.contains(item)) {
            elementos.add(item);
        }
    }

    @Override
    public Integer remover(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (elementos.isEmpty()) {
            throw new NoSuchElementException("Conjunto vazio, não é possível remover.");
        }

        boolean removed = elementos.remove(item);
        if (removed) {
            return item;
        } else {
            throw new NoSuchElementException("Item não encontrado no conjunto.");
        }
    }

    @Override
    public Integer predecessor(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (elementos.isEmpty()) {
            throw new UnsupportedOperationException("Conjunto vazio, não é possível obter o predecessor.");
        }

        int index = elementos.indexOf(item);
        if (index == -1) {
            throw new UnsupportedOperationException("Item não encontrado no conjunto.");
        }

        if (index > 0) {
            return elementos.get(index - 1);
        }

        return null;
    }

    @Override
    public Integer sucessor(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (elementos.isEmpty()) {
            throw new UnsupportedOperationException("Conjunto vazio, não é possível obter o sucessor.");
        }

        int index = elementos.indexOf(item);
        if (index == -1) {
            throw new UnsupportedOperationException("Item não encontrado no conjunto.");
        }

        if (index < elementos.size() - 1) {
            return elementos.get(index + 1);
        }

        return null;
    }

    @Override
    public int tamanho() {
        return elementos.size();
    }

    @Override
    public Integer buscar(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (elementos.contains(item)) {
            return item;
        }

        throw new NoSuchElementException("Item não encontrado no conjunto.");
    }

    @Override
    public Integer minimum() {
        if (elementos.isEmpty()) {
            throw new UnsupportedOperationException("Conjunto vazio, não é possível obter o mínimo.");
        }

        return elementos.stream().min(Integer::compareTo).get();
    }

    @Override
    public Integer maximum() {
        if (elementos.isEmpty()) {
            throw new UnsupportedOperationException("Conjunto vazio, não é possível obter o máximo.");
        }

        return elementos.stream().max(Integer::compareTo).get();
    }
}