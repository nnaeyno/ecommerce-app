import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Data data = new Data();
    public static void main(String[] args) {
        while(true) {
            Scanner input = new Scanner(System.in);

            System.out.print("* ");

            String command = input.nextLine();
            if(!parseCommand(command))
                break;

        }
    }

    private static boolean parseCommand(String command) {
        StringTokenizer tokenizer = new StringTokenizer(command, " ");
        if (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(Constants.SAVE)) {
                data.saveProduct(tokenizer.nextToken(), tokenizer.nextToken(),
                        Double.parseDouble(tokenizer.nextToken()));
            }
            else if (token.equals(Constants.PURCHASE)) {
                data.purchaseProduct(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()),
                        Double.parseDouble(tokenizer.nextToken()));
            }
            else if (token.equals(Constants.AVERAGE)) {
                System.out.println((data.getAverage(tokenizer.nextToken())));
            }
            else if (token.equals(Constants.FEWEST)) {
                System.out.println(data.getFewest());
            }
            else if (token.equals(Constants.ORDER)) {
                data.orderProduct(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
            }
            else if (token.equals(Constants.POPULAR)) {
                System.out.println(data.getMostPopular());
            }
            else if (token.equals(Constants.PROFIT)) {
                System.out.println(data.getProfit(tokenizer.nextToken()));
            }
            else if (token.equals(Constants.QUANTITY)) {
                System.out.println(data.getQuantity(tokenizer.nextToken()));
            }
            else if (token.equals(Constants.EXIT)) {
                return false;
            } else throw new RuntimeException(Constants.PARSE_ERROR);
        }
        return true;
    }

}
