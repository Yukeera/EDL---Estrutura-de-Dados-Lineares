public No insertAfter(No p, Object o){
    No newNode = new No(o);
    newNode.prev = p;
    newNode.next = p.next;
    nextp = p.next;
    p.next = newNode;
    nextp.prev = newNode;

    numElts++;
    return newNode;
}

public No insertBefore(No p, Object o){
    No newNode = new No(o);
    newNode.prev = p.prev;
    newNode.next = p;
    beforep = p.prev
    p.prev = newNode;
    beforep.next = newNode;

    numElts++;
    return newNode;

}

public void swapElements(No a, No b){
    Object elementA = a.data;
    a.data = b.data;
    b.data = elementA;
}