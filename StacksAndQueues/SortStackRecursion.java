package StacksAndQueues;

import java.util.Stack;

public class SortStackRecursion {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertSorted(stack, x);
        }
    }
    private static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertSorted(stack, x);
            stack.push(temp);
        }
    }
}
