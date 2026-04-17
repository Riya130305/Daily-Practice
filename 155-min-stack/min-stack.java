// class MinStack {
//     ArrayList<Integer> arr;

//     public MinStack() {
//         arr = new ArrayList<>();
//     }
    
//     public void push(int val) {
//         arr.add(val);
//     }
    
//     public void pop() {
//         if(arr.isEmpty()) return;
//         arr.remove(arr.size() - 1);
//     }
    
//     public int top() {
//         if(!arr.isEmpty()) {
//             return arr.get(arr.size() - 1);
//         }
//         return -1;
//     }
    
//     public int getMin() {
//         if(arr.isEmpty()) return -1;

//         int min = arr.get(0);
//         for(int i = 1; i < arr.size(); i++) {
//             if(arr.get(i) < min) {
//                 min = arr.get(i);
//             }
//         }
//         return min;
//     }
// }

// OPTIMIZE APPROCH
class MinStack {
    ArrayDeque<Integer> st ;
    ArrayDeque<Integer> min ;
    public MinStack() {
        st = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty()){
            min.push(val);
        }
        else{
            min.push(Math.min(val,min.peek()));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()) st.pop();
        if(!min.isEmpty()) min.pop();
    }
    
    public int top() {
        if(!st.isEmpty()) return st.peek();
        return -1;
    }
    
    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */