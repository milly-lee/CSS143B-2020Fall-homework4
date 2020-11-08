package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
        {
            return;  //base case
        }

        int num = stack.pop();

        reverseStack(stack);
        insertBottom(stack, num);
    }

    private static void insertBottom(Stack<Integer> stack, int num )
    {
        if(stack.isEmpty())
        {
            stack.push(num);
            return;  //base case
        }

        int n = stack.pop();

        insertBottom(stack, num);
        stack.push(n);
    }
}