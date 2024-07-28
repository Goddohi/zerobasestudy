package 연습.문제풀이;

import java.util.Scanner;

/*
별찍기 패턴과 별 갯수를 주워주었을때 출력
 */
public class javaPractice1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("별찍기 패턴을 입력해주세여(1~5):");
        int type =scanner.nextInt();

        System.out.print("별출력라인 입력해주세요:");
        int count =scanner.nextInt();
        solution(type, count);

    }

    public static void solution(int type, int count){
        if(type == 1){ // 정사각형
            for (int i = 1; i <= count; i++) {
                System.out.println("*".repeat(count));
            }
        }
        else if(type == 2){
            for (int i = 1; i <= count; i++) {
                System.out.println("*".repeat(i));
            }
        }
        else if (type == 3){
            for (int i = 0; i <= count; i++) {
                System.out.println(" ".repeat(count-i) + "*".repeat(i));
            }
        }
        else if (type == 4){
            for (int i = 0; i < count; i++) {
                System.out.println(" ".repeat(count-i-1)+ "*".repeat(i*2+1));

            }
        }
        else if (type == 5){
            for (int i = 0; i <= count/2; i++) {
                    System.out.println(" ".repeat(count/2 -i)+"*".repeat(i*2+1));
            }
            for(int i= count/2; i > 0;i--) {
                    System.out.println(" ".repeat(count/2-i + 1) + "*".repeat(i*2 -1));
            }
        }
    }


}

