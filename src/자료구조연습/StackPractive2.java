package 자료구조연습;

import java.util.Stack;

// 짝맞추기에 응용
// ( ) 에 대해서
public class StackPractive2 {
    public static void main(String[] args) {

        System.out.println(check("(((())))"));
        System.out.println(check("((()()))"));
        System.out.println(check("(())()(())"));
        System.out.println(check("())((())"));


    }
    public static boolean check(String str){
        Stack stack = new Stack();
        for(String s : str.split("")){
            if(s.equals("(")){
                stack.push(s);
            }else if(s.equals(")")){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
