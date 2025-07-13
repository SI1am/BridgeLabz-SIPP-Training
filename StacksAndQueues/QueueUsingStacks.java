package StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stackEnq = new Stack<>();
    private Stack<T> stackDeq = new Stack<>();

    public void enqueue(T x) {
        stackEnq.push(x);
    }

    public T dequeue() {
        if (stackDeq.isEmpty()) {
            while (!stackEnq.isEmpty()) {
                stackDeq.push(stackEnq.pop());
            }
        }
        if (stackDeq.isEmpty()) throw new RuntimeException("Queue is empty");
        return stackDeq.pop();
    }
}
