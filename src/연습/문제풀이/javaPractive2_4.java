package 연습.문제풀이;

import java.util.HashMap;

/*
숫자는 각 키보드 입력값을 의미한다
 */
public class javaPractive2_4 {
    public static String solution(int[] keylog){
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;
        StringBuilder sb = new StringBuilder();


        int step = 'a'-'A';
        boolean capsLock = false;
        boolean shift = false;
        boolean insert = false;
        char[] specialKey= {')','!','@','#','$','%','^','&','*','('};
        int cursor=0;
        for(int i:keylog){
            if(i==BACK_SPACE){
                if(cursor==0){
                    continue;
                }
                sb.deleteCharAt(cursor--);
            }else if(i==SHIFT){
                shift = true;
            }else if(i==CAPS_LOCK){
                capsLock = !capsLock;
            }else if(i==SPACE_BAR) {
                if(insert){
                    sb.setCharAt(cursor, ' ');
                }else {
                    sb.insert(cursor,' ');
                }
                cursor++;
            }else if(i==KEY_LEFT){
                //cursor = cursor>0? cursor-1:0;
                cursor = Math.max(0,cursor-1);
            }else if (i==KEY_RIGHT){
                //cursor = cursor+1<sb.length()? cursor+1:cursor;
                cursor = Math.min(sb.length(),cursor+1);
            }else if(i==INSERT){
                insert = !insert;
            }else if(i==DELETE){
                if(cursor==sb.length()){
                    continue;
                }
                sb.deleteCharAt(cursor+1);
            }else if((i>=97 && i<=122) ||(i>=48 && i<=57)) {
                char key=' ';
                if (i >= 97) {
                    int temp = i;
                    if (capsLock && shift) { //동시에 누를경우
                    } else if (capsLock || shift) { // 둘중 하나 ( 위에서 동시에누를경우있으니)
                        temp -= step;
                    }
                    shift = false;
                    key =(char)temp;
                } else {
                    if (shift) {
                        key = specialKey[i - 48];
                        shift = false;
                    }else{
                        key = (char) i;
                    }
                }
                //문자주입
                if(insert){
                    sb.setCharAt(cursor,key);  //값을 대체함
                }else {
                    sb.insert(cursor,key); //값을 해당에 입력
                }
                cursor++;
            }

        }




        return sb.toString();
    }

    public static void main(String[] args) {
        int[] keylog= {16,106,101,108,108,111,37,37,37,37,37,155,16,104};
        System.out.println(solution(keylog)); //Hello

        keylog= new int[]{20,97,98,16,99,16,100,16,49,16,50,16,51};
        System.out.println(solution(keylog)); //ABcd!@#
    }
}
