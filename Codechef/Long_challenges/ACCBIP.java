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
    public static  long getAns(int num,int colour,ArrayList<ArrayList<Integer>> lines_set){
        ArrayList<Integer> lines = new ArrayList<Integer>(lines_set.get(colour));
        for(int i=0;i<lines.size() && num>0 ;i++){
            int temp = Math.min(lines.get(i),num);
            lines.set(i,lines.get(i)-temp);
            num = num - temp;
        }
        if(num>0)
            return 0;
        long s1 = 0; 
        int k = lines.size();
        for (int i=0; i<k; i++) 
            s1 += lines.get(i); 
  
        long s2 = 0; 
        long[] temp=new long[k+1];  
        for (int i=0; i<k; i++) 
        { 
            temp[i] = lines.get(i)*(s1-lines.get(i)); 
            s2 += temp[i]; 
        } 
        s2 /= 2; 
      long  s3 = 0; 
        for (int i=0; i<k; i++) 
            s3 += lines.get(i)*(s2-temp[i]); 
        return s3/3;
}
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader scan=new Reader();
		int t=scan.nextInt();
		while(t-->0){
		    int N=scan.nextInt(),C=scan.nextInt(),K=scan.nextInt(),i=0;
		    ArrayList<HashMap<Integer,Integer>> pencil=new ArrayList<HashMap<Integer,Integer>>();
		    ArrayList<ArrayList<Integer>> lines=new ArrayList<ArrayList<Integer>>();
		    for(i=0;i<=N;i++)
		        pencil.add(new HashMap<Integer,Integer>());
		    for(i=1;i<=N;i++){
		        int slope=scan.nextInt(),intercept=scan.nextInt(),color=scan.nextInt();
		        if(!pencil.get(color).containsKey(slope))
		            pencil.get(color).put(slope,0);
		        pencil.get(color).put(slope,pencil.get(color).get(slope)+1);
		    }
		    int[] V=new int[C+1];
		    for(i=1;i<=C;i++)
		        V[i]=scan.nextInt();
		    lines.add(new ArrayList<Integer>());
		    for(i=1;i<=C;i++){
		        ArrayList<Integer> temp=new ArrayList<Integer>();
		        for(Map.Entry<Integer,Integer> mpIt:pencil.get(i).entrySet()){
		            temp.add(mpIt.getValue());
		        }
		        Collections.sort(temp);
		        lines.add(temp);
		    }
		    long[][] mat=new long[K+1][C+1],mem=new long[K+1][C+1];
		    for(i=0;i<=K;i++){
                for(int j=0;j<=C;j++){
                    mat[i][j] = Long.MAX_VALUE;
                    if(j==0)
                        mat[i][j]=0;
                    mem[i][j] = -1;
                }
            }
            for(i=0;i<=K;i++){
                for(int j=1;j<=C;j++){
                    int max_lines_rem = i/V[j];
                    for(int k=0;k<=max_lines_rem;k++){
                        int val_rem = k*V[j];
                        if(mem[k][j]==-1){
                            mem[k][j] = getAns(k,j,lines);
                        }
                        mat[i][j] = Math.min(mat[i][j] , mat[i-val_rem][j-1] +mem[k][j]);
                    }
                }
            }
            System.out.println(mat[K][C]);
		}
	}
}

