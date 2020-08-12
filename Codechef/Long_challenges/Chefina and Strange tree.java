/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class StrangeTree
{
    private static int[] P,A,F,D;
    private static ArrayList<HashMap<Integer,Boolean>> graph=new ArrayList<HashMap<Integer,Boolean>>();
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
    public static void printG(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+"-> ");
            for(Map.Entry<Integer,Boolean> entry:graph.get(i).entrySet()){
                System.out.print(entry.getKey()+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int src,int curr,int currDay,boolean[] visited){
        visited[curr]=true;
        for(Map.Entry<Integer,Boolean> entry:graph.get(curr).entrySet()){
            int child=entry.getKey();
            if(!visited[child]&&entry.getValue()){
                dfs(src,child,currDay,visited);
            }
        }
        if(graph.get(src).containsKey(curr)){
            graph.get(src).put(curr,false);
            graph.get(curr).put(src,false);
        }
        F[curr]-=Math.min(A[src],F[curr]);
        if(F[curr]==0&&D[curr]==-1)
            D[curr]=currDay;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader scan=new Reader();
		int t=scan.nextInt();
		while(t-->0){
		    int n=scan.nextInt(),i=0;
		    P=new int[n];A=new int[n];F=new int[n];D=new int[n];
		    for(i=0;i<n;i++)
		        graph.add(new HashMap<Integer,Boolean>());
		    D[0]=-1;
		    for(i=1;i<n;i++){
		        D[i]=-1;
		        int u=scan.nextInt()-1,v=scan.nextInt()-1;
		        graph.get(u).put(v,true);
		        graph.get(v).put(u,true);
		    }
		    for(i=0;i<n;i++)
		        P[i]=scan.nextInt();
		    for(i=0;i<n;i++)
		        A[i]=scan.nextInt();
            for(i=0;i<n;i++)
		        F[i]=scan.nextInt();
		    //printG();
		    for(int days=0;days<n;days++)
		        dfs(P[days]-1,P[days]-1,days+1,new boolean[n]);
		    for(int days=0;days<n;days++)
		        System.out.print(D[days]+" ");
		    System.out.println();
		    graph.clear();
		}
	}
}
