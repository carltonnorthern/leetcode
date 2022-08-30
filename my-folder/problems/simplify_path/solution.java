class Solution {
    public String simplifyPath(String path) {
        StringBuilder canonPath = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        String[] names = path.split("/");
        
        for(String name : names){
            if(name.equals("..")) {
                if(!stack.empty())
                    stack.pop();
            } else if(!name.equals(".") && !name.equals("")) {
                stack.push(name);
            }
        }
        
        for(String s : stack){
            canonPath.append("/" + s);
        }
        
        if(canonPath.toString().equals("")) {
            return "/";
        }
        
        return canonPath.toString();
    }
}