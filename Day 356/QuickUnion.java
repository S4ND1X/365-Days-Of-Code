/**
 * QuickUnion
 */
public class QuickUnion {
    private int[] root;

    /**
     * Initialize the array with the reference to his root
     * @param N number of points
     */
    public QuickUnion(int N) {
        this.root = new int[N];
        for (int i = 0; i < N; i++) {
            this.root[i] = i;
        }
    }

    /**
     * This method checks the root of the point.
     * @param point is the point you want  to know his root
     * @return integer that represents the root of the point
     */
    private int root(int point){
        while( point != this.root[point]){  point = this.root[point];  }
        return point;
    }

    /**
     * Check if two points are connected, by checking the root
     * @param P first point
     * @param Q second point
     * @return true if connected, else false
     */
    public boolean connected(int P, int Q){
        return root(P) == root(Q);
    }

    /**
     * @param P the point that is going to be the child
     * @param Q the point that is goint to be the father
     */
    public void union(int P, int Q){
        this.root[root(P)] = root(Q);
    }

    public static void main(String[] args) {
        QuickUnion qU = new QuickUnion(5);
        qU.union(0,2);
        qU.union(2,1);
        qU.union(0, 3);
        qU.union(4, 1);
        System.out.println(qU.connected(0, 4));

    }
}