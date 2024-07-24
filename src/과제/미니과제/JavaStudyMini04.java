package 과제.미니과제;/*
미니과제4 - 주민등록번호 생성 프로그램
최경태
성별은 무조건 m/f만 입력된다고 가정.
random클래스를 뜯어보니 nextInt(origin,bound)가 존재했다. 설명으로는 origin과 bound미만의 사이값을 반환 한다고 했다.
 */
import java.util.Random;
import java.util.Scanner;


public class JavaStudyMini04 {
    public static void main(String[] args) {
        int sexNum=0, year=0, month=0, day=0;

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        //2020년이후입력가정
        System.out.print("출생년도를 입력해 주세요. (yyyy):");
        year = sc.nextInt();

        System.out.print("출생월을 입력해 주세요. (mm):");
        month = sc.nextInt();

        System.out.print("출생일을 입력해 주세요. (dd):");
        day = sc.nextInt();

        System.out.print("성별을 입력해 주세요. (m/f):");
        String sex = sc.next();

        sc.close(); //스캐너 종료

        // 성별은 m과 f뿐이라고 가정하여 m이 아니면 f이다.
        sexNum = sex.equals("m")? 3: 4;

        //천의자리와 백의자리를 제거한다.
        year -= (year/100)*100; //년도의 10의자리와 1의자리만 남기기

        //임의의 주민등록번호 출력
        int randomNum = rand.nextInt(999999) + 1; // rand.nextInt(1,1000000) 도 가능한 것 같다 -> 인터페이스에 있음.

        //출력할때 빈공간만큼 0을 채우기위해 format사용
        System.out.println(String.format("%02d%02d%02d-%1d%06d",year,month,day,sexNum,randomNum));
    }
}