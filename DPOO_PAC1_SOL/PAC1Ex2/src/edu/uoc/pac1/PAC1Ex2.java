package edu.uoc.pac1;

public class PAC1Ex2 {

    public static int divsSum(int num) {
        int suma = 0; // Inicialitzem la variable suma

        for (int i = 1; i <= num / 2; i++) { //  Iterem desde 1 fins la mitad de 'num' (inclós)
            if (num % i == 0) { // Si 'num' es divisible por 'i' sense residu
                suma += i; // Sumem "i" a la variable suma
            }
        }

        if (suma <= 0) { // Si la suma és 0 ó negativa
            suma = -1; // Assignem valor de -1
        }

        return suma; // Retornem la variable suma
    }

    public static boolean isAbundant(int number) {
        int suma = divsSum(number); // Cridem al mètode divSum per obtenir la suma dels divisors

        return suma > number; // Retornem la comparació de suma amb number
    }


    public static boolean isPerfect(int number) {
        int suma = divsSum(number); // Cridem al mètode divSum per obtenir la suma dels divisors

        return suma == number; // Retornem la comparació de suma amb number
    }


    public static boolean isDeficient(int number) {
        int suma = divsSum(number); // Cridem al mètode divSum per obtenir la suma dels divisors

        return suma < number; // Retornem la comparació de suma amb number
    }


    public static void categorize(int[] numbers) {
        int perfectCount = 0, abundantCount = 0, deficientCount = 0; // Inicialitzem les variables de comptadors

        for (int num : numbers) { // Iterem per cada nombre del vector
            int sumaDivsNum = divsSum(num); // Calculem la suma dels divisors de cada nombre

            if (sumaDivsNum > num) { // Si es major
                abundantCount ++; // Incrementem abundantCount en 1
            } else if (sumaDivsNum < num) { // Si es menor
                deficientCount ++; // Incrementem deficientCount en 1
            } else if (sumaDivsNum == num) { // Si es igual
                perfectCount ++ ; // Incrementem perfectCount en 1
            }
        }

        // Mostrem les linies en pantalla
        System.out.println("There are: " + perfectCount + " perfect numbers.");
        System.out.println("There are: " + abundantCount + " abundant numbers.");
        System.out.println("There are: " + deficientCount + " deficient numbers.");
    }

}