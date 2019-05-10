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

    public void PreStack(Node root){
        StackLinked<Node> stack = new StackLinked<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }

    public void levelOrder(Node root){
        QueueLinkedList<Node> queue = new QueueLinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.e);
            if(cur.left!=null)
                queue.offer(cur.left);
            if(cur.right!=null)
                queue.offer(cur.right);
        }
    }

    public E miniNum(){
        if(size==0){
            throw new IllegalArgumentException("empty");
        }
        return miniNum(root).e;
    }
    private Node miniNum(Node node){
        if(node.left==null)
            return node;
        return miniNum(node.left);
    }

    public E maxNum(){
        if(size==0){
            throw new IllegalArgumentException("empty");
        }
        return maxNum(root).e;
    }
    private Node maxNum(Node node){
        if(node.right==null)
            return node;
        return maxNum(node.right);
    }

    public E removeMin(){
        E res = miniNum();
        removeMin(root);
        return res;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E res = maxNum();
        removeMax(root);
        return res;
    }
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node,E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }
        else {
            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if(node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node newNode = miniNum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;
            node.left = node.right = null;
            return newNode;
        }
    }

    public void transFerPre(){
        transFerPre(root);
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
