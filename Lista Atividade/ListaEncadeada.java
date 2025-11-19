public class ListaEncadeada {
    private No head;
    private int size;
    private No tail;

    public class No {

        Object data;
        No next;
        No prev;

        public No(Object o) {
            data = o;
            next = prev = null;
        }

    }

    public ListaEncadeada() {

        head = new No(null); 
        tail = new No(null);
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public int size() {

        return size;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public boolean isFirst(No n) {

        if (n == null) {
            throw new IllegalArgumentException();
        }
        return n.prev == head;

    }

    public boolean isLast(No n) {

        if (n == null) {
            throw new IllegalArgumentException();
        }
        return n.next == tail;

    }

    
    public No first() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return head.next;

    }

    public No last() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return tail.prev;

    }

    public No before(No p) {

        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (p.prev == head) {
            throw new IllegalArgumentException();
        }
        return p.prev;

    }

    public No after(No p) {

        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (p.next == tail) {
            throw new IllegalArgumentException();
        }
        return p.next;

    }

    
    public Object replaceElement(No n, Object o) {

        if (n == null) {
            throw new IllegalArgumentException();
        }
        Object removido = n.data;
        n.data = o;
        return removido;

    }

    public void swapElements(No n, No q) {

        if (n == null || q == null) {
            throw new IllegalArgumentException();
        }
        Object temp = n.data;
        n.data = q.data;
        q.data = temp;

    }

    public No insertBefore(No p, Object o) {

        if (p == null) {
            throw new IllegalArgumentException();
        }
        
        No newNode = new No(o);
        
        newNode.next = p;
        newNode.prev = p.prev;
        p.prev.next = newNode;
        p.prev = newNode;
        
        size++;
        return newNode;

    }

    public No insertAfter(No p, Object o) {

        if (p == null) {
            throw new IllegalArgumentException();
        }
        
        No newNode = new No(o);
        
        newNode.prev = p;
        newNode.next = p.next;
        p.next.prev = newNode;
        p.next = newNode;
        
        
        size++;
        return newNode;

    }

    public No insertFirst(Object o) {

        No newNode = new No(o);
        
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        head.next.prev = newNode;
        
        size++;
        return newNode;

    }

    public No insertLast(Object o) {

        No newNode = new No(o);
        
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        
        size++;
        return newNode;

    }

    public Object remove(No n) {

        if (n == null) {
            throw new IllegalArgumentException();
        }
        if (n == head || n == tail) {
            throw new IllegalArgumentException();
        }
        
        Object removido = n.data;
        
        n.prev.next = n.next;
        n.next.prev = n.prev;
        
        size--;
        return removido;

    }
}


