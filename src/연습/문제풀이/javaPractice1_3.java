package 연습.문제풀이;

import java.util.Scanner;

/*
String의 replace를 사용해보고
그기능을 직접구현해본다
1. replace indexOf , contains 사용제외
 */
public class javaPractice1_3 {
    public static void main(String[] args) {
        System.out.print("문장입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();

        System.out.print("문장에서 바꾸고 싶은 단어:");
        String oldStr = sc.nextLine();

        System.out.print("바꾼 단어를 대체할 단어(바뀐후):");
        String newStr = sc.nextLine();

        System.out.println("replace 이용:"+temp.replace(oldStr,newStr));
        System.out.println("수제 replace 이용:"+selfReplace(temp,oldStr,newStr));

    }
    public static String selfReplace(String str, String oldStr, String newStr ) {
        int idx=0,count=0;
        char[] temp = str.toCharArray();
        String restr = "";
        do {
            idx = findIndex(temp,oldStr.toCharArray());

            if (idx != -1) {
                int i=0;
                for (i = 0; i < idx; i++) {
                    restr += temp[i];

                }

                restr += newStr;
                for (i +=oldStr.length() ; i < temp.length; i++) {
                    restr+=temp[i];
                    }
                temp = restr.toCharArray();
                restr = "";
            }


        }
        while (idx != -1);

        return new String(temp);
    }



    public static int findIndex(char[] str, char[] temp) {
        boolean indexFound = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == temp[0] && str.length -i>= temp.length) {
                indexFound = true;
                for(int j=1;j<temp.length;j++) {
                    if(str[i+j]!=temp[j]) {
                        indexFound = false;
                        break;
                    }
                }
            }
            if(indexFound) {
                return i;
            }
        }
        return -1; //인덱스를 못찾을경우 -1
    }
}
