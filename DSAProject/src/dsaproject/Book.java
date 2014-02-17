package dsaproject;

public class Book implements Comparable<Book> {

    public final static int TITLE_LENGTH = 25;

    private String title;
    private String authorName;
    private String authorSurname;
    private int ISBN;

    /**
     *
     * Default
     *
     */
    public Book() {
    }

    /**
     *
     * Create a Book Instance
     *
     * @param title
     * @param authorName
     * @param authorSurname
     * @param ISBN
     */
    public Book(String title, String authorName, String authorSurname, int ISBN) {
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.ISBN = ISBN;
    }

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
        if (title.length() > Book.TITLE_LENGTH) {
            title = title.substring(0, Book.TITLE_LENGTH);
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
        return this.getTitle() + "(" + getISBN() + ")" + " by " + this.getAuthorName() + " " + this.getAuthorSurname();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return this.getTitle().equalsIgnoreCase(book.getTitle()) ;
        } else {
            return false;
        }
    }

}
