package 연습.문제풀이;

import java.util.Scanner;

/*
이번문제는 입력되는 정수형 숫자를 거꾸로 변환 시키는 프로그램
but 100 -> 001 의경우는 1로 출력한다
 */
public class javaPractice1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 거꾸로 변환기:");
        System.out.println("변환된 숫자:"+solution(sc.nextInt()));
    }

    public static int solution(int num){
        int answer = 0;
        boolean minus = false;
        if(num<0){
            minus = true;
            num = -num;
        }
        while(num>0){
            answer = answer*10+num%10;
            num /=10;
        }
        if(minus){
            answer = -answer;
        }
        return answer;
    }
}
