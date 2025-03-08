public class ListNode {
    public int val;
    public ListNode next;


    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void print() {
        System.out.println(val);
        if (next!=null) next.print();
    }
  }
