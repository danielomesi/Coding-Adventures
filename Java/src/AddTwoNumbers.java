public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res= addTwoNumbers(l1,l2);
        res.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursively(l1,l2,0);
    }

    public static ListNode addTwoNumbersRecursively(ListNode l1, ListNode l2,int carry) {
        if (l1 == null && l2 == null && carry==0) return null;

        int digit1 = l1 != null ? l1.val : 0;
        int digit2 = l2 != null ? l2.val : 0;
        int sumOfDigitsWithCarry = digit1 + digit2 +  carry;
        int currentDigitInRes = sumOfDigitsWithCarry % 10;
        int carryForNextDigit = sumOfDigitsWithCarry / 10;
        ListNode nextNode1 = l1 != null ? l1.next : null;
        ListNode nextNode2 = l2 != null ? l2.next : null;
        ListNode nextNodeDigit = addTwoNumbersRecursively(nextNode1,nextNode2,carryForNextDigit);
        ListNode res = new ListNode(currentDigitInRes);
        res.next = nextNodeDigit;
        return res;
    }
}
