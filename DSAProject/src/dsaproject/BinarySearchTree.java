package dsaproject;

import java.util.HashMap;

public class BinarySearchTree {

    protected Node root = null, current = null;   // Spare reference for processing
    private int nItems;                 // Used in the protected tree walk
    private Node free = null;        // nodes for re-use
    protected static final boolean DEBUG = false;
    protected static final boolean UNIQUE = false;
    protected HashMap<Integer, Book> bookMap = new HashMap<>();

    /*
     * Insertion in the BST
     */
// Insert the value into its proper place in the binary search tree
    public void insert(Book value) {
        root = insert(root, value);
    }

// Recursive insertion, returning reference to subtree generated.
   private Node insert(Node node, Book value) {
        if (node == null) {
            node = build(value);
        } else if (value.compareTo(node.data) < 0) {
            node.left = insert(node.left, value);
        } // ***** If equal keys allowed, place them right *****
        else if (!UNIQUE) {
            node.right = insert(node.right, value);
        } // ***** Equal keys must be FORBIDDEN *****
        else if (value.compareTo(node.data) > 0) {
            node.right = insert(node.right, value);
        } // ***** If equal keys are NOT allowed, ERROR  *****
        else {
            System.err.println(value + " is already in.");
        } // end if/else if/else if/else if/else
        // Correct this node's height and size after the insertion.
        // The correction propagates upwards in the recursive call stack.
        node.height = newHight(node);
        node.size = newSize(node);
        return node;
    } // end insert(BSTnode, Comparable)
    
    // To get ascending order, do an in-order traversal of the tree
    public void inOrder(Node item) {
        if (item == null) {
            return;            // I.e., empty tree
        }
        inOrder(item.left);                   // Process left sub-tree
        System.out.printf("%25s(%d)\n", item.data, item.height);
        
        inOrder(item.right);                  // Process right sub-tree
    }
    
//  ************** free-space list mainenance ******************  //
// Generate a node, either re-using from the free list or constructed

   private Node build(Book data) {
        Node rtn;

        if (free == null) {
            rtn = new Node(data);
            if (rtn == null) {
                System.err.println("ALLOCATION ERROR.  Abort execution.");
                System.exit(7);
            }
        } else {
            rtn = free;
            free = free.right;
            rtn.data = data;
            rtn.height = 0;
            rtn.size = 1;    // Leaf node
            rtn.left = null;
            rtn.right = null;
        }
        return rtn;
    }

// push node onto free list.
   private void recycle(Node node) {
        if (DEBUG) {
            System.out.println("Recycling node \"" + node.data + '"');
        }
        node.left = null;
        node.right = free;
        free = node;
    } // end recycle
    private static int newHight(Node node) {
        Node lt = node.left,
                rt = node.right;

        if (lt == null && rt == null) // Leaf node is height zero
        {
            return 0;
        } else if (lt == null) // Half node cases
        {
            return 1 + rt.height;
        } else if (rt == null) {
            return 1 + lt.height;
        } else // Full node --- need java.lang.Math.max
        {
            return 1 + Math.max(lt.height, rt.height);
        }
    } // end newHt()

   public Book getBookByISBN(int ISBN){
        inOrderBookMap(this.root);
        Book get = bookMap.get(ISBN);
        return find(get);
    }
//    ******************* Deletion *******************  ///
// Fields required as stable in delete(BSTnode, int)
    Node deleteNode, lastNode;

    /*
     * Delete the node with the value passed.
     */
    public void delete(Book value) {
        deleteNode = null;
        lastNode = null;
        root = delete(root, value);
    }

// Interchange the .data fields on two BSTnodes passed
    static void swapData(Node d, Node s) {
        Book temp = d.data;
        d.data = s.data;
        s.data = temp;
    }

    Node delete(Node node, Book value) {
        if (node == null) {
            return null;
        }

        lastNode = node;                      // Reference to LAST node seen
        if (value.compareTo(node.data) < 0) {
            node.left = delete(node.left, value);
        } else {//When we FIND the node and take one step right, all subsequent
            //steps will be left --- down to the in-order successor
            deleteNode = node;                 // Potentially the node to go
            node.right = delete(node.right, value);
        }

        // In the returns, the call where we are dealing with the replacement
        if (node == lastNode) {//Check to see if we indeed DID find the value
            if (deleteNode != null && value.equals(deleteNode.data)) {//Final check:  if node is RIGHTMOST in its subtree
                if (deleteNode == lastNode) // Half-nodes are easy!
                {
                    node = node.left;            // Return left subtree
                } //node is NOT rightmost in its subtree.  Copy replacement up.
                else {
                    swapData(deleteNode, lastNode);
                    node = node.right;           // Return right subtree
                }
                recycle(lastNode);             // Return the node for re-use
            }
        } else // Adjust heights on the way back up the recursive stack
        {
            node.height = newHight(node);
            node.size = newSize(node);
        }
        return node;
    }
    public void inOrderBookMap(Node item) {
        if (item == null) {
            return;            // I.e., empty tree
        }
        inOrderBookMap(item.left);                   // Process left sub-tree
        bookMap.put(item.data.getISBN(),item.data);
        
        inOrderBookMap(item.right);                  // Process right sub-tree
    }
    ////******************* Simple Find *******************////
    /**
     * Find the cell with the data field corresponding to Value
     */
    Book find(Book value) {
        current = root;
        while (current != null && !current.data.equals(value)) {
            if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current == null ? null : current.data;
    }
    
// Return the size based on the children; node must NOT be null.
    private static int newSize(Node node) {
        Node lt = node.left,
                rt = node.right;

        if (lt == null && rt == null) // Leaf node has size 1
        {
            return 1;
        } else if (lt == null) // Half node cases
        {
            return 1 + rt.size;
        } else if (rt == null) {
            return 1 + lt.size;
        } else // Full node --- do the sum
        {
            return 1 + lt.size + rt.size;
        }
    } // end newSize()
}