package Y2022_July;

public class No558_Intersect {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }
        Node cur = new Node();
        cur.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        cur.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        cur.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        cur.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (cur.topLeft.isLeaf && cur.topRight.isLeaf && cur.bottomLeft.isLeaf && cur.bottomRight.isLeaf
                && cur.topLeft.val == cur.topRight.val && cur.topLeft.val == cur.bottomLeft.val && cur.topLeft.val == cur.bottomRight.val) {
            cur.val = cur.topLeft.val;
            cur.isLeaf = true;
            cur.topLeft = null;
            cur.topRight = null;
            cur.bottomLeft = null;
            cur.bottomRight = null;
        } else {
            cur.isLeaf = false;
            cur.val = quadTree1.val | quadTree2.val;
        }
        return cur;
    }

}
