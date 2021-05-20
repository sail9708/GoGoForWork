package LeetCode;

import org.jetbrains.annotations.NotNull;

import java.util.Deque;
import java.util.LinkedList;

public class No_0020_validParentheses {

    /*****test case********/
    private static String s = "()[]{}";
    /**********************/


    public boolean isValid( String s) {
        //定义一个栈
        Deque<Character> stack = new LinkedList<>();
        Character c;

        for(int pointer = 0; pointer <s.length(); pointer++){
            c = s.charAt(pointer);
            if(c == '{'){
                stack.push('}');
            }
            else if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new No_0020_validParentheses().isValid(s));
    }
}
