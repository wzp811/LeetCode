package Y2022.Y2022_September;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No652_FindDuplicateSubtrees {
    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    public String dfs(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        int cnt = map.getOrDefault(key, 0);
        if (cnt == 1) res.add(root);
        map.put(key, cnt + 1);
        return key;
    }
}
