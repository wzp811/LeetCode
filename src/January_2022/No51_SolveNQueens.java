package January_2022;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No51_SolveNQueens {
    char[] row;
    public List<List<String>> solveNQueens(int n){
        row = new char[n];
        Arrays.fill(row,'.');
        int[] help = new int[n];
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        process(n,0,res,cur,help);
        return res;
    }
    public void process(int n,int index,List<List<String>> res,List<String> cur,int[] help){
        if(index==n){
            List<String> tmp = new LinkedList<>(cur);
            res.add(tmp);
            return;
        }
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j=0;j<index;j++){
                if(help[j]==i||Math.abs(j-index)==Math.abs(help[j]-i)) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                help[index] = i;
                row[i] = 'Q';
                cur.add(new String(row));
                row[i] = '.';
                process(n,index+1,res,cur,help);
                cur.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        No51_SolveNQueens obj = new No51_SolveNQueens();
        System.out.println(obj.solveNQueens(3));
    }
}
