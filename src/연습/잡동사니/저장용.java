package 연습.잡동사니;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

public class 저장용 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = sc.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = sc.nextInt();
        sc.close();

        //기준 달 (이번달) 생성
        LocalDate thisDate = LocalDate.of(year, month, 1);
        //LocalDate lastDate = thisDate.minusMonths(1);
        //LocalDate nextDate = thisDate.plusMonths(1);

        //리스트로 관리
        List<LocalDate> dates = new ArrayList<>();
        dates.add(thisDate.minusMonths(1)); //이전달 0
        dates.add(thisDate); // 이번달 1
        dates.add(thisDate.plusMonths(1)); // 다음달 2


        /* 기본 달력 형식생성 시작 */
        int count =0; // 0 이전달 1 이번달 2 다음달
        while (count < 3) {
            System.out.print(String.format("[%04d년 %02d월]\t\t\t\t\t\t",dates.get(count).getYear(),dates.get(count).getMonthValue()));
            count++;
            if(count == 3) {
                System.out.println();
            }
        }


        count = 0; // 0 이전달 1 이번달 2 다음달
        while (count < 3) {
            System.out.print("일\t월\t화\t수\t목\t금\t토\t\t\t");
            count++;
            if(count == 3) {
                System.out.println();
            }
        }
        /* 기본 달력 형식생성  끝 */


        //각자 마지막 일수 저장 (마지막기준일)
        dates.add(dates.get(0).withDayOfMonth(dates.get(0).lengthOfMonth()));
        dates.add(dates.get(1).withDayOfMonth( dates.get(1).lengthOfMonth()));
        dates.add(dates.get(2).withDayOfMonth( dates.get(2).lengthOfMonth()));

        /* dates 저장내용
        인덱스 저장된내용 | 인덱스  저장된내용
         0    이전달    |  0+3  이전달 마지막날
         1    이번달    |  1+3  이번달 마지막날
         2    다음달    |  2+3  다음달 마지막날
         */

        // 모든달의 출력날이 마지막 날을 넘어가지 않을때까지 반복
        for(; !(dates.get(0).isAfter(dates.get(0+3)) && dates.get(1).isAfter(dates.get(1+3)) && dates.get(2).isAfter(dates.get(2+3)));) {
            int[] daycount ={0,0,0}; //lastCount=0,nextCount=0,thisCount=0; 각달의 요일계산 카운터

            count=0; // 0 이전달 1 이번달 2 다음달
            while(count < 3) {
                for(daycount[count] =0; daycount[count] < 7; daycount[count]++) {
                    // 아직 출력되어야할 날짜가 남았지만 해당 요일이 아닐경우 공백
                    if((!dates.get(count).isAfter(dates.get(count+3)))&&(dates.get(count).get(DAY_OF_WEEK)%7!=daycount[count])){
                        System.out.print("  \t");
                    }
                    else if (!dates.get(count).isAfter(dates.get(count+3))) {
                        System.out.printf("%02d\t", dates.get(count).getDayOfMonth());
                        dates.set(count,dates.get(count).plusDays(1));
                    } else { //출력할 날짜가 존재하지 않을때
                        System.out.print("  \t");
                    }
                }
                count++;
                System.out.print("\t\t");
            }
            System.out.println();
        }
    }
}
