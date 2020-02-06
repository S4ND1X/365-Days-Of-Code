public class QuickFindUF{

    private int[] id;
    /**
     * @param N Number of points
     */
    public QuickFindUF(int N)
    {
        this.id = new int[N];
        for (int i = 0; i < N; i++) 
        {
            this.id[i] = i;
        }
    }
    /**
     * @param P is the first point
     * @param Q is the second point
     * @return true if connected, else return false
     */
    public boolean connected(int P, int Q) 
    {  return this.id[P] == this.id[Q];  }

    /**
     * @param P the point to be conected with Q and the one that change his id
     * @param Q the point to be connected with P and the one that gives the ID
     */
    public void union(int P, int Q)
    {
        for (int i = 0; i < this.id.length; i++) {
            //Si el ID en la posicion actual tiene el mismo ID que P, entonces se cambiara por el ID de Q 
            if(this.id[i] == this.id[P])
                {  this.id[i] = this.id[Q];  }
        }
    }
}