/**
 * Created by user on 03.03.14.
 */
public class St {
    int[] st=null;
    int length;
    public St(int len)
    {
        st = new int[len];
        length = st.length;
    }
    public St(int[] a)
    {
         this(a.length);
         copyin(a);
    }

    public int[] getList(){
        return st.clone();
    }
    public int get(int i)
    {
        assert st != null;
        assert i<length;
        return st[i];
    }
    public void setone(int i, int x)
    {
        assert i<length;
        st[i]=x;
    }
    public int multiple (St st){
        int x=0;
        assert st.length==this.length;
        for(int i=0; i<st.length; i++)
            x+=st.get(i)*this.get(i);
        return x;
    }
    public int copyin(int [] a){
        if (a.length == st.length)
            st = (int[])a.clone();
        else return -1;
        return 0;
    }
    public void set(int []a){
        st=a;
        length=a.length;
    }
    public Object clone()
    {
        St x = new St(st.length);
        x.set(this.st);
        return x;
    }
}
