/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
    public static int minUttar(int n,int k,int[] parivaar,HashMap<Integer,Integer> yaddasht,int currMan){
        if(currMan>=n)
            return Integer.MAX_VALUE;//Binod ho kya??
        if(yaddasht.containsKey(currMan))
            return yaddasht.get(currMan);
        int[] rishtedaarOnTable=new int[101];//as families are max 100
        int totalInefficiency=Integer.MAX_VALUE, currInefficiency=0, leastInefficiency=Integer.MAX_VALUE, finalInefficiency=Integer.MAX_VALUE;//maintaining record of inefficiency
        for(int i=currMan;i<n; i++){//starting from currPerson to n
            rishtedaarOnTable[parivaar[i]]++;//incrementing one person of a family on table
            if(rishtedaarOnTable[parivaar[i]]>=2){ //if two or more person of same family are there
                currInefficiency+=rishtedaarOnTable[parivaar[i]]==2?2:1;//inefficiency is incremented 
            }
            finalInefficiency = minUttar(n, k, parivaar, yaddasht, i+1);//checking for next person
            if(finalInefficiency!=Integer.MAX_VALUE)
                finalInefficiency+= currInefficiency + k;//adding cost of table
            if(finalInefficiency<leastInefficiency)
                leastInefficiency = finalInefficiency;//keeping track of leastInefficiency
        }
        totalInefficiency = currInefficiency + k;//total = table + current Inefficiency
        yaddasht.put(currMan,Math.min(leastInefficiency, totalInefficiency));//putting minimum possible inefficiency in the memory to save time
        return yaddasht.get(currMan);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader scan=new Reader();
		int t=scan.nextInt();
		while(t-->0){
		    int n=scan.nextInt(),k=scan.nextInt();
		    int[] parivaar=new int[n];
		    HashMap<Integer,Integer> yaddasht=new HashMap<>();
		    for(int i=0;i<n;i++)
		        parivaar[i]=scan.nextInt();
		    System.out.println(minUttar(n,k,parivaar,yaddasht,0));
		}
	}
}

