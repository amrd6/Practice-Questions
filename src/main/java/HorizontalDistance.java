import org.apache.commons.compress.archivers.ar.ArArchiveEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class HorizontalDistance {

    static HashMap<Integer, ArrayList<TNode>> hdMap = new HashMap<Integer, ArrayList<TNode>>();

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
    private void inorderRecurr(TNode root){
        if(root == null){
            return;
        }
        inorderRecurr(root.left);
        System.out.print(root.id+" ");
        inorderRecurr(root.right);
    }

    private void horizontalDistance(TNode root, int k){
        if(root == null){
            return;
        }


        System.out.println(root.id + " " + k);
        if(hdMap.containsKey(k)){
            ArrayList<TNode> a = hdMap.get(k);
            a.add(root);
        } else {
            ArrayList<TNode> a = new ArrayList<TNode>();
            a.add(root);
            hdMap.put(k, a);
        }
        horizontalDistance(root.left, k-1);
        horizontalDistance(root.right, k+1);

    }

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);
        root.right.right.left = new TNode(8);
        root.right.right.right = new TNode(9);

        HorizontalDistance hd = new HorizontalDistance();
        hd.inorderRecurr(root);

        System.out.println("horizontalDistance");
        hd.horizontalDistance(root, 0);

        //System.out.println(hdMap);
        Iterator<Integer> it = hdMap.keySet().iterator();
        while(it.hasNext()){
            int i = it.next();
            System.out.print(i + " -> ");
           // System.out.println(i + " " + hdMap.get(i));

            ArrayList<TNode> l = hdMap.get(i);
            Iterator<TNode> p = l.iterator();
            while(p.hasNext()){
                TNode  n = p.next();
                System.out.print(n.id + " ");
            }
            System.out.println();
        }
    }
}
