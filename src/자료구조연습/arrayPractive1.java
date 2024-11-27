package 자료구조연습;

public class arrayPractive1 {
    public static void main(String[] args) {
        arrayPractive1 a = new arrayPractive1();
        int[] array = { 1,5,3,8,2,1,3,2,7,97,45,23};
        a.arraySortASC(array);


        System.out.println();
        DynamicArray dynamicArray = new DynamicArray(array);
        System.out.println("=================== 기본값=======================");
        dynamicArray.show();


        System.out.println("=================== 인덱스 2삭제=======================");
        dynamicArray.delete(2);
        dynamicArray.show();

        System.out.println("=================== 97삭제=======================");
        dynamicArray.removeDate(97);
        dynamicArray.show();


        System.out.println("=================== 87추가=======================");
        dynamicArray.add(87);
        dynamicArray.show();

        System.out.println("=================== 인덱스 5에 1000=======================");
        dynamicArray.insert(5,1000);
        dynamicArray.show();
    }

    //정렬방법을 쓰지않고 인덱스 기준으로 하는 간단한 오름차순 방식
    public void arraySortASC(int[] arrInt) {
        int[] visited = new int[arrInt.length]; // 이미 출력을 했을경우를 체크용도
        int visitedCnt = 0;                     //
        int minVal = Integer.MAX_VALUE;         //정수가 가질수 있는 가장 큰값
        int minIndex = -1;

        while (visitedCnt < arrInt.length) {
            for (int i = 0; i < arrInt.length; i++) {
                if (arrInt[i] < minVal && visited[i] == 0) {
                    minVal = arrInt[i];
                    minIndex = i;
                }
            }
            if (minIndex != -1) {
                System.out.print(minVal+" ");
                visited[minIndex] = 1;
                visitedCnt++;
            }

            //다시 초기화
            minVal = Integer.MAX_VALUE;
            minIndex = -1;
        }
        System.out.println();
    }

   static class DynamicArray{
        int[] arrInt;
        public DynamicArray() {}
        public DynamicArray(int[] arrInt) {
            this.arrInt = arrInt;
        }


        public void show(){
            for (int i = 0; i < this.arrInt.length; i++) {
                System.out.print(this.arrInt[i]+" ");
            }
            System.out.println();
        }
       public void add(int data) {

           int[] arrDup = this.arrInt.clone();
           this.arrInt = new int[arrInt.length +1];

           for(int i =0; i < arrDup.length ; i++){
               this.arrInt[i] = arrDup[i];
           }
           this.arrInt[arrDup.length] = data;
       }


        public void insert(int index, int data) {
            if(index<0 || index>this.arrInt.length){
                System.out.println("Index Error");
                return;
            }

            int[] arrDup = this.arrInt.clone();
            this.arrInt = new int[arrInt.length +1];

            for(int i =0; i < index ; i++){
                this.arrInt[i] = arrDup[i];
            }
            for(int i = index ; i < arrInt.length ; i++){
                this.arrInt[i] = arrDup[i-1];
            }
            this.arrInt[index] = data;
        }

        public void delete(int index) {
            if(index<0 || index>this.arrInt.length){
                System.out.println("Index Error");
                return;
            }
            int[] arrDup = this.arrInt.clone();
            this.arrInt = new int[arrInt.length -1];
            for(int i=0 ; i< index ; i++){
                this.arrInt[i] = arrDup[i];
            }
            for(int i = index; i < arrInt.length ; i++){
                this.arrInt[i] = arrDup[i+1];
            }
        }

        public void removeDate(int data){
            int targetIndex = -1;

            for (int i = 0; i < this.arrInt.length; i++) {
                if (this.arrInt[i] == data) {
                    targetIndex = i;
                }
            }

            if (targetIndex == -1) {
                System.out.println(data+"가 배열에 없습니다.");
                return;
            }

            this.delete(targetIndex);


        }

    }

}
