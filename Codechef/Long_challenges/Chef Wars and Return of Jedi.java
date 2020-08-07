/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
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
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader scan=new FastReader();
		int t=scan.nextInt();
		while(t-->0){		    
		    int h=scan.nextInt(),p=scan.nextInt();
		    int n=(int)(Math.log(p)/Math.log(2))+1;//here n is number of terms in gp which are >0
		    long pow2=(long)Math.pow(2,n),result=((pow2-1)*2*p)/pow2;//pow=2^n and result is sum of those n terms of gp 
		    //here if health is less than sum chef wins 
		    if((long)h<=result)
		        System.out.println(1);
		    else
		        System.out.println(0);
		}
	}
}
