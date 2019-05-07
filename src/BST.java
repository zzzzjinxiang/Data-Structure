public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;

        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        //相等则什么都不做.
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e)==0){
            return true;
        }
        else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    public void transFerPre(){
        transFerPre();
    }

    private void transFerPre(Node node){
        if(node==null)
            return;
        System.out.println(node.e);
        transFerPre(node.left);
        transFerPre(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBstString(root,0,res);
        return res.toString();
    }

    private void generateBstString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBstString(node.left,depth+1,res);
        generateBstString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
