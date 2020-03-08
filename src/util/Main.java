package util;

import easy._155_MinStack;

public class Main {
    public static void main(String[] args) {
        _155_MinStack minStack = new _155_MinStack();

        String input[] = {"MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"};
        for (String str: input) {
            System.out.println(str);
        }
        System.out.println(input);
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int a = minStack.top();
        minStack.pop();
        int b = minStack.getMin();
        minStack.pop();
        int c = minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        int d = minStack.top();
        int e = minStack.getMin();
        minStack.push(-2147483648);
        int f = minStack.top();
        int g = minStack.getMin();
        minStack.pop();
        int h = minStack.getMin();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}
