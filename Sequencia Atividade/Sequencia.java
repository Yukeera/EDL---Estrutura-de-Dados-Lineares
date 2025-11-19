public class Sequencia{
    private No head;
    private No Tail;
    private int size;

    public class No{
        Object data;
        No next;
        No prev;
        public No(Object o){
            data = o;
            this.next = this.prev = null;
        }
    }

    public Sequencia(){
        No head = new No(null);
        No tail = new No(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public Object elemAtRank(int r){
        No current = atRank(r);
        return current.data;
    }

    public Object replaceAtRank(int r, Object o){
        if (r < 0 || r >= size()){
            throw new IndexOutOfBoundsException();
        }

        No current = atRank(r);
        Object removido = current.data;

        current.data = o;

        return removido;
    }

    public void insertAtRank(int r, Object o){
        if (r < 0 || r > size()){
            throw new IndexOutOfBoundsException();
        }
        No newNode = new No(o);
        if (r==size){
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            newNode.next = tail;
            return;
        }

        No current = atRank(r);
        current.prev.next = newNode;
        newNode.prev = current.prev;
        current.prev = newNode;
        newNode.next = current;
        size++;

    }

    public Object removeAtRank(int r){

        if (r < 0 || r >= size()){
            throw new IndexOutOfBoundsException();
        }

        No current = atRank(r);
        Object removido = current.data;

        No temp = current.next;
        current.prev.next = temp;
        temp.prev = current.prev;

        size--;
        return removido;
    }


    public Object first(){

        if (isEmpty()) {
        throw new IllegalStateException("Squencia vazia");
        }

        return head.next.data;

    }

    public Object last(){

        if (isEmpty()) {
        throw new IllegalStateException("Sequencia vazia");
        }

        return tail.prev.data;

    }

    public Object before(No n){

        if (isEmpty()) {
            throw new IllegalStateException("Sequencia vazia");
        }

        if (n == null){
            throw new IllegalArgumentException("Nó inválido");
        }

        if (n.prev == head) {
            throw new IllegalStateException("Não existe elemento antes do primeiro elemento");
        }

        return n.prev.data;

    }

    
    public Object after(No n){

        if (isEmpty()) {
            throw new IllegalStateException("Sequencia vazia");
        }

        if (n == null){
            throw new IllegalArgumentException("Nó inválido");
        }

        if (n.next == tail) {
            throw new IllegalStateException("Não existe elemento depois do último elemento");
        }

        return n.next.data;

    }
    public Object replaceElement(No n, Object o) {

        if (n == null) {
        throw new IllegalArgumentException("Nó inválido");
        }
    
        if (n == head || n == tail) {
        throw new IllegalStateException("Não é permitido alterar sentinelas");
        }

        Object removido = n.data;
        n.data = o;
        return removido;

    }

    public void swapElements(No n,No q){

        if(n == null || q == null){
            throw new IllegalArgumentException("Nó inválido");
        }

        Object data = n.data;
        n.data = q.data;
        q.data = data;

    }

    public void insertBefore(No n,Object o){

        if (n == null){
            throw new IllegalArgumentException("Nó inválido");
        }

        No newNode = new No(o);

        n.prev.next = newNode;
        newNode.prev = n.prev;
        n.prev = newNode;
        newNode.next = n;

    }

    public void insertAfter(No n , Object o){

        if (n == null){
            throw new IllegalArgumentException("Nó inválido");
        }

        No newNode = new No(o);

        n.next.prev = newNode;
        newNode.next = n.next;
        n.next = newNode;
        newNode.prev = n;

    }

    public void insertFirst(Object o){
        insertAtRank(0, o);
    }

    public void insertLast(Object o){
        insertAtRank(size(), o);
    }

    
    public Object remove(No n){
        if (n == null || n == head || n == tail){
            throw new IllegalArgumentException("Nó Inválido");
        }

        Object removido = n.data;

        No temp = n.next;
        n.prev.next = temp;
        temp.prev = n.prev;

        size--;
        return removido;
    }

    public No atRank(int r){
        if (r < 0 || r >= size()){
            throw new IndexOutOfBoundsException();
        }

        current = head.next;
        
        for (int i = 0; i < r; i++){
            current = current.next;
        }

        return current;
    }

    public int rankOf(No n){

        if (n == null){
            throw new IllegalArgumentException("Nó Inválido");
        }

        No current = head.next;
        int r = 0;

        while(current!=tail){

            if(current == n){
                return r;
            }
            current = current.next;
            r++;

        }

        throw new IllegalArgumentException("Nó não pertence a lista!");
    }

}