package 연습.수업;


import java.io.IOException;

class NotTenException extends RuntimeException {}

public class exception {

    public static boolean checkTenWithException(int ten) {
        try {
            if (ten != 10) {
                throw new NotTenException(); // 예외생성
            }
        } catch (NotTenException e) {
            System.out.println("e = " + e);
            return false;
        }

        return true;
    }

    //예외던짐 즉 사용하는 곳에서 예외처리를 해야함
    public static boolean checkTenWithThrows(int ten) throws NotTenException {
        if (ten != 10) {
            throw new NotTenException(); //예외발생
        }

        return true;
    }

    public static void main(String[] args) throws IOException {


        boolean checkResult ;
        checkResult = checkTenWithException(5);
        System.out.println("checkResult = " + checkResult);

        try {
            checkResult = checkTenWithThrows(5);
        } catch (NotTenException e) {
            System.out.println("e = " + e);
        }
        System.out.println("checkResult = " + checkResult);

    }

}
