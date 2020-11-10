package com.company;

import javax.swing.*;

/**
 * Applicant är en klass som tar in användarens lön,
 * kontantinsats och föreningsavgift via dialogrutor.
 */
public class Applicant {
    static int fee;

    /**
     * En metod som ber användaren mata in sin
     * månadslön via en dialogruta
     *
     * @return användarens månadslön
     */
    public static int getSalary() {
        String userInput;
        userInput = JOptionPane.showInputDialog("Måndasinkomst före skatt?");
        int salary = Integer.parseInt(userInput);
        return salary;
    }

    /**
     * En metod som ber användaren mata in sin
     * kontansinsats via en dialogruta
     *
     * @return kontantinsatsen
     */
    public static int getDeposit() {
        String userInput;
        userInput = JOptionPane.showInputDialog("Hur mycket vill du lägga i kontantinsats?");
        int deposit = Integer.parseInt(userInput);
        getFee();
        return deposit;
    }

    /**
     * En metod som ber användaren mata in hur mycket avgift de kan
     * tänka sig betala till föreningen via en dialogruta
     */
    public static void getFee() {
        String userInput;
        userInput = JOptionPane.showInputDialog("Hur mycket är du villig att betala i avgift till föreningen?");
        fee = Integer.parseInt(userInput);
    }

}
