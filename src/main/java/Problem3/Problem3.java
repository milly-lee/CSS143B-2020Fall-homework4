package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        //base case
        if(list == null)
        {
           return;
        }

        //recursive call
        printListInReverse(list.next, print);

        print.println(list.val);


    }
}
