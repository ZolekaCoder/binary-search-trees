/**
 * This class represents a binary tree structure.
 */
public class BinaryTree
{
   // Reference to the root node of the binary tree
   BinaryTreeNode root;
   
   /**
    * Constructor to create an empty binary tree.
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Calculates the height of the binary tree.
    * @return The height of the binary tree.
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   
   /**
    * Recursive method to calculate the height of a subtree rooted at the given node.
    * @param node The root node of the subtree.
    * @return The height of the subtree.
    */
   public int getHeight (BinaryTreeNode node)
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
   }
   
   /**
    * Calculates the number of nodes in the binary tree.
    * @return The size of the binary tree.
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   
   /**
    * Recursive method to calculate the number of nodes in a subtree rooted at the given node.
    * @param node The root node of the subtree.
    * @return The size of the subtree.
    */
   public int getSize (BinaryTreeNode node)
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize(node.getLeft()) + getSize(node.getRight());
   }
   
   /**
    * Visit a node by printing its data.
    * @param node The node to be visited.
    */
   public void visit (BinaryTreeNode node)
   {
      System.out.println (node.data);
   }
   
   /**
    * Perform a pre-order traversal of the binary tree.
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   
   /**
    * Recursive method to perform a pre-order traversal of a subtree rooted at the given node.
    * @param node The root node of the subtree.
    */
   public void preOrder (BinaryTreeNode node)
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft());
         preOrder (node.getRight());
      }   
   }

   /**
    * Perform a post-order traversal of the binary tree.
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   
   /**
    * Recursive method to perform a post-order traversal of a subtree rooted at the given node.
    * @param node The root node of the subtree.
    */
   public void postOrder (BinaryTreeNode node)
   {
      if (node != null)
      {
         postOrder (node.getLeft());
         postOrder (node.getRight());
         visit (node);
      }   
   }

   /**
    * Perform an in-order traversal of the binary tree.
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /**
    * Recursive method to perform an in-order traversal of a subtree rooted at the given node.
    * @param node The root node of the subtree.
    */
   public void inOrder (BinaryTreeNode node)
   {
      if (node != null)
      {
         inOrder (node.getLeft());
         visit (node);
         inOrder (node.getRight());
      }   
   }
}
