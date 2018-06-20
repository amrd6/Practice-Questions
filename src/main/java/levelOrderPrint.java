import org.apache.commons.net.io.ToNetASCIIOutputStream;

public class levelOrderPrint {

    class LNode<K> {
        K id;
        LNode<K> next;
        LNode(K id){
            this.id = id;
            next = null;
        }
    }

    class Stack<K>{
        int size = 0;
        LNode<K> head;
        Stack(){
            head = null;
        }
        void push(K id){
            size++;
            if(id == null){
                return;
            }
            LNode<K> a = new LNode<K>(id);
            a.next = head;
            head = a;
        }

        LNode<K> pop(){
            size--;
            if(head == null){
                return null;
            }
            LNode<K> r = head;
            head = head.next;
            return r;
        }
        int getSize(){
            return size;
        }

        Boolean isEmpty(){
            return head==null;
        }
    }
    class Queue<K> {
        LNode<K> head;
        Queue(){
            head = null;
        }
        void add(K id) {
            if(id == null){
                return;
            }
            LNode<K> a = new LNode<K>(id);
            if(head == null){
                head  = a;
                return;
            }
            LNode<K> p = head;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = a;
        }

        LNode<K> dequeue(){
            if(head == null){
                return null;
            }
            LNode<K> r = head;
            head = head.next;
            return r;
        }

        Boolean isEmpty(){
            return head==null;
        }
    }

    private void levelOrderTraversal(sortedArrayToBST.TNode root){
        Queue<sortedArrayToBST.TNode>  q = new Queue<sortedArrayToBST.TNode>();
        q.add(root);
        while(!q.isEmpty()){
            LNode<sortedArrayToBST.TNode> node = q.dequeue();
            sortedArrayToBST.TNode node1 = node.id;
            System.out.print(node1.id);
            q.add(node1.left);
            q.add(node1.right);
        }
    }

    public void zigzagTreeTraversal(sortedArrayToBST.TNode root){
        int maxwidth = 0;
        Stack<sortedArrayToBST.TNode> lr = new Stack<sortedArrayToBST.TNode>();
        Stack<sortedArrayToBST.TNode> rl = new Stack<sortedArrayToBST.TNode>();
        lr.push(root);
        while(!lr.isEmpty() || !rl.isEmpty()){
            if(maxwidth < lr.size){
                maxwidth = lr.size;
            }
            if(maxwidth < rl.size){
                maxwidth = rl.size;
            }
            while(!lr.isEmpty()){
                LNode<sortedArrayToBST.TNode> node = lr.pop();
                sortedArrayToBST.TNode n = node.id;
                System.out.print(n.id);
                rl.push(n.right);
                rl.push(n.left);
            }

            while(!rl.isEmpty()){
                LNode<sortedArrayToBST.TNode> node = rl.pop();
                sortedArrayToBST.TNode n = node.id;
                System.out.print(n.id);
                lr.push(n.left);
                lr.push(n.right);
            }
        }

        System.out.println("\nmaxwidth " + maxwidth);
    }

    public void mirrorTreeRecurr(sortedArrayToBST.TNode root){
        if(root == null){
            return;
        }
        sortedArrayToBST.TNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTreeRecurr(root.left);
        mirrorTreeRecurr(root.right);
    }

    public void mirrorTreeIter(sortedArrayToBST.TNode root){
        Stack<sortedArrayToBST.TNode> s1 = new Stack<sortedArrayToBST.TNode>();
        s1.push(root);
        sortedArrayToBST.TNode n,temp;
        LNode<sortedArrayToBST.TNode> node;
        while(!s1.isEmpty()){
            node = s1.pop();
            n = node.id;
            temp = n.left;
            n.left = n.right;
            n.right = temp;
            s1.push(n.left);
            s1.push(n.right);
        }
    }

    private void inorderIterative(sortedArrayToBST.TNode root){
        if(root == null) {
            return;
        }
        Stack<sortedArrayToBST.TNode> s = new Stack<sortedArrayToBST.TNode>();
        sortedArrayToBST.TNode curr = root;

        while(curr!= null){
                s.push(curr);
                curr = curr.left;
        }

        while(!s.isEmpty()){
            curr = s.pop().id;
            System.out.print(curr.id + " ");
            if(curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
    }

    private void inorderRecurr(sortedArrayToBST.TNode root){
        if(root == null){
            return;
        }
        inorderRecurr(root.left);
        System.out.print(root.id+" ");
        inorderRecurr(root.right);
    }

    public void printKDistDown(sortedArrayToBST.TNode root, int k){
    Stack<sortedArrayToBST.TNode> s1 = new Stack<sortedArrayToBST.TNode>(),
            s2 = new Stack<sortedArrayToBST.TNode>();
        sortedArrayToBST.TNode node;

    s1.push(root);
    while(!s1.isEmpty()|| !s2.isEmpty()){
        while(!s1.isEmpty()){
            node = s1.pop().id;
            if(k==0) {
                System.out.println(node.id);
            } else {
                s2.push(node.right);
                s2.push(node.left);
            }
        }
        if(k==0){
            break;
        }
        k--;
        while(!s2.isEmpty()){
            node = s2.pop().id;
            if(k==0) {
                System.out.println(node.id);
            } else {
                s1.push(node.right);
                s1.push(node.left);
            }
        }
        if(k==0){
            break;
        }
        k--;
    }

    }


    public static void main(String[] args) {
        sortedArrayToBST a = new sortedArrayToBST();
        int[] arr = {1,2,3,4,5,6,7,8};
        sortedArrayToBST.TNode root = a.sortedArrayToBSTMethod(arr, 0, arr.length -1);
        levelOrderPrint l = new levelOrderPrint();

        System.out.println("levelOrderTraversal");
        l.levelOrderTraversal(root);

        System.out.println("\nzigzagTreeTraversal");
        l.zigzagTreeTraversal(root);

        System.out.println("\nmirrorTreeRecurr");
        l.mirrorTreeRecurr(root);
        l.levelOrderTraversal(root);

        System.out.println("\nmirrorTreeIter");
        l.mirrorTreeIter(root);
        l.levelOrderTraversal(root);

        System.out.println("\ninorderRecurr");
        l.inorderRecurr(root);

        System.out.println("\ninorderIter");
        l.inorderIterative(root);

        System.out.println("\nprintKDistDown");
        int[] kdistarr = {4,8,10,12,14,20,22};
        sortedArrayToBST.TNode root1 = a.sortedArrayToBSTMethod(kdistarr, 0, kdistarr.length -1);
        l.printKDistDown(root1, 2);
    }
}
