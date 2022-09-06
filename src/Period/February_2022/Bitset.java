package Period.February_2022;

import java.util.Arrays;

public class Bitset {
    boolean[] bit;
    int size;
    boolean all;
    boolean one;
    int count;
    public Bitset(int size) {
        bit = new boolean[size];
        this.size = size;
        all = false;
        one = false;
        count = 0;
        Arrays.fill(bit,false);
    }

    public void fix(int idx) {
        count += bit[idx]?0:1;
        all = count==size?true:false;
        one = count>0?true:false;
        bit[idx] = true;
    }

    public void unfix(int idx) {
        count -= bit[idx]?1:0;
        all = count==size?true:false;
        one = count>0?true:false;
        bit[idx] = false;
    }

    public void flip() {
        for(int i=0;i<bit.length;i++) bit[i] = !bit[i];
        count = size-count;
        all = count==size?true:false;
        one = count>0?true:false;
    }

    public boolean all() {
        return all;
    }

    public boolean one() {
        return one;
    }

    public int count() {
        return count;
    }

    public String toString() {
        char[] tmp = new char[size];
        for(int i=0;i<size;i++) tmp[i] = bit[i]?'1':'0';
        return new String(tmp);
    }
}
