package 연습.문제풀이;

import java.util.Scanner;

/*
배열의 각 원소는 각 벽의 높이를 의미한다
인덱스 i당 1m이라고 했을때
두벽을 골랐을때 가장 많은 물을 담을수 있는 면적을 출력하라

 */
public class javaPractice1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력예시(1,2,8,2,4,2) :");
        String[] temp = scanner.nextLine().split(",");
        int[] arr = new int[temp.length];
        for (int i=0  ;i<temp.length;i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        int max= 0;
        for(int i =0;i<arr.length-1;i++) {
            for(int j = i+1;j<arr.length;j++) {
                int hegiht = arr[i]<arr[j] ?arr[i]:arr[j];
                if(hegiht*(j-i) > max) {
                    max = hegiht*(j-i);
                }
            }
        }
        System.out.println(max);
    }
}
