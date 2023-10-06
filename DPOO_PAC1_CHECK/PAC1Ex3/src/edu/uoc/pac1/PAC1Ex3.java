package edu.uoc.pac1;

public class PAC1Ex3 {

    static double[] dailyServiceCharges = {4.52, 5.05, 4.84, 5.27, 4.78, 5.39, 4.99};

    static double[][] unitRatesPerDay = {
            {0.234, 0.456, 0.789, 0.101, 0.123, 0.567, 0.890},
            {0.234, 0.567, 0.890, 0.112, 0.345, 0.678, 0.901},
            {0.345, 0.678, 0.901, 0.223, 0.456, 0.789, 0.012},
            {0.456, 0.789, 0.012, 0.334, 0.567, 0.890, 0.123},
    };

    public static double twoDecimals(double number) {
        return Math.round(number * 100d) / 100d;
    }

    public static double calculateTieredPricing(int units) {
        double cost = 0.0; // Inicialitzem la variable doble cost

        if (units <= 300) { // Si el número és inferior a  300
            cost = units * 0.04; // Multiplica pel valor
        } else if (units <= 600) { // Si es inferior a 600
            cost = 300 * 0.04 + (units - 300) * 0.06; // Calcula les primeres 300 i la diferencia
        } else { // Si es superior
            cost = 300 * 0.04 + 300 * 0.06 + (units - 600) * 0.014; // Fa el càlcul per trams i el restant
        }

        return twoDecimals(cost); // Retornem amb dos decimals.
    }

    public static double calculateDiscount(int daysUnderFiftyUnits, double totalBill) {
        double discount = 0.0; // Inicialitzem la variable discount

        if (daysUnderFiftyUnits > 10) { // Si el nombre de dies es inferior a 10
            discount = 0.20 * totalBill; // 20% de descompte
        } else if (daysUnderFiftyUnits > 5) { // Si el nombre de dies es inferior a 5
            discount = 0.10 * totalBill; // 10% de descompte
        }

        return twoDecimals(discount); // Retornem amb dos decimals
    }

    public static double calculateAdditionalCharges(int units) {
        double additionalCharges = 0.0;

        if (units > 300) {
            additionalCharges = units * 0.02;
        }
        return twoDecimals(additionalCharges);
    }


    public static double calculateTotalBill(int[][] unitsPerMonth) {
        double totalBill = 0.0; // Inicializa el costo total a 0

        for (int week = 0; week < unitsPerMonth.length; week++) { // Cicle for per a obtenir la posició de la setmana
            for (int day = 0; day < unitsPerMonth[week].length; day++) { // Cicle for per a obternir la posició el dia

                int units = unitsPerMonth[week][day]; // Recuperem el valor de la matriu pel dia corresponent
                double unitRate = unitRatesPerDay[week][day]; // Obtenim la tarifa per aquest dia

                // Calculem el cost a partir de la fórmula
                double costDia = (units * unitRate) + calculateTieredPricing(units) +
                        calculateAdditionalCharges(units) + dailyServiceCharges[day];

                totalBill += costDia; // Sumem el cost del dia al total

            }
        }

        return twoDecimals(totalBill); // Retornem el cost total amb dos decimals
    }


}
