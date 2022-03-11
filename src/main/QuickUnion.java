package main;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    int [] Seq;
    int [] Weight; //每棵树的权重

    //初始化树和各个根结点的权重，每棵树指向自己，每个根结点权重设为1
    public QuickUnion(int n) {
        Seq = new int[n];
        Weight = new int [n];
        for(int i = 0; i < n; i ++) {
            Seq[i] = i;
            Weight[i] = 1;
        }
    }

    //寻找根结点，寻找的时候缩短每棵树的高度
    private int root(int p) {
        while(Seq[p] != p) {
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

    void ShowRoot(int n) {
        for (int i = 0; i < n; i++) {
            StdOut.println(root(i));
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();

        QuickUnion myUnion = new QuickUnion(N);

        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(!myUnion.connected(p ,q)) {
                myUnion.union(p, q);
            }
        }
        myUnion.ShowRoot(N);
    }



}
