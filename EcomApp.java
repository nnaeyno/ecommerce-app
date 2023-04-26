import java.util.Scanner;

public class EcomApp {
    public static void main(String[] args) {
        Data data = new Data();
        while(true) {
            Scanner input = new Scanner(System.in);

            System.out.print("* ");
            String command = input.nextLine();
            parseCommand(command);
        }
    }

    private static void parseCommand(String command) {

    }

}
