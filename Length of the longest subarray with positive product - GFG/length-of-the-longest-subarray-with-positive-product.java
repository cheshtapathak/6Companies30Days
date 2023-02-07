//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        int dp[] = new int[2];
        if(arr[0] == 0) dp = new int[]{0,0};
        else if(arr[0] > 0) dp = new int[]{1,0};
        else dp = new int[]{0,1};
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            if(arr[i] > 0){
                dp[0] = dp[0] + 1;
                if(dp[1] > 0) dp[1] = dp[1] + 1;
                else dp[1] = 0;
            }else if(arr[i] < 0){
                int temp = dp[0];
                if(dp[1] > 0) dp[0] = dp[1] + 1;
                else dp[0] = 0;
                dp[1] = temp + 1;
            }else{
                dp[0] = 0;
                dp[1] = 0;
            }
            max = Math.max(max,dp[0]);
            // System.out.println(dp[i][0] + " " + dp[i][1]);
        }
        
        return max;
    }
   
}