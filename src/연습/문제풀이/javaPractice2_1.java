package 연습.문제풀이;

import java.util.HashMap;
import java.util.Scanner;

/*
로마숫자표기법 ->숫자로
III 3  IV 4   VI 6  IX 9
L 50  C 100 D500 M1000
 */
public class javaPractice2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("로마숫자입력 : ");
        String roma = scanner.nextLine();
        solution(roma);
        solution2(roma);

    }

    public static void solution(String roma) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char[] chars = roma.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if(map.get(chars[i]) < map.get(chars[i+1])) {
                sum -= map.get(chars[i]);
            }else {
                sum += map.get(chars[i]);
            }
        }
        sum += map.get(chars[chars.length-1]);

        System.out.println("변환한 숫자"+sum);
    }
    public static void solution2(String roma) {
        int num=0;
        char pre = roma.charAt(0);
        for(char c : roma.toCharArray()) {

            switch (c) {
                case 'M':
                    num += pre=='C'?800:1000;
                    break;
                case'D':
                    num += pre=='C'?300:500;
                    break;
                case 'C':
                    num += pre=='X'?80:100;
                    break;
                case 'L':

                    num += pre=='X'?30:50;
                    break;
                case 'X':
                    num += pre=='I'?8:10;
                    break;
                case 'V':
                    num += pre=='I'?3:5;
                    break;
                case 'I':
                    num += 1;
                    break;

            }
            pre = c;
        }
        System.out.println("변환한 숫자"+num);
    }

}
