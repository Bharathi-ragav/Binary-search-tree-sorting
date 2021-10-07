import java.util.Scanner;

public class BinaryTreeToSort {
    
    public static void main(String[] args) {

        binary tree = new binary();
        Scanner in  = new Scanner(System.in);

        System.out.println("\n\tEnter List to Sort in Alphabetical Order , Enter '#' to end the input");

        String str = in.next();

        while(!str.equals("#")){
            str=str.toUpperCase();
            tree.insert(str);
            str = in.next();
        }

        in.close();
        //print in ascending order
        System.out.println("List In Order :");
        tree.inorder(tree.root);
    
    }
}
//creating Node class to have Node datatype;
    class Node{

       String data ; 
       Node left ,right ;
        
       Node(String data){
            this.data = data ;
            left = right = null ;
       }
       
    }

    class binary{

        Node root ; 

        binary(String key){
            root=new Node(key);
        }

        binary(){
            root=null;
        }

//print the tree in inorder traversal

        public void inorder(Node node){
            if(node!=null){

                inorder(node.left);
                System.out.println(node.data);
                inorder(node.right);
            }
        }

        // to insert data to the tree 
        public void insert(String key){
            root = insertkey(root, key);
        }

        public Node insertkey(Node root , String key){

            if(root==null){
                root = new Node( key);
            }

            else if(key.charAt(0)<root.data.charAt(0)){
                root.left = insertkey(root.left, key);
            }

            else if(key.charAt(0)>root.data.charAt(0)){
                root.right = insertkey(root.right, key);
            }

            else{

                if(key.equals(root.data))

                         root.left = insertkey(root.left, key); 
                
                else{
                        int side = check(key,root.data,0);

                         if(side==1)
                            root.left = insertkey(root.left, key);
                         else
                            root.right = insertkey(root.right, key);
                    }
                }

            return root ; 
        }
//if first charater is same , checking for next character and return which side the string has to added ;

        public  int check(String key , String data,int i){
          int side = 0 ;
          int len_key = key.length();
          int len_data = data.length();
          int min = len_key<len_data ? len_key : len_data ;

          if(min==i){
            side =  len_key<len_data? 1 : 0 ; // 1 = String has to be added to the left subtree, 0 for right subtree.
            return side ;
          }
                if(key.charAt(i)!=data.charAt(i)){
                    if(key.charAt(i)<data.charAt(i)){
                        return 1 ; 
                    }
                    else return 0 ;
                }
                else{
                     side = check(key,data,i+1);
                }
            
            return side;
        }
        
    }
