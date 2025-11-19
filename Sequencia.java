public No rankAt(int r){
    if (r >= size || r < 0){
        throw new IndexOutOfBoundsException("Fora de range");
    }
    No current = head.next;
    for (int i = 0 ; i < r ; i++){
        current = current.next;
    }
    return current;
}


public int rankOf(No o){
    if(o == null){
        throw new IllegalAccessException();
    }

    No current = head.next;
    int r = 0;
    while (current!=null){
        if (current == o){
            return r;
        }
        current = current.next;
        r++;
    }
}