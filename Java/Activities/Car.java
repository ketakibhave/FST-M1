package activities1;

public class Car {
    public String color;
    public String transmission;
    public int make;
    public int tyres=4;
    public int doors=4;

    public Car(int make, String color, String transmission){
        this.make=make;
        this.color=color;
        this.transmission=transmission;
    }
    public void displayCharacteristics(){
        System.out.println("Color ="+this.color);
        System.out.println("Make ="+this.make);
        System.out.println("Doors ="+this.doors);
        System.out.println("Transmission ="+this.transmission);
    }
    public void accelerate(){
        System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }
}
