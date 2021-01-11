/*
* StringSearchTree.java
* Phillip Ball
* 05/30/2019
* This class has been copied and then edited for the porposes of another class
*/

import java.util.*;

public class StringSearchTree {

   // fields
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   private StringTreeNode overallRoot;
   private String preorder = "";
   private String inorder = "";
   private String postorder = "";
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // constructor
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   public StringSearchTree() {
      // empty
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // print methods
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // prints the tree in "preorder" (helper: DLR)
   public void printPreOrder() {
      System.out.print("preorder: ");
      printPreOrder(overallRoot);
      System.out.println();
   }
   
   // private helper method for the public printPreOrder method
   private void printPreOrder(StringTreeNode root) {
      if (root != null) {
         System.out.print(root.key + " ");
         printPreOrder(root.left);         
         printPreOrder(root.right);
      }
      // else if root is null, do nothing
   }
   
   
   
   // prints the tree in "inorder" (helper: LDR)
   public void printInOrder() {
      System.out.print("inorder: ");
      printInOrder(overallRoot);
      System.out.println();
   }
   
   // private helper method for the public printInOrder method
   private void printInOrder(StringTreeNode root) {
      if (root != null) {
         printInOrder(root.left);
         System.out.print(root.key + " ");
         printInOrder(root.right);
      }
      // else if root is null, do nothing
   }
   
   
   
   // prints the tree in "postorder" (helper: LRD)
   public void printPostOrder() {
      System.out.print("postorder: ");
      printPostOrder(overallRoot);
      System.out.println();
   }
   
   // private helper method for the public printPostOrder method
   private void printPostOrder(StringTreeNode root) {
      if (root != null) {
         printPostOrder(root.left);         
         printPostOrder(root.right);
         System.out.print(root.key + " ");
      }
      // else if root is null, do nothing
   }
   
   
   
   // prints the tree as if you were to draw it, but sideways
   public void printSideways() {
      printSideways(overallRoot, "");
   }
   
   // private helper method for the public printSideways method
   private void printSideways(StringTreeNode root, String indent) {
      if (root != null) {
         printSideways(root.right, indent + "    ");
         System.out.println(indent + root.key);
         printSideways(root.left, indent + "    ");
      }
      // else if root is null, do nothing
   }
   
   
   
   // returns a string such as "{a, d, c}" where a, d, and c are keys
   public String toString(){
      if(overallRoot == null){
         return("{}");
      }
      String theString = toString(overallRoot);
      theString = theString.substring(0, theString.length() - 1);
      return "{" + theString + "}";
   }
   
   // private helper method for the public toString method
   String theList = "";
   private String toString(StringTreeNode root) {
      if (root != null) {
         toString(root.left);
         theList += (root.key + ",");
         toString(root.right);
      }
      // return theList
      return theList;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // returns the orders. (Same as print methods but returns rather than prints)
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // returns the tree in "preorder" (helper: DLR)
   public String returnPreOrder() {
      returnPreOrder(overallRoot);
      return preorder;
   }
   
   // private helper method for the public printPreOrder method
   private void returnPreOrder(StringTreeNode root) {
      if (root != null) {
         preorder += root.key;
         returnPreOrder(root.left);
         returnPreOrder(root.right);
      }
      // else if root is null, do nothing
   }
   
   // returns the tree in "inorder" (helper: LDR)
   public String returnInOrder() {
      returnInOrder(overallRoot);
      return inorder;
   }
   
   // private helper method for the public printInOrder method
   private void returnInOrder(StringTreeNode root) {
      if (root != null) {
         returnInOrder(root.left);
         inorder += root.key;
         returnInOrder(root.right);
      }
      // else if root is null, do nothing
   }
   
   
   
   // prints the tree in "postorder" (helper: LRD)
   public String returnPostOrder() {
      returnPostOrder(overallRoot);
      return postorder;
   }
   
   // private helper method for the public printPostOrder method
   private void returnPostOrder(StringTreeNode root) {
      if (root != null) {
         returnPostOrder(root.left);         
         returnPostOrder(root.right);
         postorder += root.key;
      }
      // else if root is null, do nothing
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // searches the tree
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // checks the tree to see if it contains the wanted key
   public boolean containsKey(String key) {
      return containsKey(overallRoot, key);
   }
   
   // helper method for recursion, for the contains method
   private boolean containsKey(StringTreeNode root, String key) {
      // return false if the tree is empty
      if (root == null) {
         return false;
      }
      // returns true if the key is the root of the tree
      else if (root.key.equals(key)) {
         return true;
      }
      else if (root.key.compareTo(key) > 0) {
         // recursively search the left subtree for key
         return containsKey(root.left, key);
      }
      else {
         // recursively search the right subtree for key
         return containsKey(root.right, key);
      }
   }
   
   
   
   // given a key, searches for the key in the tree, and then once the node is found,
   // returns the that key in the node
   public String get(String key){
      return get(overallRoot, key);
   }
   
   // helper method for recursion, for the get method
   private String get(StringTreeNode root, String key){
      // throws an exception if the tree is empty
      if (root == null) {
         throw new NullPointerException("The tree is empty");
      }
      // returns the key of then node with the given key
      else if (root.key.equals(key)) {
         return root.key;
      }
      else if (root.key.compareTo(key) > 0) {
         // recursively search the left subtree for the key
         return get(root.left, key);
      }
      else {
         // recursively search the right subtree for the key
         return get(root.right, key);
      }
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // adding and removing to the tree
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // adds the given key to the tree. sorted based on the key
   public void put(String key) {
      overallRoot = put(overallRoot, key);
   }
   
   // private helper method for recursion, for the put method
   // note this time we return a value
   private StringTreeNode put(StringTreeNode root, String key) {
      // creates a new root if the tree is empty
      if (root == null) {
         root = new StringTreeNode(key);
      }
      // goes through the left side of the tree to find where the given key and value should go
      else if (root.key.compareTo(key) > 0) {
         root.left = put(root.left, key);
      }
      // goes through the right side of the tree to find where the given key and value should go
      else if (root.key.compareTo(key) < 0) {
         root.right = put(root.right, key);
      }
      // else it is a duplicate, so do nothing
      
      return root;
   }
   
   
   
   // removes all nodes from the tree (by setting overallRoot to null)
   public void clear(){
      overallRoot = null;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   // sizes
   ////////////////////////////////////////////////////////////////////////////////////////////////////
   // returns the numbers of levels in the binary tree
   public int countLevels(){
      return countLevels(overallRoot);
   }
   
   // helper method for recursion, for the countLevels method
   private int countLevels(StringTreeNode root){
      if(root == null){
         return 0;
      }
      else{
         return 1 + Math.max(countLevels(root.left), countLevels(root.right));
      }
   }
   
   
   
   // returns the number of nodes in the binary tree
   int theSize = 0;
   public int size(){
      return size(overallRoot, theSize);
   }
   
   // helper method for recursion, for the size method
   private int size(StringTreeNode root, int theSize){
      if(root == null){
         return theSize;
      }
      else{
         theSize++;
         theSize = size(root.left, theSize);
         theSize = size(root.right, theSize);
         return theSize;
      }
   }
   
   
   
   // returns true if there are no nodes in the tree (when overallRoot is null), false otherwise
   public boolean isEmpty(){
      return overallRoot == null;
   }
   ////////////////////////////////////////////////////////////////////////////////////////////////////
}