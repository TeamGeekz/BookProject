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

/**
 *
 * @author orangehrm
 */
public class Book implements Comparable<Book>{
    public final static int TITLE_LENGTH =25;
    
    private String title;
    private String authorName ;
    private String authorSurname;
    private int ISBN;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        if (title.length()>Book.TITLE_LENGTH) {
            title =title.substring(0,Book.TITLE_LENGTH);
        }
        this.title = title;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the authorSurname
     */
    public String getAuthorSurname() {
        return authorSurname;
    }

    /**
     * @param authorSurname the authorSurname to set
     */
    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    /**
     * @return the ISBN
     */
    public int getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public int compareTo(Book t) {
        return this.getTitle().compareToIgnoreCase(t.getTitle());
    }

    @Override
    public String toString() {
       return this.getTitle() +"("+getISBN()+")"+ " by " + this.getAuthorName()+" "+this.getAuthorSurname();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return this.getTitle().equalsIgnoreCase(book.getTitle()) && this.getISBN() == book.getISBN();
        }else{
            return false;
        }
    }

    
}
