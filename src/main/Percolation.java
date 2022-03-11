package main;


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF uf ;
    WeightedQuickUnionUF ufBack;
    Boolean[][] grid;
    int n;

    public Percolation(int n) {
        uf = new WeightedQuickUnionUF(n * n + 2); // add nodes on the bottom and top
        ufBack = new WeightedQuickUnionUF(n * n); // is full? add a node on the top
        this.n = n;

        if (n >= 0) {
            grid = new Boolean[n][n];
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    grid[i][j] = false;
                }
            }
        }

        else
            throw new IllegalArgumentException("n < 0");

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = Box2Index(row, col);
        grid[row - 1][col - 1] = true;

        //考虑边界条件
        if(row != 1 && isOpen(row - 1, col)) {
            uf.union(Box2Index(row - 1, col), index);
            ufBack.union(Box2Index(row - 1, col), index);
        }

        if(col != 1 && isOpen(row, col -1)) {
            uf.union(Box2Index(row, col - 1), index);
            ufBack.union(Box2Index(row, col - 1), index);
        }

        if(row != this.n && isOpen(row + 1, col)) {
            uf.union(Box2Index(row + 1, col), index);
            ufBack.union(Box2Index(row + 1, col), index);
        }

        if(col != this.n && isOpen(row , col + 1)) {
            uf.union(Box2Index(row, col + 1), index);
            ufBack.union(Box2Index(row, col + 1), index);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return grid[row - 1][col - 1] && ufBack.connected(0, Box2Index(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int cnt = 0;

        for(int i = 0; i < this.n; i ++) {
            for (int j = 0; j < this.n; j ++) {
                if(grid[i][j] == true)
                    cnt ++;
            }
        }
        return cnt;
    }

    // does the system percolate?
    public boolean percolates() {
        if( n == 1) return isOpen(1, 1);
        return uf.connected(n * n + 1, 0);
    }

    public int Box2Index(int row, int col) {
        return (row - 1) * col;
    }

}
