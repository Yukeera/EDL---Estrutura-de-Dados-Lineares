public void enqueue(Object o){
    if (size == capacidade){
        novaCapacidade = capacidade * 2;
        Object [] b = new Object[novaCapacidade];
        for (int i = 0; i < size; i++){
            b[i] = a[(inicio + i) % capacidade];
        }
        a = b;
        capacidade = novaCapacidade;
        inicio = 0;
        fim = size;
    }
    a[fim] = o;
    fim = (fim + 1) % capacidade;
    size++;
}
public Object dequeue(){
    if (isEmpty()){
        throw new IllegalAccessError();
    }
    
    Object removido = a[inicio];
    a[inicio] = null;
    inicio = (inicio + 1) % capacidade;
    size--;
    return removido; 
}