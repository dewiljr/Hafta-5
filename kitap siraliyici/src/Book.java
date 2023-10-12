class Book implements Comparable<Book> {
    private String bookName;
    private int pageCount;
    private String authorName;
    private String publicationDate;

    public Book(String bookName, int pageCount, String authorName, String publicationDate) {
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int compareTo(Book otherBook) {
        return this.bookName.compareTo(otherBook.getBookName());
    }

    public String toString() {
        return "Book [Name=" + bookName + ", PageCount=" + pageCount + ", Author=" + authorName + ", PublicationDate=" + publicationDate + "]";
    }
}