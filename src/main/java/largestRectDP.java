public class largestRectDP {
    public static void main(String[] args) {

        int[] a = {6,2,5,4,5,1,6};
        int[][] min = new int[a.length][a.length];
        int max = a[0]; int s = 0 ; int e = 0;
        for(int i = 0 ; i < a.length ; i ++){
            min[i][i] = a[i];
            if(max < a[i]){
                max = a[i];
                s = i; e = i;
            }
        }

        int j = 0;
        for (int level = 1 ; level < a.length ; level ++){
            for(int i = 0 ; i < a.length &&  i + level < a.length; i ++){
                j = i + level;
                min[i][j] = Math.min( min[i][j-1], min[i+1][j]);
                int temp  = min[i][j]*(j-i + 1);
                if(temp > max){
                    max = temp;
                    s = i;
                    e = j;
                }
            }
        }
        System.out.println(max + " s = " + s + " e = " + e );
    }


}
