public class Book {
    private String title;
    private String author;

    public Book (String title, String author){
        this.title=title;
        this.author=author;
    }

    public void printInfo() {
        System.out.println("The Title of the book is: " + title);
        System.out.println("The Author of the book is: " + author);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Fourth Wing", "Rebecca Yaros");


        book1.printInfo();


    }

    
}
