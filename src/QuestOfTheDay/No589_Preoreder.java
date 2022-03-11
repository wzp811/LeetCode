package QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;

public class No589_Preoreder {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        process(root,ans);
        return ans;
    }
    public void process(Node root,List<Integer> ans){
        ans.add(root.val);
        for(int i=0;i<root.children.size();i++){
            process(root.children.get(i),ans);
        }
    }
}
