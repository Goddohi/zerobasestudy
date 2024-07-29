package 과제.미니과제;

import java.util.*;

/*
 미니과제 7 -“로또 당첨 프로그램”
 최경태
 미니과제 5,6을 제출했는데 안되어서 슬프다..
 */
public class JavaStudyMini07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요(숫자1~10):");
        int num = scanner.nextInt();
        List<roto> rotos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            rotos.add(new roto());
            System.out.println(String.format("%C   %02d,%02d,%02d,%02d,%02d,%02d ",'A'+i,rotos.get(i).nums[0],rotos.get(i).nums[1],rotos.get(i).nums[2],rotos.get(i).nums[3],rotos.get(i).nums[4],rotos.get(i).nums[5]));
        }

        System.out.println("\n[로또 발표]");
        roto result = new roto();
        System.out.println(String.format("   %02d,%02d,%02d,%02d,%02d,%02d ",result.nums[0],result.nums[1],result.nums[2],result.nums[3],result.nums[4],result.nums[5]));

        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < num; i++) {

            int count = rotos.get(i).check(result.nums);
            System.out.println(String.format("%C   %02d,%02d,%02d,%02d,%02d,%02d => %d개 일치",'A'+i,rotos.get(i).nums[0],rotos.get(i).nums[1],rotos.get(i).nums[2],rotos.get(i).nums[3],rotos.get(i).nums[4],rotos.get(i).nums[5],count));
        }
    }
}
class roto{
    public int[] nums = new int[6];
    roto(){
        Random random = new Random();
        int i=0;
        while (i<6){
            boolean flag = true;
            int a = random.nextInt(45)+1;
            for(int j = 0; j < i; j++){
                if(a == nums[j]){ flag = false; break; }
            }
            if(flag){
                nums[i] = a;
                i++;
            }
        }
        Arrays.sort(nums);
    }

    public int check(int[] result){
        int count=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(nums[j] == result[i]){ count++; break;}
            }
        }
        return count;
    }
 }
