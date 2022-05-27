package activities1;

public class Activity1 {
    public static void main( String[] args ) {
        Car carName = new Car(2014, "Black", "Manual");
        carName.displayCharacteristics();
        carName.accelerate();
        carName.brake();
    }
}
