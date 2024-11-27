package 백준;

import java.util.Scanner;
import java.util.Stack;

public class back25556 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++){
            if(stack1.empty() || stack1.peek() < Integer.parseInt(split[i])){
                stack1.push(Integer.parseInt(split[i]));
            }else if(stack2.empty() || stack2.peek() < Integer.parseInt(split[i])){
                stack2.push(Integer.parseInt(split[i]));
            }else if(stack3.empty() || stack3.peek() < Integer.parseInt(split[i])){
                stack3.push(Integer.parseInt(split[i]));
            }else if(stack4.empty() || stack4.peek() < Integer.parseInt(split[i])){
                stack4.push(Integer.parseInt(split[i]));
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }
}
