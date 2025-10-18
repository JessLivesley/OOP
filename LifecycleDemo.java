public class LifecycleDemo {

    private static int totalObjects = 0;
    private int instanceID;

    public LifecycleDemo () {
        totalObjects++;
        this.instanceID = instanceID;
    }

    public void finalise(){
        System.out.println("Object " + instanceID + "is being garbage collected");
    }

    
    public String toString(){
      return "LifecycleDemo Instance ID: " + instanceID ;
    }

    public static void objectloop(int count){
        for (int i = 0; i < count; i++) {
            new LifecycleDemo();
        }
    }

    public static void main(String[] args) {    
        System.out.println("Starting Lifecycle Demo...");
        objectloop(10);
        
        System.out.println("Requesting garbage collection...");
        System.gc();

        


    }


}
