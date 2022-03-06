package main;

import edu.princeton.cs.algs4.StdIn;

//quick sort

public class UnionAndConnected {

    public static class UN{
        int n;
        private int [] Seq = new int[n];

        void initArray(){
            for(int i = 0; i < n; i ++){
                Seq[i] = i;
            }
        }

        void union(int p, int q){
            int pid = Seq[p];
            int qid = Seq[q];

            for(int i = 0; i < n; i++){
                if(Seq[i] == pid)
                    Seq[i] = qid;
            }
        }

        Boolean connected(int p, int q){
            return Seq[p] == Seq[q];
        }

    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UN un = new UN();

        un.n = N;
        un.initArray();

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(!un.connected(p ,q)){
                un.union(p, q);
            }

        }
    }

}
