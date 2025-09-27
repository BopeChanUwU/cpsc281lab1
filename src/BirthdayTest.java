/**
 * This file is part of a solution to
 * CPSC 281 Assignment 1 Question 1 Test, Fall 2025
 *
 * <p> Implements a BirthdayTest class demonstrating the Birthday class
 *
 * @author Tristen Sandhu
 * Student Number: 230165842
 * @version 1
 */

public class BirthdayTest {
    
    public static void main(String[] args) {

        int maxNumberOfPeople = 100;
        int numberOfPeople = 30;
        int numberOfTests = 1000;
        int totalMatches = 0;
        for(int q = 0; q<numberOfTests; q++) {
            int numMatches = 0;
            Birthday[] bdays = Birthday.generateRandomBirthdays(numberOfPeople);
            if(Birthday.birthdayParadox(bdays)) {
                numMatches++;
            }
            totalMatches += numMatches;
        }
        System.out.println("for " + numberOfPeople + " people");
        System.out.println("Total matches in " + numberOfTests + " tests: " + totalMatches);
        System.out.println("Average matches: " + (totalMatches/(float)numberOfTests) );
    }
}