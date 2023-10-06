import java.util.Scanner;

public class PAC1Ex1 {

    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        number = scanner.nextInt(); // assigns the variable "number" the integer entered by keyboard

        if (number < 0) {
            System.out.println("[ERROR]: The given number is not positive");
        } else {
            pentagonalNumbers(number);
        }
    }

    private static void pentagonalNumbers(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(getPentagonalNumber(i + 1) + ", "); // prints the 'i' value of the pentagonal succession
        }
    }

    public static int getPentagonalNumber(int i) {
        return (i * (3 * i - 1) / 2);
    }
}
