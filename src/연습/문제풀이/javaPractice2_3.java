package 연습.문제풀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class javaPractice2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("초기문자열입력해주세요:");
        String str = sc.nextLine();
        System.out.print("커맨드 입력해주세요:");
        String command = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);

        //커서 초기위치(맨끝)
        int curse=sb.length();

        //i+=2 는 공백 뛰어넘기
        for (int i = 0; i < command.length(); i+=2) {
            switch(command.charAt(i)){
                case'L': //커서를 왼쪽으로 옮김 맨 앞이면 무시
                    if(curse>0){
                        curse--;
                    }break;
                case'D': //커서를 오른쪽으로 옮김 맨뒤일경우 무시
                    if(curse<sb.length()){
                        curse++;
                    }
                    break;
                case'B': if(curse>0){ //커서 왼쪽에 있는 문자를 삭제
                    sb.deleteCharAt(curse-1);
                   if(curse>sb.length()){
                        curse=sb.length();
                    }
                }break;
                case'P': //P다음에 오는 소문자를 커서 왼쪽에 추가
                    i+=2;
                    sb.insert(curse,command.charAt(i));
                    curse++;
                    break;

            }
        }
        System.out.println(sb.toString());
    }
}
