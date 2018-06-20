public class isArrayMaxHeap {
    public static void main(String[] args) {
        int[] a = {9, 15, 10, 7, 12, 11};
        int[] ar = {5, 6, 1, 3};

        isArrayMaxHeap arr = new isArrayMaxHeap();
        System.out.println("swaps " + arr.numswaps(ar));
//        System.out.println(arr.isMaxHeap(a, 0));
////        int[] heap = {12, 5 ,787, 1 ,23};
////        for (int aHeap : heap) {
////            System.out.println(aHeap);
////        }
////        arr.maxheapify(heap, 0);
////        System.out.println("Heapify");
////        for (int aHeap : heap) {
////            System.out.println(aHeap);
////        }
////
////        int k = 2;int l = -1; int r= -1;
////
////        for(int i = 0 ; i < k ; i ++ ){
////            arr.maxheapify(heap, i);
////           System.out.println(heap[i]);
////        }
    }

    private int numswaps(int[]a){
        int swaps = 0;
        int max = a[0], min = a[0], maxid = 0 , minid= 0;
        for(int i = 0 ; i < a.length; i ++){
            if(a[i]>max){
                max = a[i];
                maxid = i;
            }
            if(a[i]< min){
                min = a[i];
                minid = i;
            }
        }
        swaps = maxid + a.length - 1 - minid;

        if(maxid > minid){
            swaps --;
        }
        System.out.println("max " + max + " maxid " + maxid +  "\nmin " + min + " minid " + minid);
        return swaps;
    }

    private boolean isMaxHeap(int[] a, int idx){
        int left = 2 * idx +1;
        int right = 2 * idx + 2;
        if(idx >= a.length)
            return true;
       if(left >= a.length && right >= a.length)
           return true;
        if(left >= a.length) {
            return (a[idx] >= a[right]);
        }
        if(right >= a.length)
            return (a[idx] >= a[left]);

        if(isMaxHeap(a, left) && isMaxHeap(a, right)) {
            return (a[idx] > a[left] && a[idx] > a[right]);
        }
        return false;
    }

    private void maxheapify(int[] a, int idx){
        int l, r ;

        for(int i = idx ; i < a.length ; i++){
            int ldx = 2*i+1;
            int rdx = 2*i+2;
            if(ldx < a.length ){
                l = a[ldx];
                if(a[i]<l){
                    swap(a,i,ldx);
                }
            }
            if(rdx < a.length ){
                r = a[rdx];
                if(a[i]<r){
                    swap(a,i,rdx);
                }
            }
        }
    }

    private void buildMinheap(int[] heap, int[] a, int k){
        int max = a[0];

    }

    private void swap(int[] a, int i, int k){
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
