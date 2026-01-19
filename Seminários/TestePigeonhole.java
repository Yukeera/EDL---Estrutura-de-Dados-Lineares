import java.util.Arrays;

public class TestePigeonhole {
    public static void main(String[] args) {
        // Teste 1: Array com números aleatórios
        int[] array1 = {8, 3, 2, 7, 4, 6, 8, 1, 5};
        Pigeonhole sorter1 = new Pigeonhole(array1.clone());
        int[] sorted1 = sorter1.sort(array1.clone());
        
        System.out.println("Teste 1:");
        System.out.println("Array original: " + Arrays.toString(array1));
        System.out.println("Array ordenado: " + Arrays.toString(sorted1));
        System.out.println("Esperado: " + Arrays.toString(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}));
        System.out.println("Correto: " + Arrays.equals(sorted1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}));
        
        // Teste 2: Array pequeno
        int[] array2 = {5, 2, 8, 1};
        Pigeonhole sorter2 = new Pigeonhole(array2.clone());
        int[] sorted2 = sorter2.sort(array2.clone());
        
        System.out.println("\nTeste 2:");
        System.out.println("Array original: " + Arrays.toString(array2));
        System.out.println("Array ordenado: " + Arrays.toString(sorted2));
        System.out.println("Esperado: " + Arrays.toString(new int[]{1, 2, 5, 8}));
        System.out.println("Correto: " + Arrays.equals(sorted2, new int[]{1, 2, 5, 8}));
        
        // Teste 3: Array com valores negativos
        int[] array3 = {-1, 3, -5, 2, 0};
        Pigeonhole sorter3 = new Pigeonhole(array3.clone());
        int[] sorted3 = sorter3.sort(array3.clone());
        
        System.out.println("\nTeste 3:");
        System.out.println("Array original: " + Arrays.toString(array3));
        System.out.println("Array ordenado: " + Arrays.toString(sorted3));
        System.out.println("Esperado: " + Arrays.toString(new int[]{-5, -1, 0, 2, 3}));
        System.out.println("Correto: " + Arrays.equals(sorted3, new int[]{-5, -1, 0, 2, 3}));
    }
}