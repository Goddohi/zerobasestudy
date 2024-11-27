package 연습.잡동사니;
import java.util.*;
import java.lang.*;
import java.io.*;

public class 잡동사니1 {

    public static void main(String[] args) {
            int sum = 0;
            try {
                func();
            } catch(NullPointerException e) {
                sum = sum + 1;
            } catch(Exception e) {
                sum = sum + 10;
            } finally {
                sum = sum + 100;
            }
            System.out.print(sum);
        }
        static void func() throws Exception{
            new NullPointerException();
            //throw안하면 안나간다잉~
        }

}
