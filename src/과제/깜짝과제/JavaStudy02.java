package 과제.깜짝과제;

import java.util.HashMap;
/*
깜짝과제 2 - 빈도수구하기
최경태
아래 if문 주석은 알파벳별 빈도수를 구분하기위해서 했지만
문제예시출력에는 특수기호, 띄어쓰기등이 포함 시킨 비율이기에 주석처리를 진행하였다
 */
public class JavaStudy02 {
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        //text 파일 주소입력
        String text = fileUtils.getLoadText("C:\\Users\\pc\\Desktop\\test.txt").toUpperCase();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int totalChars=0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            //if('A'<=c&&c<='Z') {
            // 알파벳별 빈도수 구분하기위해서는 필요하지만 문제사진에는 특수기호도 포함시킨비율값이 있어 주석처리
                    frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1); //getOrDefault = 값이 없을시 뒤의 매개변수(0)반환
                    totalChars++;
           // }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c+" = "+String.format("%6d",frequencyMap.get(c))+"개,   " +String.format("%.2f%%", 100.0*frequencyMap.get(c)/totalChars ));
        }
    }
}
