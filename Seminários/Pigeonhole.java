import java.util.ArrayList;

class Pigeonhole{
    private int min, max, range;
    private ArrayList<Integer>[] pombos;
    @SuppressWarnings("unchecked")
    public Pigeonhole(int [] original){
        this.min = valorMin(original);
        this.max = valorMax(original);
        this.range = this.max - this.min + 1;
        this.pombos = new ArrayList[range];
    }
    public int valorMin(int [] array){
        int minimo = array[0];
        for (int i = 0; i < array.length; i++){
            if (minimo > array[i]){
                minimo = array[i];
            }
        }
        return minimo;
    }
    public int valorMax(int [] array){
        int maximo = array[0];
        for (int i = 0; i < array.length; i++){
            if (maximo < array[i]){
                maximo = array[i];
            }
        }
        return maximo;
    }
    public int [] sort(int [] array){
        // Distribuir elementos nos buckets
        for (int i = 0; i < array.length; i++){
            int index = array[i] - this.min;
            if (this.pombos[index] == null){
                this.pombos[index] = new ArrayList<Integer>();
            }
            this.pombos[index].add(array[i]);
        }
        // Reconstruir o array ordenado
        int pos = 0;
        for (int i = 0; i < range; i++){
            if (this.pombos[i] != null){
                for (int j = 0; j < this.pombos[i].size(); j++){
                    array[pos++] = this.pombos[i].get(j);
                }
            }
        }
        return array;
    }
}