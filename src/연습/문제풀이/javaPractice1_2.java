package 연습.문제풀이;

import java.util.Scanner;

/*
아스키코드 기준으로 알파벳 소문자는 대문자로 대문자는 소문자로 그외의 문자는 그냥 출력한다.
 */
public class javaPractice1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아무거나 입력:");
        String temp = scanner.nextLine();
        solution(temp);
    }

    //a = 65  A = 97
    public static void solution(char a){
        if(a >= 'a' && a <= 'z'){
            System.out.print((char)(a+('A'-'a')));
        }else if(a>='A'&& a<='Z') {
            System.out.print((char)(a - ('A' - 'a')));
        }else {
            System.out.print(a);
        }
    }
    public static void solution(String a){
        for(char b : a.toCharArray()){
            solution(b);
        }
    }
}
