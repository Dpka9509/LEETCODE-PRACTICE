import java.util.Stack;

public class validparantehesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } 
            else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            } 
            else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";

        System.out.println(s1 + " -> " + isValid(s1));
        System.out.println(s2 + " -> " + isValid(s2));
        System.out.println(s3 + " -> " + isValid(s3));
    }
}
