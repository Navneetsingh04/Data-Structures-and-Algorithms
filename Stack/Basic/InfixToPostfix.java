// Given an infix expression, Your task is to convert the given infix expression to a postfix expression.

import java.util.Stack;

public class InfixToPostfix {
    public static int precedence(char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }
    public static String infixToPostFix(String exp){
        Stack<Character> st = new Stack<>();
        String result = new String("");
        for(int i = 0;i<exp.length();i++){
            char ch = exp.charAt(i);
            // if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'));
            if(Character.isLetterOrDigit(ch)){
                result += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    result += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(ch) <= precedence(st.peek())){
                    result += st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            if(st.peek() == '('){
                return "Inavlid Expression";
            }
            result += st.pop();
        } 
        return result;
    }
    public static void main(String args[]){
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: "+exp);
        System.out.println("postfix Expression: "+infixToPostFix(exp));
    }
}
