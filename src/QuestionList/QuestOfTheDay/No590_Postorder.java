package QuestionList.QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No590_Postorder {
    public List<Integer> postorder(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            ans.add(cur.val);
            for(int i=0;i<cur.children.size();i++){
                stack.push(cur.children.get(i));
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<ans.size();i++) res.add(ans.get(ans.size()-1-i));
        return res;
    }
}
