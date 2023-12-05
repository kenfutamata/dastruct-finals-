import java.util.*;
public class binarysearchtree {
static Scanner input = new Scanner(System.in);
    private Node root;

    class Node{
    double data;
    Node left;
    Node right;
    Node (double data){
    this.data = data;
    this.left = null;
    this.right = null;
    }
    }

    public void inOrderTraversal(){
        inOrdertraversal(root);
    }

    public void preOrderTraversal(){
        preOrdertraversal(root);
    }

    public void postOrderTraversal(){
        postOrdertraversal(root);
    }

    private void inOrdertraversal(Node root){

        if(root !=null){
            inOrdertraversal(root.left);
            System.out.print(root.data+" ");
            inOrdertraversal(root.right);
        }
    }

    private void preOrdertraversal(Node root){

        if (root!=null){
            System.out.print(root.data+" ");
            preOrdertraversal(root.left);
            preOrdertraversal(root.right);
        }
    }

    private void postOrdertraversal(Node root){
        if (root!=null){
            postOrdertraversal(root.left);
            postOrdertraversal(root.right);
            System.out.print(root.data+" ");
        }
    }


    public void isempty(){
        if(root == null){
            System.out.println("BST is empty");
        }else{
            System.out.println("BST is not empty");
        }

    }
    public static boolean flag = false;
    public void search(Node node, double value){
        //isEmpty();
        if(root == null){
            System.out.println("Tree is empty");
        }
        else{
            if(node.data == value){
                flag =true;
                System.out.println("Node is found");
                return;
            }
            else{
                System.out.println("Node is not found");
            }
        }
        if(flag == false && node.left!=null){
            search(node.left, value);
        }
        if(flag == false && node.right!=null){
            search(node.right, value);
        }
    }

    public void insert(double data){
        root = insertrecursive(root, data);
    }
    public Node insertrecursive(Node root, double data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data<root.data) {
            root.left = insertrecursive(root.left, data);
        }
        else if(data>root.data)
            root.right = insertrecursive(root.right, data);
        return root;
    }

    public Node delete(Node node, double value){
      if(node == null)
          return node;
      if(value < (double) node.data){
          node.left = delete(root.left, value);
      }
      else if(value > (double)node.data){
          node.right = delete(node.right, value);
      }
      else{
          if(node.left == null){
              return node.right;
          }
          else if(node.right == null)
              return node.left;
          node.data = inordersuccession(node.right);
          node.right = delete(node.right, root.data);

      }
      return node;
    }

    public double inordersuccession(Node node){
        double min = (double) node.data;
        while(node.left!=null){
            min =(double)node.left.data;
            node=root.left;
        }
        return min;
    }

    public int height(Node node){
        if(node == null){
            return 0;
        }
        else{
            int L = height(node.left);
            int R = height(node.right);
            if(L > R){
                return (L+1);
            }else {
                return (R+1);
            }
        }
    }

    public int  numbernodes(Node root) {
        if (root == null) {
            return 0;
        }
        int l = numbernodes(root.left);
        int r = numbernodes(root.right);

        return 1 + l + r;
    }

    public int getleafcount(){
        return numberleaves(root);
    }
    public int numberleaves(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null)
            return 1;
        else
            return numberleaves(node.left)+numberleaves(node.right);
    }

    public void traverse(){

        System.out.println("PRE-ORDER");
    preOrderTraversal();
    System.out.println();
    System.out.println("IN-ORDER");
    inOrderTraversal();
    System.out.println();
        System.out.println("POST-ORDER");
    postOrderTraversal();
    System.out.println();
    }

    //menu driven program
    public void menu(){
        while(true) {
            System.out.println();
            System.out.println("1. DETERMINE WHETHER THE BINARY SEARCH TREE IS EMPTY");
            System.out.println("2. SEARCH THE BINARY SEARCH TREE FOR A PARTICULAR ITEM ");
            System.out.println("3. INSERT AN ITEM IN THE BINARY SEARCH TREE");
            System.out.println("4. DELETE AN ITEM FROM THE BINARY TREE");
            System.out.println("5. FIND THE HEIGHT OF THE BINARY SEARCH TREE");
            System.out.println("6. FIND THE NUMBER OF NODES IN THE BINARY SEARCH TREE");
            System.out.println("7. FIND THE NUMBER OF LEVAES IN THE BINARY SEARCH TREE");
            System.out.println("8. TRAVERSE THE BINARY SEARCH TREE");
            System.out.println("9. EXIT");
            System.out.println("Enter a program: ");
            int choose = input.nextInt();
            choose(choose);
        }
    }
    public Node choose(int choose){
        if(choose == 1){
            isempty();
        }
        else if(choose == 2){
            System.out.println("Enter a node to search: ");
            double value = input.nextDouble();
            search(root, value);
        }

        else if(choose == 3){
            System.out.println("Enter a Node: ");
            double node = input.nextDouble();
            insert(node);
        }

        else if(choose == 4){
            System.out.println("Enter a node that is within the binary tree: ");
            double value = input.nextDouble();
            delete(root, value);
        }
        else if(choose == 5){
            System.out.println("Height of the Tree is "+height(root));
        }
        else if(choose == 6){

            System.out.println("Number of nodes are: "+numbernodes(root));
        }
        else if(choose == 7){
            System.out.println("The number of leaves in the tree are: "+getleafcount());
        }
        else if(choose == 8){
            traverse();
        }
        else if(choose == 9){
            System.exit(0);
        }
        return root;
    }

    public static void main(String[] args) {
        binarysearchtree BST = new binarysearchtree();
        BST.menu();
    }

}
