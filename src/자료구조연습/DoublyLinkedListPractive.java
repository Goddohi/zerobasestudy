package 자료구조연습;

public class DoublyLinkedListPractive {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.addData(1);
        list.addData(2);
        list.addData(3);


        list.addData(4);
        list.showData();

        list.revShowData();
    }
}
class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode pre;


    DoublyNode(){}
    DoublyNode(int data,DoublyNode next,DoublyNode pre) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

}
class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;

    DoublyLinkedList(){}
    DoublyLinkedList(DoublyNode head) {
        this.head = head;
        this.tail = head;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void setTail(DoublyNode tail){

            this.tail= tail;

    }
    public void addData(int data){
        if(this.isEmpty()){
            this.head = new DoublyNode(data, null,null);
            setTail(this.head);
        } else {
            DoublyNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next=new DoublyNode(data, null, cur);
            setTail(cur.next);
        }
    }

    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        DoublyNode cur = this.head;
        DoublyNode prev = cur;
        while (cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next;
                    cur.next.pre = null;
                    if(cur == this.tail){
                        this.tail = cur.next;
                    }
                } else if (cur == this.tail) {
                    this.tail = cur.pre;
                    prev.next = cur.next;
                    cur.next.pre = prev.pre;
                } else {
                    prev.next = cur.next;
                    cur.next.pre = prev.pre;
                }
                break;
            }
        }
    }

    public boolean findData(int data) {
        if (this.isEmpty()) {
            return false;
        }

        DoublyNode cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        DoublyNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+ " ");
            cur = cur.next;
        }
        System.out.println();

    }
    public void revShowData(){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        DoublyNode cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data+ " ");
            cur = cur.pre;
        }
        System.out.println();

    }
}
