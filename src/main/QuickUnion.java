package main;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnion {

    public static class UN {
        int n;
        int [] Seq = new int[n];
        int [] Weight = new int [n]; //每棵树的权重

        //初始化树和各个根结点的权重，每棵树指向自己，每个根结点权重设为1
        public void initArray() {

            for(int i = 0; i < n; i ++){
                Seq[i] = i;
                Weight[i] = 1;
            }
        }

        //寻找根结点，寻找的时候缩短每棵树的高度
        private int root(int p) {
            while(Seq[p] != p){
                Seq[p] = Seq[Seq[p]];
                p = Seq[p];
            }
            return p;
        }

        void union(int p, int q) {
           int PRoot = root(p);
           int QRoot = root(q);

           if(Weight[PRoot] > Weight[QRoot]) {
               Seq[QRoot] = PRoot;
           }

           else {
               Seq[PRoot] = QRoot;
           }
        }

        Boolean connected(int p, int q) {
            return root(p) == root(q);
        }

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UN un = new UN();

        un.n = N;
        un.initArray();


        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(!un.connected(p ,q)){
                un.union(p, q);
            }

        }
    }
}
