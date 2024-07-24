package 과제.깜짝과제;

import java.util.Scanner;

/*
깜짝과제01 - 수강관리
최경태
전제 : 숫자만 입력하는 것만 전제를 했지만 일단 글자도 예외처리 해봤습니다..!
 */

public class JavaStudy01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("<<<<[메뉴선택]>>>>\n1. 회원 관리\n2. 과목 관리\n3. 수강 관리\n4. 결제 관리\n5. 종료");

            try{ //숫자이외를 입력할경우 예외처리
                int select = sc.nextInt();

                if(select == 1){System.out.println("회원 관리 메뉴를 선택했습니다.");}
                else if(select == 2){System.out.println("과목 관리 메뉴를 선택했습니다.");}
                else if(select == 3){System.out.println("수강 관리 메뉴를 선택했습니다.");}
                else if(select == 4){System.out.println("결제 관리 메뉴를 선택했습니다.");}
                else if(select == 5){
                    System.out.println("종료");
                    break;
                }
                else {System.out.println("입력값이 정확하지 않습니다.");}
            }
            catch(Exception e){ //숫자이외의 입력시
                System.out.println("입력값이 정확하지 않습니다.");
                sc.next(); //버퍼비워서 연속예외처리 해결
            }
        }
        sc.close();
    }
}