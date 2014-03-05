/**
 * Created by user on 04.03.14.
 */
public class Det {

    public static Integer composition(Matrix A){
        Integer I=0;

        boolean b = A.getN() == A.getM();
        if(!b) return null;
        int n = A.getN();

        int [] pi = new int[n+1];
        for(int i = 1; i<=n; i++)
               pi[i]=i;

        Rojok rj = new Rojok(n);
        func(1,n,pi,rj, I, A);
        return I;
    }

    public static void add(int[]pi,Integer I, Matrix A){
        int n = pi.length;
        n--;
        int mono=1;
        int i=1;
        for(i=1;i<=n;i++)
            mono*=A.getij(i, pi[i]);
        I = (int)I + mono;

    }
    public static void func(int req, int n, int[]pi, Rojok rj, Integer I, Matrix A){
        for(int i=1; i<=n-req+1; i++){
            pi[req] = rj.geti(i);
            func(req+1, n , pi, rj, I,  A);
            rj.pop(i);

            if(req == n) add(pi,I,A);
        }
    }
    private static int sign(int [] a){
        int x=0;
        int len = a.length;
        for(int k=1; k<len; k++)
            if (a[k]> k ) x+=a[k]-k;
        x%=2;
        if (x==1) return -1;
        else return 1;
    }
    static class Rojok{
        boolean [] r=null;
        int len=0;

        Rojok(int n){
            r = new boolean[n];
            len = n;
        }

        public void pop(int i){
            r[i -1] = false;
        }

        public int geti(int i){
            int k=i;
            int j;
            for(j =-1; k!=0 ; ){
                j++;
                if ( !r[j]  ) k--;
            }
            r[j]=true;
            return j+1;
        }
    }
}
