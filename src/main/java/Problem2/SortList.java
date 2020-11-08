package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head)
    {
        //special case, list is 0 or 1
        if(head == null || head.next == null)
        {
            return null;
        }

        //create two node pointers
        ListNode fast = head.next;
        ListNode slow = head;
        //loop through nodes and find middle
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;  //move over two steps
            slow = slow.next;   //move over one step
        }

        ListNode temp = slow.next;
        slow.next = null;
        return temp;

    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        //special case, return not the null list
        if(list1 == null)
        {
            return list2;
        }
        if(list2 == null)
        {
            return list1;
        }

        ListNode node = null;
        if(list1.val < list2.val)
        {
            node = list1;
            list1 = list1.next;
        }
        else
        {
            node = list2;
            list2 = list2.next;
        }

        ListNode head = node; // because we don't want to forget the head

        //keep running until one list is empty
        while ( list1 != null && list2 != null)
        {
           if(list1.val < list2.val)
           {
              node.next = list1;
              list1 = list1.next;
           }
           else
           {
              node.next = list2;
              list2 = list2.next;
           }

           node = node.next;
        }

        if(list1 != null)
        {
            node.next = list1;  //add the remaining nodes
        }
        else
        {
            node.next = list2;
        }

        return head;
    }
}
