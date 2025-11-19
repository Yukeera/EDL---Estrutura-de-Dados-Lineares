public void push(Object o){
    if (size == capacidade){
        novaCapacidade = capacidade * 2;
        Object [] b = new Object[novaCapacidade];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }
        capacidade = novaCapacidade;
        a=b;
    }
    a[topo + 1] = o;
    topo++;
    size++;
}

public Object pop(){
    if(isEmpty()){
        throw new IllegalStateException();
    }
    Object removido = a[topo];
    a[topo] = null;
    t--;
    size--;
    return removido;
}