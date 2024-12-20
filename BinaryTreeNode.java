/**
 * This class represents a node in a binary tree used for storing generic data.
 */
public class BinaryTreeNode
{
   // Data stored in the node
   GenericsFile data;
   // Reference to the left child node
   BinaryTreeNode left;
   // Reference to the right child node
   BinaryTreeNode right;
   
   /**
    * Constructor to initialize a BinaryTreeNode with provided data and child references.
    * @param d The data to be stored in the node.
    * @param l Reference to the left child node.
    * @param r Reference to the right child node.
    */
   public BinaryTreeNode (GenericsFile d, BinaryTreeNode l, BinaryTreeNode r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   /**
    * Retrieves the left child node of this node.
    * @return Reference to the left child node.
    */
   BinaryTreeNode getLeft () { return left; }
   
   /**
    * Retrieves the right child node of this node.
    * @return Reference to the right child node.
    */
   BinaryTreeNode getRight () { return right; }
   
   /**
    * Retrieves the data stored in this node.
    * @return The data stored in this node.
    */
   public GenericsFile getData() { return data; }
   
   /**
    * Returns a string representation of the data stored in this node.
    * @return A string representation of the data stored in this node.
    */
   public String toString() { return data.toString(); }
}
