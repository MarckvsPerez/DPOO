import java.util.Scanner;

public class PAC1Ex1 {

    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        number = scanner.nextInt(); //Assignem a la variable "number" el valor introduit per teclat

        if (number < 0) { // Si es menor a 0
            System.out.println("[ERROR]: The given number is not positive");
        } else { // Sino
            pentagonalNumbers(number); // Cridem la funció pentagonalNumbers pasant com a paramtre "number"
        }
    }

    private static void pentagonalNumbers(int n) {
        for (int i = 0; i < n; i++) { // Fem un cicle for mentre que el index sigui menor que el parametre
            System.out.print(getPentagonalNumber(i + 1) + ", "); // Mostra el valor de la posicio "i" en la successió pentagonal
        }
    }

    public static int getPentagonalNumber(int i) {
        return (i * (3 * i - 1) / 2);
    } // Càlcul successió pentagonal
}
