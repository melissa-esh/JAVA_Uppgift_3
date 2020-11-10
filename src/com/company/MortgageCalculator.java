package com.company;

/**
 * MortgageCalculator är en klass som räknar ut:
 * - hur mycket användaren får max låna
 * - hur mycket användaren måste minst amortera
 * - hur mycket räntan blir
 * - den totala månadskostnaden
 */
public class MortgageCalculator {
    static int maxMortgage;
    static int interestPerMonth;
    static int amorteringPerMonth;

    /**
     * En metod som beräknar hur mycket använaren max
     * får låna av banken antingen baserad på användarens
     * inkomst eller kontantinstas
     */
    public static void calculateMaxMortgage() {
        int salary = Applicant.getSalary();
        int deposit = Applicant.getDeposit();
        double minDeposit = 0.15 * 5 * 12 * salary;

        if (deposit < minDeposit) {
            maxMortgage = (100 / 15) * deposit;
            System.out.println("Du får max låna = " + maxMortgage + " kr, p.g.a. för låg kontantinsats.");
        } else {
            maxMortgage = 5 * 12 * salary;
            System.out.println("Du får max låna = " + maxMortgage + " kr");
        }
        calculateAmortering();
    }

    /**
     * En metod som beräknar hur mycket använaren måste
     * amortera per månad
     */
    public static void calculateAmortering() {
        double priceOfHouse85Procent = 0.85 * maxMortgage;
        double amorteringPerYear = 0.02 * priceOfHouse85Procent;
        amorteringPerMonth = (int) (amorteringPerYear / 12);
        System.out.println("Amortering per månad = " + amorteringPerMonth + " kr/månad");
        calculateInterest();
    }

    /**
     * En metod som beräknar hur mycket använaren måste
     * betala i ränta varje månad
     */
    public static void calculateInterest() {
        double interestPerYear = maxMortgage * 0.0169;
        interestPerMonth = (int) (interestPerYear / 12);
        System.out.println("Räntekostnad per månad = " + interestPerMonth + " kr/månad");
        calculateTotalCostPerMonth();
    }

    /**
     * En metod som räknar ut den totala boendekostnaden per månad
     */
    public static void calculateTotalCostPerMonth() {
        int totalCostPerMonth = amorteringPerMonth + interestPerMonth;
        System.out.println("Totalkostnad per månad = " + totalCostPerMonth + " kr/månad");
    }

}
