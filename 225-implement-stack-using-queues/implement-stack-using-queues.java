import java.util.*;
class MyStack {
    ArrayDeque<Integer> st;
    public MyStack() {
       st= new ArrayDeque<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(!st.isEmpty()) {
            return st.pop();
        }
        return 0;
    }
    
    public int top() {
        if(!st.isEmpty())
       return st.peek();
       return 0;
    }
    
    public boolean empty() {
        if(st.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */