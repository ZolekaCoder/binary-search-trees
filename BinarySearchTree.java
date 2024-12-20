/**
 * This class represents a binary search tree for storing generic data.
 * It extends the BinaryTree class.
 */
public class BinarySearchTree extends BinaryTree
{
   /**
    * Inserts a new node with the provided data into the binary search tree.
    * @param d The data to be inserted.
    */
   public void insert (GenericsFile d)
   {
      if (root == null)
         root = new BinaryTreeNode (d, null, null);
      else
         insert (d, root);
   }
   
   /**
    * Recursive method to insert a new node with the provided data into the binary search tree.
    * @param d The data to be inserted.
    * @param node The current node being examined during the insertion process.
    */
   public void insert (GenericsFile d, BinaryTreeNode node)
   {
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   /**
    * Finds a node with the provided data in the binary search tree.
    * @param d The data to search for.
    * @return The node containing the data if found, otherwise null.
    */
   public BinaryTreeNode find (GenericsFile d)
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   /**
    * Recursive method to find a node with the provided data in the binary search tree.
    * @param d The data to search for.
    * @param node The current node being examined during the search process.
    * @return The node containing the data if found, otherwise null.
    */
   public BinaryTreeNode find (GenericsFile d, BinaryTreeNode node)
   {  
      if (d.getTerm().compareTo (node.data.getTerm()) == 0)
         return node;
      else if (d.getTerm().compareTo (node.data.getTerm()) > 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   /**
    * Finds a node with the provided data (both term and statement) in the binary search tree.
    * @param d The data to search for.
    * @return The node containing the data if found, otherwise null.
    */
   public BinaryTreeNode findStat (GenericsFile d)
   {
      if (root == null)
         return null;
      else
         return findStat (d, root);
   }
   
   /**
    * Recursive method to find a node with the provided data (both term and statement) in the binary search tree.
    * @param d The data to search for.
    * @param node The current node being examined during the search process.
    * @return The node containing the data if found, otherwise null.
    */
   public BinaryTreeNode findStat (GenericsFile d, BinaryTreeNode node)
   {  
      if (d.getStatement().compareTo (node.data.getStatement()) == 0 && d.getTerm().compareTo (node.data.getTerm()) == 0)
         return node;
      else if (d.getTerm().compareTo (node.data.getTerm()) > 0)
         return (node.left == null) ? null : findStat (d, node.left);
      else
         return (node.right == null) ? null : findStat (d, node.right);
   }
   
   /**
    * Deletes a node with the provided data from the binary search tree.
    * @param d The data to be deleted.
    */
   public void delete (GenericsFile d)
   {
      root = delete (d, root);
   }   
   
   /**
    * Recursive method to delete a node with the provided data from the binary search tree.
    * @param d The data to be deleted.
    * @param node The current node being examined during the deletion process.
    * @return The reference to the root of the modified subtree after deletion.
    */
   public BinaryTreeNode delete (GenericsFile d, BinaryTreeNode node)
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   /**
    * Finds the node with the minimum value in the given subtree.
    * @param node The root node of the subtree.
    * @return The node with the minimum value in the subtree.
    */
   public BinaryTreeNode findMin (BinaryTreeNode node)
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   /**
    * Removes the node with the minimum value in the given subtree.
    * @param node The root node of the subtree.
    * @return The reference to the root of the modified subtree after removal.
    */
   public BinaryTreeNode removeMin (BinaryTreeNode node)
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
