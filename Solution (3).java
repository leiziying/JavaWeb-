class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list3 = null;
        if (list1.val < list2.val) {
            list3 = list1;
            list3.next = Merge(list1.next, list2);
        } else {
            list3 = list2;
            list3.next = Merge(list1, list2.next);
        }
        return list3;
    }
}
