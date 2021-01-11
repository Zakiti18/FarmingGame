/*
* StringTreeNode.java
* Phillip Ball
* 05/30/2019
* This class has been copied and then edited for the porposes of another class
*/

// Class for storing a single node of a binary tree
public class StringTreeNode {

   // fields
   public String key;
   public StringTreeNode left;
   public StringTreeNode right;
      
   // methods - two constructors
   public StringTreeNode(String key, StringTreeNode left, StringTreeNode right) {
      this.key = key;
      this.left = left;
      this.right = right;   
   }
   
   public StringTreeNode(String key) {
      this(key, null, null);
   }
}