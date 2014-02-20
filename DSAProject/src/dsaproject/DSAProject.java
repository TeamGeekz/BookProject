package dsaproject;

public class DSAProject {

    static BinarySearchTree bst;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bst = new BinarySearchTree();
        populateTree();
        do {
           printMenu();
        } while (true);

    }

    static void printMenu() {
        System.out.println("Select an Option");
        System.out.println("1) Print Book List");
        System.out.println("2) Enter a new Book ");
        System.out.println("3) Search Book by Titel ");
        System.out.println("4) Search Book by ISBN ");
        System.out.println("5) Delete Book by Titel");
        System.out.println("6) Delete Book by ISBN ");
        System.out.println("7) Show Books By Keyword ");
        System.out.println("0) Exit ");
        System.out.println("");
        System.out.print("User Input :");
        int input = 0;
        try {
            input = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            printMenu();
        }
        switch (input) {
            case 0: {
                System.exit(input);
                break;
            }
            case 1: {
                printBookList();
                break;
            }
            case 2: {
                enterNewBook(null);
                break;
            }
            case 3: {
                searchBookByTitel();
                break;
            }
            case 4: {
                searchBookByISBN();
                break;
            }
            case 5: {
                deleteBookByName();
                break;
            }
            case 6: {
                searchBookByISBN();
                break;
            }
            case 7: {
                ShowBooksByKeyword();
                break;
            }
            default: {
                System.out.println("Invalid option !");
                printMenu();
            }
        }
    }

    static void printBookList() {
        bst.inOrder(bst.root);
    }

    static void populateTree() {
        //Read books from file 
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

    }

    static void enterNewBook(String bookName) {
        if (bookName == null) {
            System.out.printf("%s %5s", "Enter Book Name",":");
            bookName = System.console().readLine();
        }

        System.out.printf("%s %5s", "Enter ISBN",":");
        int ISBN = 0;
        try {
            ISBN = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            enterNewBook(bookName);
        }

        System.out.printf("%s %5s", "Enter Aouther First Name",":");
        String fName = System.console().readLine();
        System.out.printf("%s %5s", "Enter Aouther First Name",":");
        String lName = System.console().readLine();
        Book newBook = new Book(bookName, fName, lName, ISBN);
        bst.insert(newBook);
        System.out.println(" Book " + bookName + "Added ");
    }

    static Book searchBookByTitel() {
        System.out.printf("%s %5s", "Enter Book Name",":");
        String bookName = System.console().readLine();
        Book findBook = new Book();
        findBook.setTitle(bookName);
        Book found = bst.find(findBook);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("No Book found !");
        }
        return found;
    }

    static Book searchBookByISBN() {
        System.out.printf("%s %5s", "Enter ISBN",":");
        int ISBN = 0;
        try {
            ISBN = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            searchBookByISBN();
        }
        Book found = bst.getBookByISBN(ISBN);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("No Book found !");
        }
        return found;
    }

    static void deleteBook(Book b) {
        bst.delete(b);
        System.out.println("Book " + b + " Deleted !");
    }

    static void deleteBookByISBN() {
        Book b = searchBookByISBN();
        if (b != null) {
            deleteBook(b);
        }
    }

    static void deleteBookByName() {
        Book b = searchBookByTitel();
        if (b != null) {
            deleteBook(b);
        }
    }

    static void ShowBooksByKeyword() {
        System.out.printf("%s %5s\n", "Enter Seach Keyword",":");
        String keyword = System.console().readLine();
        // need to implements 
        //print list of books
    }
}
