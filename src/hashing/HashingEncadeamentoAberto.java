package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto implements EstruturaDeDados{

     private LinkedList<Integer>[] tabela;
    private LinkedList<Integer> porao;

    @SuppressWarnings("unchecked")
    public HashingEncadeamentoAberto() {
        tabela = new LinkedList[1011];
        porao = new LinkedList<>();
    }

    private int hash(int chave) {
        return chave % 1011;
    }

    @Override
    public void insert(int chave) {
        int i = hash(chave);
        if (tabela[i] == null) {
            tabela[i] = new LinkedList<>();
        }
        if (!tabela[i].contains(chave)) {
            tabela[i].add(chave);
        }
    }

    @Override
    public void delete(int chave) {
        int indice = hash(chave);
        if (tabela[indice] != null) {
            tabela[indice].remove(Integer.valueOf(chave));
        }
    }

    @Override
    public boolean search(int chave) {
        int indice = hash(chave);
        return tabela[indice] != null && tabela[indice].contains(chave);
    }
    
}
