package 과제.미니과제;/*
미니과제6 - “가상 선거 및 당선 시뮬레이션 프로그램”
최경태
당선자가 동률이 존재할수 없다고 하여서 재투표가 필요하게 처리하였습니다.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaStudyMini06 {
    public static void main(String[] args) {
        //기본 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("총 진행할 투표수를 입력해 주세요. ");
        int vote = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int participantsNum = sc.nextInt();
        List<String> participants = new ArrayList<>();
        for (int i = 0; i < participantsNum; i++) {
            System.out.printf("%d번째 후보자이름을 입력해 주세요.",i+1);
            participants.add(sc.next());

        }
        System.out.println();
        Random random = new Random();

        //각후보별 득표수
        int[] votes = new int[participantsNum];

        // 투표진행
        for (int i = 0; i < vote; i++) {
            int currentVote = random.nextInt(participantsNum);
            votes[currentVote]++;

            System.out.println(String.format("[투표진행률]: %.2f%%, %d명 투표 => %s",(i+1.0)*100/vote,i+1,participants.get(currentVote)));
            for (int j=0;j<participantsNum;j++) {
                System.out.println(String.format("[기호:%d] %s:  %.2f%%  (투표수: %d)", (j + 1), participants.get(j), votes[j]*100.0 / vote, votes[j]));
            }
            System.out.println();
        }
        // 투표득표 결과 계산
        int result = 0,count = 0;
        for(int i =0,temp = 0; i < votes.length ; i++) {
            if(temp<votes[i]){
                temp=votes[i];
                result =i;
                count=0;
            }else if(temp==votes[i]){
                count++;
            }
        }
        // 최종 결과 출력
        if(count == 0) {
            System.out.println(String.format("[투표결과]  당선인:  %s", participants.get(result)));
        }else {
            System.out.println("[투표결과] 1등 동률이 발생하여 재투표 필요합니다.");
        }

    }

}