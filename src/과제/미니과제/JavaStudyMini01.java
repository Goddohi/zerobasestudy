package 과제.미니과제;

/*
미니과제1 - 구구단
최경태
 */
public class JavaStudyMini01 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.print(String.format("%02d×%02d = %02d  ",j,i,i*j));
            }
            System.out.println();
        }
    }
}