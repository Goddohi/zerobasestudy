package 연습.잡동사니;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

public class 미니과제5백업 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = sc.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = sc.nextInt();
        sc.close();

        LocalDate thisDate = LocalDate.of(year, month, 1);
        LocalDate lastDate = thisDate.minusMonths(1);
        LocalDate nextDate = thisDate.plusMonths(1);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(lastDate);
        dates.add(thisDate);
        dates.add(nextDate);

        int count =0;
        while (count < 3) {
            System.out.print(String.format("[%04d년 %02d월]\t\t\t\t\t\t",dates.get(count).getYear(),dates.get(count).getMonthValue()));
            count++;
            if(count == 3) {
                System.out.println();
            }
        }
        count = 0;
        while (count < 3) {
            System.out.print("일\t월\t화\t수\t목\t금\t토\t\t\t");
            count++;
            if(count == 3) {
                System.out.println();
            }
        }

        LocalDate lastDate_end =  lastDate.withDayOfMonth( lastDate.lengthOfMonth());
        //각자 마지막 일수
        LocalDate thisDate_end =  thisDate.withDayOfMonth( thisDate.lengthOfMonth());
        LocalDate nextDate_end =  nextDate.withDayOfMonth( nextDate.lengthOfMonth());


        for(; !(thisDate.isAfter(thisDate_end) && lastDate.isAfter(lastDate_end) && nextDate.isAfter(nextDate_end));) {
            int lastCount=0,nextCount=0,thisCount=0;

            for(lastCount =0; lastCount < 7; lastCount++) {
                if((!lastDate.isAfter(lastDate_end))&&(lastDate.get(DAY_OF_WEEK)%7!=lastCount)){
                    System.out.print("  \t");
                }
                else if (!lastDate.isAfter(lastDate_end)) {
                    System.out.printf("%02d\t", lastDate.getDayOfMonth());
                    lastDate = lastDate.plusDays(1);
                } else {
                    System.out.print("  \t");
                }
            }
            System.out.print("\t\t");
            for(thisCount =0; thisCount < 7; thisCount++) {
                if((!thisDate.isAfter(thisDate_end))&&(thisDate.get(DAY_OF_WEEK)%7!=thisCount)){
                    System.out.print("  \t");
                }
                else if (!thisDate.isAfter(thisDate_end)) {
                    System.out.printf("%02d\t", thisDate.getDayOfMonth());
                    thisDate = thisDate.plusDays(1);
                } else {
                    System.out.print("  \t");
                }
            }

            System.out.print("\t\t");
            for(nextCount =0; nextCount < 7; nextCount++) {
                if((!nextDate.isAfter(nextDate_end))&&(nextDate.get(DAY_OF_WEEK)%7!=nextCount)){
                    System.out.print("  \t");
                }
                else if (!nextDate.isAfter(nextDate_end)) {
                    System.out.printf("%02d\t", nextDate.getDayOfMonth());
                    nextDate = nextDate.plusDays(1);
                } else {
                    System.out.print("  \t");
                }
            }
            System.out.println();
        }


    }
}
