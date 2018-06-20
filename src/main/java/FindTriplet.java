public class FindTriplet {

    public static void main(String[] args) {
        int[] a = {12, 11, 10, 5, 6, 2, 30};
        int i1=0,i2=0, i3 =0;
        int k = 0;
        for(int i = 0 ; i < a.length-1; i++){
            k = a[i+1]-a[i];
            if(k>0){
                if(i1 == i2) {
                    i1 = i;
                    i2 = i + 1;
                }else if(a[i2] < a[i+1]){
                    i3 = i+1;
                    break;
                }

            }


        }

        System.out.println(i1 + " " + a[i1] + ", "+ i2 + " " + a[i2] + ", "+ i3 + " "+ a[i3]);
    }


}
