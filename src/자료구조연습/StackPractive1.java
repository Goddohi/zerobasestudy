package 자료구조연습;

//입력을 역출력해보자
// 입력 : 1 2 3 4 5
// 출력 : 5 4 3 2 1

import java.util.Stack;

public class StackPractive1 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String result = "";
        String str = "1 2 3 4 5";
        for(String s : str.split("")){
            stack.push(s);
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}
