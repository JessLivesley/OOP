public class Counter {
     
    private int count;

    public Counter () {
        this.count = 0;
    }

    public void increment(){
        count = count + 1;
    }

    public int getCount(){
        return count;
    }

    public void reset() {
        count = 0;
    }

public static void main(String[] args) {
    Counter counter1 = new Counter();

    Counter counter2 = counter1;  // Both point to same object

    counter1.increment();
    counter2.increment();

    System.out.println("Counter1 count: " + counter1.getCount());
    System.out.println("Counter2 count: "  + counter2.getCount());

    counter2.increment();
    System.out.println("After incrementing counter2: ");
    System.out.println("Counter1 count: " + counter1.getCount());
    System.out.println("Counter2 count : " +  counter2.getCount());

    counter1.reset();
    System.out.println("After incrementing counter1: ");
    System.out.println("Counter1 counf : " + counter1.getCount());
    System.out.println("Counter2 count : " + counter2.getCount());

    counter1 = null;

    System.out.println("Counter2 still works: " + counter2.getCount());




}

}
