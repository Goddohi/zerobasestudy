package 연습.문제풀이;

import java.util.HashMap;
import java.util.Scanner;

/*
숫자 -> 로마숫자표기법
 */
public class javaPractice2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자입력 : ");
        int num = scanner.nextInt();
        solution(num);
        solution2(num);

    }
    public static void solution(int num) {
       String roma[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       int romaNum[] ={1000,900,500,400,100,90,50,40,10,9,5,4,1}; //그리디하게 해결해도 괜찮으듯 8 -> 5 3 이니까 괜찮은듯
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roma.length; i++) {
            int count = num/romaNum[i];
            for (int j = 0; j < count; j++) {
                sb.append(roma[i]);
            }
            num = num%romaNum[i];
        }
        System.out.println("로마자는" + sb.toString());
    }
    public static void solution2(int num) {
        String roma[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int romaNum[] ={1000,900,500,400,100,90,50,40,10,9,5,4,1}; //그리디하게 해결해도 괜찮으듯 8 -> 5 3 이니까 괜찮은듯
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (num > 0) {
            while (num>=romaNum[i]) {
                sb.append(roma[i]);
                num -=romaNum[i];
            }
            i++;
        }
        System.out.println("로마자는" + sb.toString());
    }
}
