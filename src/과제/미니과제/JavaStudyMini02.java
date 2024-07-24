package 과제.미니과제;

import java.util.Scanner;
/*
미니과제2 - 캐시백계산
최경태
미니과제1에서 format을 써봐서 직접 넣어봤습니다!
 */
public class JavaStudyMini02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[캐시백 계산]\n결제 금액을 입력해 주세요.(금액):");
        int money = sc.nextInt();
        int point = ((money / 10)/100)*100;
        point = point>=300 ? 300: point;
        System.out.println("결제 금액은 "+money+"원이고, 캐시백은 "+point+"원 입니다.");
    }
}
