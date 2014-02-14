
package dsaproject;


public class DSAProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BinarySearchTree bst = new BinarySearchTree();
       Book book1 = new Book("aaa", "xys", "ss", 1);
       Book book2 = new Book("abc", "xys", "ss", 2);
       Book book3 = new Book("bbc", "xys", "ss", 3);
       Book book4 = new Book("eee", "xys", "ss", 4);
       Book book5 = new Book("xya", "xys", "ss", 5);
       Book book6 = new Book("zzz", "xys", "ss", 6);
       
       
       bst.insert(book2);
       bst.insert(book1);
       bst.insert(book4);
       bst.insert(book3);
       bst.insert(book6);
       bst.insert(book5);
       
       bst.inOrder(bst.root);
       
    }
    
}
