package 과제.미니과제;

import java.util.Scanner;

/*
미니과제3 - 놀이동산 입장권 계산 프로그램
최경태
naxtLine()사용할때 naxtint 엔터를 치고 넘어간후 다음 naxtLine()를 뛰어넘습니다 어떻게 해야 정상적으로 될까..
 */
public class JavaStudyMini03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요. (숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간를 입력해 주세요. (숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요. (y/n):");
        String ku = sc.next();
        System.out.print("복지카드 여부를 입력해 주세요. (y/n):");
        String bjcard = sc.next();
        sc.close();
        int money=10000;
        if(age< 3){ //제일 먼저 할인율이 높은 거
            money=0;
        } else if (age<13 || time>=17) { //그다음할인율
            money=4000;
        } else if (ku.equals("y")|| bjcard.equals("y")) { // 제일 낮은 할인
            money=8000;
        }
        System.out.println("입장료: "+money);

    }
}