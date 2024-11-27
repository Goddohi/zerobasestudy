package 연습.문제풀이;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    nums 배열은 1~n 범위 n은 len길이보다 작다
    각 정수는 한번 또는 두번만 나타난다.
    반환을 위한 배열을 제외하고 다른 메모리는 금한다
 */
public class javaPractive3_2 {


    public static void main(String[] args) {
        System.out.println(sol(new int[]{1,2,3,4,5,6,6,5,3,2}));
        System.out.println(sol2(new int[]{1,2,3,4,5,6,6,5,3,2}));
    }

    public static HashSet<Integer> sol(int[] nums){
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        list.add(nums[i]);
                    }
                }
        }
        return list;
    }
    //인덱스를 변수로 생각하고 하는거 (인덱스의 값을 넣는다)
    public static HashSet<Integer> sol2(int[] nums){
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;

            if(nums[index] < 0){
                list.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return  list;
    }
}

