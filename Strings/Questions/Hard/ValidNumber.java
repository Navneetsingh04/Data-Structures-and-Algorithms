/*
L.C: 65. Valid Number

Given a string s, return whether s is a valid number.
For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

Formally, a valid number is defined using one of the following definitions:
An integer number followed by an optional exponent.
A decimal number followed by an optional exponent.
An integer number is defined with an optional sign '-' or '+' followed by digits.
A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
Digits followed by a dot '.'.
Digits followed by a dot '.' followed by digits.
A dot '.' followed by digits.
An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

The digits are defined as one or more digits.

Example 1:
Input: s = "0"
Output: true

Example 2:
Input: s = "e"
Output: false

Example 3:
Input: s = "."
Output: false

Constraints:
1 <= s.length <= 20
s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 
*/

public class ValidNumber {
    public boolean isNumber(String s) {
        int index = -1;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'e' || c == 'E'){
                if(index != -1){
                    return false;
                }
                index = i;
            }
        }
        if(index != -1){
            String left = s.substring(0,index);
            String right = s.substring(index+1);
            boolean leftValid = isDecimal(left) || isInteger(left);
            boolean rightValid = isInteger(right);
            return leftValid && rightValid;
        }
        else{
            return isDecimal(s) || isInteger(s);
        }
    }
    public boolean isInteger(String s){
        if(s.isEmpty()){
            return false;
        }
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i = 1;
        }
        if(i == s.length()){
            return false;
        }
        for(;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public boolean isDecimal(String s){
        if(s.isEmpty()){
            return false;
        }
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i = 1;
        }
        String rem = s.substring(i);
        if(rem.isEmpty()){
            return false;
        }
        int dotIndex = rem.indexOf('.');
        if(dotIndex == -1){
            return false;
        }
        if(rem.indexOf('.',dotIndex+1) != -1){
            return false;
        }
        String beforDot = rem.substring(0,dotIndex);
        String afterDot = rem.substring(dotIndex+1);
        boolean beforDigit = beforDot.isEmpty() || isAllDigit(beforDot);
        boolean afterDigit = afterDot.isEmpty() || isAllDigit(afterDot);
        if(!beforDigit || !afterDigit){
            return false;
        }
        if(beforDot.isEmpty() && afterDot.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean isAllDigit(String s){
        if(s.isEmpty()){
            return true;
        }
        for(int i = 0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "2e0";
        ValidNumber obj = new ValidNumber();
        System.out.println(obj.isNumber(s));
    }
}
