/*
 * OrangeHRM Enterprise is a closed sourced comprehensive Human Resource Management (HRM) 
 * System that captures all the essential functionalities required for any enterprise. 
 * Copyright (C) 2006 OrangeHRM Inc., http://www.orangehrm.com 
 * 
 * OrangeHRM Inc is the owner of the patent, copyright, trade secrets, trademarks and any 
 * other intellectual property rights which subsist in the Licensed Materials. OrangeHRM Inc 
 * is the owner of the media / downloaded OrangeHRM Enterprise software files on which the 
 * Licensed Materials are received. Title to the Licensed Materials and media shall remain 
 * vested in OrangeHRM Inc. For the avoidance of doubt title and all intellectual property 
 * rights to any design, new software, new protocol, new interface, enhancement, update, 
 * derivative works, revised screen text or any other items that OrangeHRM Inc creates for 
 * Customer shall remain vested in OrangeHRM Inc. Any rights not expressly granted herein are 
 * reserved to OrangeHRM Inc. 
 * 
 * Please refer http://www.orangehrm.com/Files/OrangeHRM_Commercial_License.pdf for the license which includes terms and conditions on using this software. 
 *  
 */

package dsaproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orangehrm
 */
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthorSurname method, of class Book.
     */
    @Test
    public void testGetAuthorSurname() {
        System.out.println("getAuthorSurname");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getAuthorSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Book.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Book t = null;
        Book instance = new Book();
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Book instance = new Book();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
