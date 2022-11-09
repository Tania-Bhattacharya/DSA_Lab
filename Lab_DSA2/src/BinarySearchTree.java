
import java.util.*;

// A binary tree node
class Node1 {
   int data1;
   Node1 left1, right1;
   Node1(int d){
      data1 = d;
      left1 = right1 = null;
   }
}


public class BinarySearchTree {
 
   Node1 root1;
   BinarySearchTree(){
      root1 = null;
   }
  
   void inorder(){
      inorderUtil1(this.root1);
   }
 
   void inorderUtil1(Node1 node1){
      if (node1 == null)
         return;
      inorderUtil1(node1.left1);
      System.out.print(node1.data1 + " ");
      inorderUtil1(node1.right1);
   }
   
   void insert(int key1){
      root1 = insertRec1(root1, key1);
   }
  
   Node1 insertRec1(Node1 root1, int data1){

   if (root1 == null) {
      root1 = new Node1(data1);
      return root1;
   }
  
   if (data1 < root1.data1)
      root1.left1 = insertRec1(root1.left1, data1);
   else if (data1 > root1.data1)
      root1.right1 = insertRec1(root1.right1, data1);
   return root1;
}
   
   

ArrayList<Integer> treeToList(Node1 node1, ArrayList<Integer> list1){

   if (node1 == null)
      return list1;
   treeToList(node1.left1, list1);
   list1.add(node1.data1);
   treeToList(node1.right1, list1);
   return list1;
}


boolean isPairPresent(Node1 node1, int target1){
   ArrayList<Integer> a1 = new ArrayList<>();
   ArrayList<Integer> a2 = treeToList(node1, a1);
   int start1 = 0; 
   int end1 = a2.size() - 1; 
   while (start1 < end1) {
      if (a2.get(start1) + a2.get(end1) == target1) {
         System.out.println("Pair Found: " + a2.get(start1) + " + " + a2.get(end1) + " " + "= " + target1);
         return true;
      }
      if (a2.get(start1) + a2.get(end1) > target1)
     
      {
         end1--;
      }
      if (a2.get(start1) + a2.get(end1) < target1)

      {
         start1++;
      }
   }
      System.out.println("No such values are found!"); 
    return false;
}


public static void main(String[] args){
   BinarySearchTree tree1 = new BinarySearchTree();
/*
   10
   / \
  20 30
 / \ / \
40 50 60 70 */
      tree1.insert(10);
      tree1.insert(20);
      tree1.insert(30);
      tree1.insert(40);
      tree1.insert(50);
      tree1.insert(60);
      tree1.insert(70);
      tree1.isPairPresent(tree1.root1, 130);
   }
}
