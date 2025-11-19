public void insertAtRank(int r, Object o){
    if (r < 0 || r > size){
        throw new IndexOutOfBoundsException();
    }
    if (size == capacidade){
        int novaCapacidade = capacidade * 2;
        Object [] b = new Object[novaCapacidade];
        for (int i = 0 ; i < size ; i++){
            b[i] = a[i];
        }
        a = b;
        capacidade = novaCapacidade;
    }

    for (int i = size - 1 ; i >= r ; i--){
        a[i+1] = a[i];
    }

    a[r] = o;
    size++;
}

public Object removeAtRank(int r){
    if (r < 0 || r >= size){
        throw new IndexOutOfBoundsException();
    }
    Object removido = a[r];
    for (int i = r; i < size - 1; i++){
        a[i] = a[i+1];
    }
    a[size] = null;
    size--;
    return removido;
}