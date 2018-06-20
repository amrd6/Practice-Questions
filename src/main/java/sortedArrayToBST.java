public class sortedArrayToBST {

    static LNode head;
    class LNode {
        int id;
        LNode prev;
        LNode next;

        LNode(int id) {
            this.id = id;
            prev = null;
            next = null;
        }
    }

    static class TNode {
        int id;
        TNode left;
        TNode right;

        TNode(int id){
            this.id = id;
            left = null;
            right = null;
        }
    }

    public void push(int id){
        LNode newNode = new LNode(id);

        newNode.prev = null;
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    public int count(LNode head) {
        LNode it = head;
        int count = 0;
        while(it!= null){
            count++;
            it = it.next;
        }
        return count;
    }

    public TNode sortedArrayToBSTMethod(int[] a, int i, int j){
        if(i > j ){
            return null;
        }
        int mid = i + (j-i)/2;
        TNode root = new TNode(a[mid]);

        root.left = sortedArrayToBSTMethod(a, i, mid-1);
        root.right = sortedArrayToBSTMethod(a,mid+1, j);

        return root;
    }

    public void preorder(TNode root){
        if(root == null) {
            return;
        }
        System.out.print(" " +root.id + " ");
        preorder((root.left));
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        sortedArrayToBST s = new sortedArrayToBST();
        TNode root = s.sortedArrayToBSTMethod(a, 0, a.length-1);
        s.preorder(root);
    }
}
