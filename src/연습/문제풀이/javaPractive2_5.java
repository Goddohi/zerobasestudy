package 연습.문제풀이;
/*
사탕을 한개씩 이상을 줘야하고
점수가 높을경우 양옆에 낮은 친구의 갯수보다 더 줘야한다
이때 소모되는 캔디의 갯수는?
 */
public class javaPractive2_5 {
    public static void main(String[] args) {
        int[] scores ={1,2,3,2,1};
        // 1 2 3 2 1 =9
        System.out.println(solution(scores));
        scores = new int[]{1,2,3};
        System.out.println(solution(scores));
        // 1 2 3 = 6
        scores = new int[]{3,2,1};
        System.out.println(solution(scores));
        // 3 2 1 = 6
        scores = new int[]{3,1,2};
        System.out.println(solution(scores));
        // 2 1 2  = 5
        scores = new int[]{1,3,2,5,7,1};
        System.out.println(solution(scores));
         // 1 2 1 2 3 1 10
    }
    public static int solution(int[] n) {
        if(n.length == 0 || n == null) return 0;

        int result = 1;
        int upCnt = 1;
        int downCnt = 0;
        int peak =0;
        for (int i = 1; i < n.length; i++) {
            if(n[i] > n[i-1]){
                upCnt++;
                peak= upCnt;
                downCnt = 0;
                result += upCnt;
            } else if(n[i] == n[i-1]){
                upCnt=1;
                downCnt=0;
                peak= 0;
                result += 1;
            }else {
                downCnt++;
                upCnt=1;
                result += downCnt;
                if(peak <=downCnt){
                    result += 1;
                }
            }

        }

        return result;
    }
}
