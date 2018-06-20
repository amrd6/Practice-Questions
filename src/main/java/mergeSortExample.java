public class mergeSortExample {

    public static void main(String[] args){
    int[] array = {9,8,7,6,3,2,1};
    mergeSort(array, 0  , array.length-1);
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    private static void mergeSort(int[] a, int i, int j){
        if (j == i )
            return;

        int m = i + (j-i)/2;
        mergeSort(a, i, m);
        mergeSort(a, m+1, j);
        merge(a, i , m , j);

    }

    private static void merge(int[] a, int i, int m, int j){
        int[] c = new int[a.length];
        System.arraycopy(a, i, c, i, j + 1 - i);

        int p = i; int q = m+1; int k = p;
        while(p <= m && q <= j){
            if(a[p] >= a[q]) {
                c[k++] = a[q++];
            } else {
                c[k++] = a[p++];
            }
        }

        while(p <=m) {
            c[k++] = a[p++];
        }

        while(q <=j) {
            c[k++] = a[q++];
        }

        for(k = i ; k <= j ; k++){
            a[k] = c[k];
        }
    }
}
