import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.HashSet;
import java.util.Iterator;

public class Permutations {

    private void allPermutations(char[] chars, int s , int e){
        if(s == e ){
            System.out.println(String.valueOf(chars));
        } else {
            for(int i = s ; i <= e ; i++){
                swap(chars, s, i);
                allPermutations(chars, s+1 , e);
                swap(chars, i , s);
            }
        }
    }

    private void swap(char[] chars, int i , int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ayushi";
        char[] chars = s.toCharArray();

        Permutations p = new Permutations();
        p.allPermutations(chars ,0, chars.length -1);
    }
}
