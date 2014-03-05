/**
 * Created by user on 03.03.14.
 */
public class Matrix {
    int [][] A ;
    private Stroka[] stroki;
    private Stolbec[] stolbiki;
    int n=10,m=10;

    Matrix(){
        this(1,1);
        setij(0,0,1);
    }
    Matrix(int _n, int _m)
    {
        assert _n>0;
        assert _m>0;
        n=_n; m=_m;
        A = new int[n][m];
        for(int [] a : A)
            a= new int[m];
        fullStrize();
    }
    Matrix(int [][]B){
        A = B;
        n=A.length;
        m=A[0].length;
        fullStrize();
    }

    private void fullStrize(){
        for(int i = 0; i<n;i++)
            stroki[i]=new Stroka(A[i]);
        stolbiki = new Stolbec[m];
        for(int i=0; i<m;i++)
        {
            stolbiki[i] = new Stolbec(n);
            for(int j=0; j<n; j++){
                stolbiki[i].setone(j, stroki[j].get(i) );
            }
        }
    }
    private void strize(){
        for(int i=0; i<m;i++)
        {
            stolbiki[i] = new Stolbec(n);
            for(int j=0; j<n; j++){
                stolbiki[i].setone(j, stroki[j].get(i) );
            }
        }
    }

    public int getN(){
        return n;
    }
    public int getM(){
        return m;
    }
    public void setij(int i, int j, int x)
    {
        assert (i<n) && (j<m);
        A[i][j] = x;
        strize();
    }
    public int getij(int i,int j){
        assert (i<n) && (j<m);
        return A[i][j];
    }
    public void setH(int i, int [] x)
    {
        assert x.length==m;
        A[i] = x;
        strize();
    }
    public void setV(int j, int []x){
        assert x.length==n;
        for(int i=0;i<n;i++)
            setij(i,j,x[i]);
        fullStrize();
    }
    public Stolbec getV(int i){
        assert i<m;
        return stolbiki[i];
    }
    public Stroka getH(int i){
        assert i<n;
        return stroki[i];
    }

    public Matrix invert(){
        Matrix At = new Matrix(m,n);
        for(int i=0;i<m;i++)
            At.setH(i, stolbiki[i].getList());
        return At;
    }

    public Matrix multiply(Matrix B){
        if (B.getN() != this.getM())
            return null;

        Matrix C = new Matrix(this.getN(), B.getM());
        int i=0,j=0;
        for(i=0; i<this.getN();i++)
            for(j=0; j<this.getM(); j++)
                C.setij(i,j, this.getH(i).multiple(B.getV(j)));
        return C;
    }


    public static void main(String args[])
    {
        int [][]a= {    {1,2,3},
                        {1,4,2},
                        {4,5,2}     };
        Matrix A = new Matrix(3,3);
        int det = Det.composition(A);

    }
}
