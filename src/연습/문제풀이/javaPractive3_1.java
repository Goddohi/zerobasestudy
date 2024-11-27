package 연습.문제풀이;

import java.lang.reflect.Array;
import java.util.Arrays;

public class javaPractive3_1 {
    public static void main(String[] args) {
    solution(new int[]{1,1,2});
    solution(new int[]{0,0,1,1,1,2,2,3,3,4,4});
    }
    public static void solution(int[] n){
        int count=0;
    for(int i=0;i<n.length;i++){
        if(i==0 || n[i]!=n[i-1]){
            n[count++]=n[i];
        }
    }
    //n=Arrays.copyOf(n,count);
    for(int i=0;i<count;i++){
        if(i!=count-1) {
            System.out.print(n[i] + ", ");
        }else{System.out.print(n[i]);}
    }System.out.println();
    }
}
