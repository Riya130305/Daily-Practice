class MinStack {
    ArrayList<Integer> arr;

    public MinStack() {
        arr = new ArrayList<>();
    }
    
    public void push(int val) {
        arr.add(val);
    }
    
    public void pop() {
        if(arr.isEmpty()) return;
        arr.remove(arr.size() - 1);
    }
    
    public int top() {
        if(!arr.isEmpty()) {
            return arr.get(arr.size() - 1);
        }
        return -1;
    }
    
    public int getMin() {
        if(arr.isEmpty()) return -1;

        int min = arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }
}