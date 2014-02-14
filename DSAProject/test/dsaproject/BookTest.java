
package dsaproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book();
        String expResult = "New Title";
        instance.setTitle(expResult);
        String result = instance.getTitle();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = new Book();
        instance.setTitle(title);
         
    }

    /**
     * Test of getAuthorName method, of class Book.
     */
    @Test
    public void testGetAuthorName() {
        System.out.println("getAuthorName");
        Book instance = new Book();
        String expResult = "AuthorName";
        instance.setAuthorName(expResult);
        String result = instance.getAuthorName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAuthorName method, of class Book.
     */
    @Test
    public void testSetAuthorName() {
        System.out.println("setAuthorName");
        String authorName = "";
        Book instance = new Book();
        instance.setAuthorName(authorName);
         
    }

    /**
     * Test of getAuthorSurname method, of class Book.
     */
    @Test
    public void testGetAuthorSurname() {
        System.out.println("getAuthorSurname");
        Book instance = new Book();
        String expResult = "AuthorSurname";
        instance.setAuthorSurname(expResult);
        String result = instance.getAuthorSurname();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of setAuthorSurname method, of class Book.
     */
    @Test
    public void testSetAuthorSurname() {
        System.out.println("setAuthorSurname");
        String authorSurname = "";
        Book instance = new Book();
        instance.setAuthorSurname(authorSurname);
         
    }

    /**
     * Test of getISBN method, of class Book.
     */
    @Test
    public void testGetISBN() {
        System.out.println("getISBN");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.getISBN();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of setISBN method, of class Book.
     */
    @Test
    public void testSetISBN() {
        System.out.println("setISBN");
        int ISBN = 0;
        Book instance = new Book();
        instance.setISBN(ISBN);
         
    }

    /**
     * Test of compareTo method, of class Book.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Book t = new Book();
        t.setTitle("hello");
        Book instance = new Book();
        instance.setTitle("heLLo");
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Book instance = new Book();
        instance.setTitle("a");
        instance.setISBN(1);
        instance.setAuthorName("b");
        instance.setAuthorSurname("c");
         
        String expResult = "a(1) by b c";
        String result = instance.toString();
        assertEquals(expResult, result);
         
    }

    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
        
    }
    
}
