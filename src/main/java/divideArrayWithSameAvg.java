public class divideArrayWithSameAvg {
    public static void main(String[] args) {
        int[] a = {4, 3, 5, 9, 11};
        int sum = 0;

        for(int i = 0 ; i < a.length; i++){
            sum = sum+ a[i];
        }
        int avg = sum/a.length;
        System.out.println("avg = " + avg);

        int curravg = a[0];
        int i = 1;

        for(int j = 1; j < a.length; j++){
            if(curravg == avg){
                break;
            }

            curravg = (curravg * i + a[j])/(i+1);
            i++;
        }

        if(curravg == avg){
            System.out.println("( 0 , " + (i-1) + " ), ( " +  i + ", " + (a.length-1) + " )");
        } else {
            System.out.println("Not Possible");
        }
    }
}
