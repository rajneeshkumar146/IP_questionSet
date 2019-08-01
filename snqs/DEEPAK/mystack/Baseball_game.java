package mystack;
import java.util.*;
public class Baseball_game {
	 public static int calPoints(String[] ops) {
         Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
	public static void main(String[] args) {
String[] s={"5","-2","4","C","D","9","+","+"};
System.out.println(calPoints(s));
	}

}
