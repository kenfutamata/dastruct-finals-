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
        // it is through recursive method
        inOrdertraversal(root);
    }

    private void inOrdertraversal(Node root){

        if(root !=null){
            inOrdertraversal(root.left);
            System.out.print(root.data+" ");
            inOrdertraversal(root.right);
        }
    }

    public void preOrderTraversal(){
        // it is through recursive method
        preOrdertraversal(root);
    }

    private void preOrdertraversal(Node root){

        if (root!=null){
            System.out.print(root.data+" ");
            preOrdertraversal(root.left);
            preOrdertraversal(root.right);
        }
    }

    public void postOrderTraversal(){
        // it is through recursive method
        postOrdertraversal(root);
    }
    private void postOrdertraversal(Node root){
        if (root!=null){
            postOrdertraversal(root.left);
            postOrdertraversal(root.right);
            System.out.print(root.data+" ");
        }
    }


    public Node isempty(){
        if(root == null){
            System.out.println("BST is empty");
        }else{
            System.out.println("BST is not empty");
        }
        return root;

    }
    public boolean search(double value){
        return searchrecursive(root, value);
    }
    public boolean searchrecursive(Node root, double value){
        //program will identify if a node selected within the binary tree is in the binary tree.
       if(root == null){
           return false;
       }
        // node successfully found the node within the binary tree
       else if(root.data == value){
           return true;
       }
       //searching through left subtree
       else if (root.data > value) {
           return searchrecursive(root.left, value);
       }
       //searching through right subtree
       return searchrecursive(root.right, value);
    }

    //Insert through recrsive method
    public void insert(double data){
        root = insertrecursive(root, data);
    }
    public Node insertrecursive(Node root, double data){
        //If the root is still empty
        if(root == null){
            root = new Node(data);
            return root;
        }
        //If value is lesser than the root, program will bring the value to the left
        if(data<root.data) {
            root.left = insertrecursive(root.left, data);
        }
        //If value is greater than the root, program will bring the value to the right.
        else if(data>root.data)
            root.right = insertrecursive(root.right, data);
        return root;
    }

    public Node delete(Node node, double value){
        //isEmpty()
      if(node == null)
          return node;
      //Searching if value is located on the left subtree
      if(value < (double) node.data){
          node.left = delete(root.left, value);
      }
      //Searching if the value is located on the right subtree
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
        //program will find a successor if the selected value is going to be deleted. min is
        // as the minimum or another thing as the part of a succession.
        double min = (double) node.data;
        while(node.left!=null){
            min =(double)node.left.data;
            node=root.left;
        }
        return min;
    }

    public int height(Node node){
        //program will analyze the height of the Binary tree.
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
        //Program will identify the number of nodes inputted on the binary tree
        if (root == null) {
            return 0;
        }
        int l = numbernodes(root.left);
        int r = numbernodes(root.right);

        return 1 + l + r;
    }

    public int getleafcount(){
        //This is through a recursive method
        return numberleaves(root);
    }
    public int numberleaves(Node node){
        //if node is empty
        if(node == null){
            return 0;
        }
        //program will identify the number of leaves on the binary tree.
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
            System.out.println(search(value));
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
