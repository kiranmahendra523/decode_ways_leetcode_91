import java.util.*;
class Solution {
    int solve(int i,String st,String s,int[] dp){
        if(i>s.length()){
            return 0;
        }
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if( dp[i] != -1){
            return dp[i];
        }
        int ans=0;
        if(i<(s.length()-1)){
            char ch = s.charAt(i);
            char h = s.charAt(i+1);
            int val = Integer.parseInt(s.substring(i,i+2));
            if(val>26){
                ans = ans + solve(i+1,st+ch,s,dp);
            }
            else{
                ans = ans + solve(i+1,st+ch,s,dp) + solve(i+2,st+ch+h,s,dp);
            }
        }
        if(i==(s.length()-1)&&s.charAt(i)!='0'){
            char ch = s.charAt(i);
            ans += solve(i+1,st+ch,s,dp);
        }
        dp[i] = ans;
        return dp[i];
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int []dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return  solve(0,new String(),s,dp);
    }
}
