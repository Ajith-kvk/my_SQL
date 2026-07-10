class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else if(!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
            }else if(!stack.isEmpty() && ch == '}' && stack.peek() == '{') {
                stack.pop();
            }else if(!stack.isEmpty() && ch == ']' && stack.peek() == '[') {
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}