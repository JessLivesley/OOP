import java.util.ArrayList;

interface Playable{
    void play();
}

public abstract class Instrument {
    private String name;

    public Instrument(String name){
        this.name=name;
    }
    
    public abstract void tune();

}

class Guitar extends Instrument implements Playable{
    
    public Guitar(String name){
        super(name);
    }

    @Override
    public void tune() {
        System.out.println("Tuning the guitar...");
    }

    @Override
    public void play() {
        System.out.println("Playing the guitar...");
    }
}

class Piano extends Instrument implements Playable{

    public Piano(String name) {
        super(name);
        
    }

    @Override
    public void play() {
        System.out.println("Playing the piano...");
        
    }

    @Override
    public void tune() {
        System.out.println("Tuning the piano...");
    }
    
}

class Main {
    public static void main(String[] args) {
        ArrayList<Instrument> instruments = new ArrayList<>();
        Guitar g1 = new Guitar ("Gerald");
        Piano p1 = new Piano("Claire");

        instruments.add(g1);
        instruments.add(p1);

        for (Instrument inst : instruments) {
            inst.tune();
            if (inst instanceof Playable) {
                ((Playable) inst).play();
            }
        }
    }
}


