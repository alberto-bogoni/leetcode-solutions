public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else if (list1 == null && list2 == null) return new ListNode();

        ListNode result = new ListNode(-1);

        ListNode p = result;
        while (list1 != null || list2 != null) {
            int val = 0;

            if (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    val = list2.val;
                    list2 = list2.next;
                } else {
                    val = list1.val;
                    list1 = list1.next;
                }
            } else if (list1 == null) {
                val = list2.val;
                list2 = list2.next;
            } else {
                val = list1.val;
                list1 = list1.next;
            }

            p.next = new ListNode(val);
            p = p.next;
        }

        return result.next;
    }

    public ListNode mergeTwoListsSecond(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining elements of either list
        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

      public class ListNode {
          int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}