abstract class LibraryItem{
    private String title;
    private int year;

    public LibraryItem(String title, int year){
        this.title=title;
        this.year=year;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year=year;
    }

    public void displayInfo(){
        System.out.println("Title: " + title + ".\nYear: " +year);
    }

    public abstract void borrowMessage();

}

class Book extends LibraryItem{

    private String author;

    public Book(String title, int year, String author){
        super(title, year);
        this.author=author;
     }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    @Override
    public void borrowMessage(){
        System.out.println("You borrowed a book by " +author);
    }

    

}

class DVD extends LibraryItem{
    private int duration;

    public DVD(String title, int year, int duration){
        super(title, year);
        this.duration=duration;
    }

    public int getDuration(){
        return duration;
    }

    public void setDuration(int duration){
        this.duration=duration;
    }

    @Override
    public void borrowMessage(){
        System.out.println("You borrowed a DVD lasting " +duration+ " days.");
    }

}

class Main{


    public static void main(String[] args) {
        Book book1 = new Book("Fourth Wing", 2021, "Rebecca Yaros");
        DVD dvd1 = new DVD ("Interstellar",2012,6);

        book1.displayInfo();
        book1.borrowMessage();


        dvd1.displayInfo();
        dvd1.borrowMessage();

    }

}
