class MinStack {
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> stack;
    int p = -1;
    
    /** initialize your data structure here. */
    public MinStack() {  
        stack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        if (x < min) min = x;
        stack.add(x);
        p++;
        return;
    }
    
    public void pop() {
        if (p>-1) {
            int v = stack.get(p);
            stack.remove(p);
            if (v == min) newMin();
            p--;
        }
        return;
    }
    
    public int top() {
        return stack.get(p);
    }
    
    public int getMin() {
        return min;
    }
    
    public void newMin() {
        this.min = Integer.MAX_VALUE;
        for(Integer num : this.stack){
            if (num < this.min) this.min = num;
        }
        return;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */