package QuestionList.QuestOfTheDay;

public class No606_Tree2str {
    public String tree2str(TreeNode root) {
        if (root == null) return "()";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) return sb.toString();
        sb.append(process(root.left));
        if (root.right != null) sb.append(process(root.right));
        return sb.toString();
    }

    public StringBuilder process(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("()");
            return sb;
        }
        sb.append("(");
        sb.append(root.val);
        if (!(root.left == null && root.right == null)) {
            sb.append(process(root.left));
            if (root.right != null) sb.append(process(root.right));
        }
        sb.append(")");
        return sb;
    }
}
