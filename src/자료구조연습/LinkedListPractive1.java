package 자료구조연습;

public class LinkedListPractive1 {

    public  static LinkedList removeDup(LinkedList list){
        LinkedList newList = new LinkedList();

        Node cur = list.head;
        while(cur != null){
            if(!newList.findData(cur.data)){
                newList.addData(cur.data);
            }
            cur = cur.next;
        }
        return newList;
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);


        linkedList.addData(4);
        linkedList.showData();

        linkedList= removeDup(linkedList);
        linkedList.showData();

    }
}

    class Node {
        int data;
        Node next;

        Node(){}
        Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }

    }
    class LinkedList {
        Node head;

        LinkedList(){}
        LinkedList(Node head) {
            this.head = head;
        }

        public boolean isEmpty(){
            return this.head == null;
        }

        public void addData(int data){
            if(this.isEmpty()){
                this.head = new Node(data, null);
            } else {
                Node cur = this.head;
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next=new Node(data, null);

            }
        }

        public void removeData(int data){
            if(this.isEmpty()){
                System.out.println("List is Empty");
                return;
            }

            Node cur = this.head;
            Node prev = cur;
            while (cur != null){
                if(cur.data == data){
                    if(cur == this.head){
                        this.head = cur.next;
                    }else {
                        prev.next = cur.next;
                    }
                    break;
                }
            }
        }

        public boolean findData(int data) {
            if (this.isEmpty()) {
                return false;
            }

            Node cur = this.head;
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

            Node cur = this.head;
            while (cur != null) {
                System.out.print(cur.data+ " ");
                cur = cur.next;
            }
            System.out.println();

        }

    }

