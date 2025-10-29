public class mock {
    private String title;
    private String author;
    private int pages;

    public mock (String title, String author, int pages){
        this.title=title;
        this.author=author;
        this.pages=pages;
    }

    public void readPages(int pagesRead){
        pages = pages - pagesRead;
        System.out.println("You read " + pagesRead + " pages. " + pages + " pages left. \n");
    }

    public void printDetails(){
        System.out.println("Title: " + title + ", Author: " + author +", Pages left: " + pages + "\n");
    }

    public int getPages(){
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0 ){
            this.pages=pages;
        } else {
            System.out.println("Invalid page numenbr. Must be positive.");
        }
    }

    public static void main(String[] args) {
        mock book1 = new mock ("Fourth Wing", "Rebecca Yaros", 720);
        mock book2 = new mock ("Iron Flame", "Rebecca Yaros", 740);

        book1.setPages(500);
        //book1.setPages(-10);

        System.out.println(book1.getPages());
        
        book1.printDetails();
        book2.printDetails();

        book1.readPages(373);

        book1.printDetails();

    }

}

