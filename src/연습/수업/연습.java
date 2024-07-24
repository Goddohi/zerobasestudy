package 연습.수업;

import java.io.IOException;

public class 연습 {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        int a =System.in.read() -'0';
            System.out.println(a);
          int b=  System.in.read(new byte[System.in.available()]);
            System.out.println(b);
    }

}
abstract class ab{
    int a;
    abstract int plus(int a);
}

class a extends ab{
    a(int a){
        this.a = a;
    }

    @Override
    int plus(int a) {
        this.a = this.a+a;
        return this.a;
    }
}