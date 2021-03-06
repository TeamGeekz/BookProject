package dsaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Isuru
 */
public class DSAProject {

    static BinarySearchTree bst;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("BookList.txt");
            if (file.exists()) {
            } else {
                PrintWriter writer = new PrintWriter("BookList.txt", "UTF-8"); // Create a File Name Called BookList.txt
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
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
        System.out.println("3) Search Book by Title ");
        System.out.println("4) Search Book by ISBN ");
        System.out.println("5) Delete Book by Title");
        System.out.println("6) Delete Book by ISBN ");
        System.out.println("7) Show Books By Keyword ");
        System.out.println("0) Exit ");
        System.out.println("");
        System.out.print("User Input :");
        int input = 0;
        try {

            Scanner sc = new Scanner(System.in); // Change 
            input = sc.nextInt();               // Change

            //input = Integer.parseInt(System.console().readLine());
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
        printHeadder();
        bst.inOrder(bst.root);
        System.out.println("\n");
    }

    static void populateTree() {
        //Read books from file 
//        Book book1 = new Book("aaa", "xys", "ss", 1);
//        Book book2 = new Book("abc", "xys", "ss", 2);
//        
//
//        bst.insert(book2);
//        bst.insert(book1);
//       

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("BookList.txt")))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(","); // you split the array with Comma
                bst.insert(new Book(array[0], array[1], array[2], Integer.parseInt(array[3]))); // you add to the list ,you have to create a constructor string string String or cast for proper type.               
            }

        } catch (IOException ex) {
            printMenu();
        } catch (Exception e) {

            printMenu();
        }

    }

    static void enterNewBook(String bookName) {
        if (bookName == null) {
            System.out.printf("%s %5s", "Enter Book Name", ":");

            Scanner sc = new Scanner(System.in); // Change 
            bookName = sc.nextLine(); //change
            //bookName = System.console().readLine();
        }

        System.out.printf("%s %5s", "Enter ISBN", ":");
        int ISBN = 0;
        try {
            Scanner sc = new Scanner(System.in); // Change 
            ISBN = sc.nextInt(); //change
            //ISBN = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException e) {
            enterNewBook(bookName);
        }

        System.out.printf("%s %5s", "Enter Author First Name", ":");
        Scanner sc = new Scanner(System.in); // Change 
        String fName = sc.nextLine(); //change
        //String fName = System.console().readLine();
        System.out.printf("%s %5s", "Enter Author Last Name", ":");
        sc = new Scanner(System.in); // Change 
        String lName = sc.nextLine(); //change
        //String lName = System.console().readLine();

        Book newBook = new Book(bookName, fName, lName, ISBN);
        bst.insert(newBook);

        System.out.println(" Book " + bookName + "  Added to The file Book List");
        writeBooKToFile(newBook);
    }

    static Book searchBookByTitel() {
        System.out.printf("%s %5s", "Enter Book Name", ":");
        Scanner sc = new Scanner(System.in); // Change 
        String bookName = sc.nextLine(); //change
        //String bookName = System.console().readLine();
        Book findBook = new Book();
        findBook.setTitle(bookName);
        Book found = bst.find(findBook);
        if (found != null) {
            printHeadder();
            System.out.println(found);
        } else {
            System.out.println("No Book found !");
        }
        return found;
    }

    static Book searchBookByISBN() {
        System.out.printf("%s %5s", "Enter ISBN", ":");
        int ISBN = 0;
        try {
            //ISBN = Integer.parseInt(System.console().readLine());
            Scanner sc = new Scanner(System.in); // Change 
            ISBN = Integer.parseInt(sc.nextLine()); //change
        } catch (NumberFormatException e) {
            searchBookByISBN();
        }
        Book found = bst.getBookByISBN(ISBN);
        if (found != null) {
            printHeadder();
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
        System.out.printf("%s %5s", "Enter Search Keyword", ":");
        String keyword = System.console().readLine();
        TreeSet<Book> ar = bst.getBookList(keyword);
        if (ar.size() > 0) {
            System.out.println(ar.size() + " matches found");
            printHeadder();
            for (Book book : ar) {
                System.out.println(book);
            }
            System.out.println("\n");
        } else {
            System.out.println("No any matches found !");
        }

        // need to implements 
        //print list of books
    }

    static void printHeadder() {
        String formated = String.format("%-50s %-10s     %s", new String(new char[50]).replace("\0", "="), new String(new char[10]).replace("\0", "="), new String(new char[20]).replace("\0", "="));
        System.out.println(formated);
        System.out.println(String.format("%-50s %-10s     %s", "   Title   ", "  ISBN  ", "  Author  "));
        System.out.println(formated);
    }

    private static void writeBooKToFile(Book newBook) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("BookList.txt", true)))) {
            String line = null;
            writer.append(newBook.getTitle()
                    + "," + newBook.getAuthorName()
                    + "," + newBook.getAuthorSurname()
                    + "," + newBook.getISBN() + ",");
            writer.newLine();
            writer.flush();

        } catch (IOException ex) {
            System.out.println("File Not Found");
            printMenu();
        } catch (Exception e) {

            printMenu();
        }

    }

}
