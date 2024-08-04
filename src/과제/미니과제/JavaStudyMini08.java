package 과제.미니과제;

import java.util.Scanner;
/*
미니과제8 - “연소득 과세금액 계산 프로그램”
최경태
수행 목적 : Scanner의 입력함수와 조건문 및 반복문 과 배열, 함수를 통한 과세 로직 작성
 */

public class JavaStudyMini08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요. :");
        long money = scanner.nextLong();

        //과세 기준선 (길이 7)
        long[] taxations = {12000000L, 46000000L, 88000000L,150000000L,300000000L,500000000L,1000000000L};
        // 세율 (길이 8)
        int[] taxPer = {6,15,24,35,38,40,42,45};


        //과세 기준단계
        int level = 0;

        // 과세 기준단계 계산 로직
        for(long taxation : taxations){
            if(money <= taxation){
                break;
            }
            level++;
        }

        //총 세금 + 계산로직
        long totalTax = 0;
        for(int i=0;i<=level;i++){
            long temp, stepByStepTax;
            if(i==level){
                temp = i==0 ? money : money - taxations[i-1];
            }else {
                temp = i==0? taxations[i]: taxations[i]- taxations[i-1];
            }
            //반올림을 하는경우는 부동 소수점계산(이진법)의 오차를 해결하기위함
            stepByStepTax =Math.round((long)(temp*(taxPer[i]/100.0)));
            totalTax += (long) stepByStepTax;
            System.out.println(String.format("%13d * %2d%% = %11d ",temp, taxPer[i], stepByStepTax));
        }
        //총세금 출력
        System.out.println(String.format("[세율에 의한 세금]:           %13d",totalTax));

        //누진공제
        long njTax = 0L;
        switch (level){
            case 1: njTax =1080000L; break;
            case 2: njTax =5220000L; break;
            case 3: njTax =14900000L; break;
            case 4: njTax =19400000L; break;
            case 5: njTax =25400000L; break;
            case 6: njTax =35400000L; break;
            case 7: njTax =65400000L; break;
            default: njTax =0L; break;
        }
        //누진공제계산식  반올림을 하는경우는 부동 소수점계산(이진법)의 오차를 해결하기위함
        long njTotalTax = Math.round((money * taxPer[level]/ 100.0)- njTax);
        System.out.println(String.format("[누진공제 계산에 의한 세금]:   %13d",njTotalTax));

    }

}
