import java.util.*;

/**
 * An implementation of a binary search tree
 */
public class BinarySearchTree < T extends Comparable < T >>
{
  protected BinaryNode < T > root;
  public int BLOCK_SIZE = 8127;

    /**
     * Constructs an empty tree
     */
  public BinarySearchTree ()
  {
    root = null;
  }




  public void empty ()
  {
    root = null;
  }

  public boolean isEmpty ()
  {
    return root == null;
  }

  public BinaryNode < T > getRoot ()
  {
    return root;
  }

  public int height ()
  {
    return height (root);
  }

  protected int height (BinaryNode < T > root)
  {
    if (root == null)
      {
	return -1;
      }
    else
      {
	return Math.max (height (root.getLeft ()),
			 height (root.getRight ())) + 1;
      }
  }

  public boolean contains (T data)
  {
    return contains (data, root);
  }

  protected boolean contains (T data, BinaryNode < T > root)
  {
    if (root == null)
      {
	return false;
      }

    int compareResult = root.getData ().compareTo (data);

    if (compareResult > 0)
      {
	return contains (data, root.getLeft ());
      }
    else if (compareResult < 0)
      {
	return contains (data, root.getRight ());
      }
    else
      {
	return true;
      }
  }

  public T findMin ()
  {
    BinaryNode < T > node = findMin (root);
    return node == null ? null : node.getData ();
  }

  protected BinaryNode < T > findMin (BinaryNode < T > root)
  {
    if (root == null)
      {
	return null;
      }
    else if (root.getLeft () == null)
      {
	return root;
      }
    else
      {
	return findMin (root.getLeft ());
      }
  }

  public T findMax ()
  {
    BinaryNode < T > node = findMax (root);
    return node == null ? null : node.getData ();
  }

  protected BinaryNode < T > findMax (BinaryNode < T > root)
  {
    if (root == null)
      {
	return null;
      }
    else if (root.getRight () == null)
      {
	return root;
      }
    else
      {
	return findMin (root.getRight ());
      }
  }

  public BinaryNode < T > insert (T data)
  {
    root = insert (data, root);
    return root;
  }

  public BinaryNode < T > insert (T data, BinaryNode < T > root)
  {
    if (root == null)
      {
	return new BinaryNode <> (data);
      }

    int compareResult = root.getData ().compareTo (data);

    if (compareResult > 0)
      {
	root.setLeft (insert (data, root.getLeft ()));
      }
    else if (compareResult < 0)
      {
	root.setRight (insert (data, root.getRight ()));
      }

    return root;
  }

  public void remove (T data)
  {
    root = remove (data, root);
  }

  protected BinaryNode < T > remove (T data, BinaryNode < T > root)
  {
    if (root == null)
      {
	return null;
      }

    int compareResult = root.getData ().compareTo (data);

    if (compareResult > 0)
      {
	root.setLeft (remove (data, root.getLeft ()));
      }
    else if (compareResult < 0)
      {
	root.setRight (remove (data, root.getRight ()));
      }
    else if (root.getLeft () != null && root.getRight () != null)
      {
	root.setData (findMin (root.getRight ()).getData ());
	root.setRight (remove (root.getData (), root.getRight ()));
      }
    else
      {
	root = root.getLeft () != null ? root.getLeft () : root.getRight ();
      }

    return root;
  }

  public void printTree ()
  {
    printTree (root);
  }

  protected void printTree (BinaryNode < T > root)
  {
    if (root != null)
      {
	printTree (root.getLeft ());
	System.out.println (root.getData ());
	printTree (root.getRight ());
      }
  }
}
