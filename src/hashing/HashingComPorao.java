package hashing;

import java.util.LinkedList;

public class HashingComPorao implements EstruturaDeDados{

    private LinkedList<Integer>[] tabela;
    private LinkedList<Integer> porao;

    @SuppressWarnings("unchecked")
    public HashingComPorao() {
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
        if (tabela[i].contains(chave)) {
            return; 
        }
        if (tabela[i].size() < 100) {
            tabela[i].add(chave);
        } else {
            porao.add(chave);
        }
    }

    @Override
    public void delete(int chave) {
        int i = hash(chave);
        if (tabela[i] != null && tabela[i].remove(Integer.valueOf(chave))) {
            return;
        }
        porao.remove(Integer.valueOf(chave));
    }

    @Override
    public boolean search(int chave) {
        int i = hash(chave);
        if (tabela[i] != null && tabela[i].contains(chave)) {
            return true;
        }
        return porao.contains(chave);
    }
    
}
