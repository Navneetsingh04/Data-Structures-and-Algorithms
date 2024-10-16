import java.util.ArrayList;
import java.util.List;
public class DifferentWaytoAddParentheses {
    public static List<Integer> func(String exp,int start,int end,List<Integer>[][] dp){
        List<Integer> ans = new ArrayList<>();
        if(dp[start][end] != null){
            return dp[start][end];
        }
        if(start == end){
            int num = exp.charAt(start)-'0';
            ans.add(num);
            return ans;
        }
        if(end-start == 1 && Character.isDigit(exp.charAt(start))){
            int num = Integer.parseInt(exp.substring(start,end+1));
            ans.add(num);
            return ans;
        }
        for(int i = start;i<=end;i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = func(exp,start,i-1,dp);
            List<Integer> right = func(exp,i+1,end,dp);
            for(int l : left){
                for(int r : right){
                    if(op == '*'){
                        ans.add(l*r);
                    }
                    else if(op == '+'){
                        ans.add(l+r);
                    }
                    else{
                        ans.add(l-r);
                    }
                }
            }
        }
        dp[start][end] = ans;
        return ans;
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        @SuppressWarnings("unchecked")
        List<Integer>[][] dp = new ArrayList[n][n];
        return func(expression,0,n-1,dp);
    }
    public static void main(String[] args) {
        String expression  = "2*3-4*5";
        List<Integer> ans = diffWaysToCompute(expression);
        System.out.println(ans);
    }
}