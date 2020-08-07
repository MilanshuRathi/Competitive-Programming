/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    public static int getDigits(int n){
        int total=0,temp;
        for(int i=9;i>=1&&n>0;i--){
            if(n>=i){
                temp=n/i;//gets total occurence of this digit in number
                total+=temp;
                n-=i*temp; //decrements n by product of digit with its occurence   
            }
        }
        return total;
        /*Example 
            sum=28
            n=9*3+1*1; 
            here 9 is digit and 3 is its occurence same is 1 is digit and 1 is its occurence 
        */
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader scan=new FastReader();
		int t=scan.nextInt();
		while(t-->0){
		    int chefPower=scan.nextInt(),rickPower=scan.nextInt();
		    int chefDigits=getDigits(chefPower),rickDigits=getDigits(rickPower);
		    if(chefDigits<rickDigits)
		        System.out.println(0+" "+chefDigits);
		    else
		        System.out.println(1+" "+rickDigits);
		}
	}
}
