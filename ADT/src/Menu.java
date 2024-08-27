import java.util.Scanner;
public class Menu {

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        TemperatureConverter temp = new TemperatureConverter();

        temp.StartingString();
        double set = scan.nextDouble(); temp.setCelsius(set);

        while (temp.toContinue()) {
            temp.displayLevel();
            temp.Questions();
            int choice = scan.nextInt(); temp.decision(choice);
            temp.converted();
            temp.optionToLeave();
            int resume = scan.nextInt(); temp.toResume(resume);
        }
    }
}
