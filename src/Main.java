import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input expression: ");
        try {
            System.out.println(calc(in.nextLine()));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }

    public static String calc(String input) {
        ProcessingExpression processingExpression = new ProcessingExpression(input);
        return processingExpression.Calculate();
    }
}