package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class MinStack {
    //栈1存放的是需要压栈的值
    Stack<Integer> stack1 = new Stack<>();
    //栈2存放的是最小值
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
        if (stack2.empty() || x <= getMin())
            stack2.push(x);
    }

    public void pop() {
        //如果出栈的值等于最小值，说明栈中的最小值
        //已经出栈了，因为stack2中的栈顶元素存放的
        //就是最小值，所以stack2栈顶元素也要出栈
        if (stack1.pop() == getMin())
            stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}