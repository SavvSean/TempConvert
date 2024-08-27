import java.util.Objects;

public class TemperatureConverter{

    private double tempLevel, resetValue;
    private final double kelvin = 273.15;
    private String currentSymbol;
    private boolean condition = true;

    //Creator
    TemperatureConverter(){
        tempLevel = 0; // in Celsius
        currentSymbol = "°C ";
    }

    //Observers
    public double getTempLevel() {return tempLevel; }
    public String getSymbol(){return currentSymbol;}
    public boolean toContinue(){return condition;}

    //Transformers
    public void StartingString(){
        System.out.print("Set Temperature in Celsius: ");
    }

    public void setCelsius(double amount) {
        resetValue = amount; tempLevel = resetValue;
    }

    public void displayLevel(){
        System.out.println("Current Temperature Level: " + getSymbol() + getTempLevel());
    }

    public void toKelvin() {
        tempLevel += kelvin;
        currentSymbol = "K ";
    }

    public void toCelsius() {
        // if from Fahrenheit
        if (Objects.equals(currentSymbol, "°F ")) {
            tempLevel = (tempLevel - 32) * 5 / 9;
        }
        else {
            // if from Kelvin formula
            tempLevel -= kelvin;
        }
        currentSymbol = "°C ";
    }

    public void toFahrenheit(){
        tempLevel = (tempLevel * 9 / 5) + 32;
        currentSymbol = "°F ";
    }

    public void decision(int choice){
        if (choice == 1) {
            if (Objects.equals(currentSymbol, "°C "))
                toFahrenheit();
            else
                toCelsius();
        }
        else if (choice == 2){
            if (Objects.equals(currentSymbol, "K "))
               toFahrenheit();
            else
                toKelvin();
        }
        else {
            System.err.println("Choice Invalid, will not convert or process anything...");
        }
    }

    public void toResume(int choice){
        if (choice == 1) {
            System.err.println("Resuming...\n");
        }
        else if(choice == 2){
            System.err.println("Resetting Values...\n");
            toReset();

        }
        else {
            System.err.println("Exiting...");
            condition = false;
        }
    }

    public void Questions(){
        if (Objects.equals(currentSymbol, "°C ")) {
            System.out.print("Convert into? | [1] Fahrenheit [2] Kelvin | \nᯓ★ ");
        }
        else if (Objects.equals(currentSymbol, "°F ")){
            System.out.print("Convert into? | [1] Celsius [2] Kelvin | \nᯓ★ ");
        }
        else if (Objects.equals(currentSymbol, "K ")){
            System.out.print("Convert into? | [1] Celsius [2] Fahrenheit | \nᯓ★ ");
        }
    }

    public void converted(){
        System.out.println("\nResult: " + getSymbol() + getTempLevel());
    }

    public void optionToLeave(){
        System.out.print("still want to continue? [1], do you want to go back to first input? [2], any digit to exit.\nᯓ★ ");
    }

    public void toReset(){
        tempLevel = resetValue;
    }
}