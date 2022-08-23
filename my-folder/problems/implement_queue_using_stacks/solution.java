class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        this.maintenance();
        return out.pop();
    }
    
    private void maintenance() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }
    
    public int peek() {
        this.maintenance();
        return out.get(out.size()-1);
        
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */