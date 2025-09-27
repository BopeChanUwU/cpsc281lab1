/**
 * This file is part of a solution to
 * CPSC 281 Assignment 1 Question 1, Fall 2025
 *
 * <p> Implements a Birthday class that stores a person's name and birthday
 * <p> with methods for:
 * <p> getting the name
 * <p> getting the day
 * <p> getting the month
 * <p> checking if two birthdays are on the same day and month
 * <p> checking to see if there are any matching birthdays in an array (birthday paradox)
 * <p> checking if the birthday is legal
 * <p> generating an array of random birthdays
 * <p> printing the birthday as a string
 *
 * @author Tristen Sandhu
 * Student Number: 230165842
 * @version 1
 */

public class Birthday {

    private String name; // name of the person
    private int day; // day of the month
    private int month; // month of the year

    /**
     * 3-arg constructor that constructs a birthday object with the given name, day, and month
     * if the date is not legal, throws an IllegalArgumentException
     * @param name string name of person
     * @param d int day of month (1-31)
     * @param m int month of year (1-12)
     * @throws IllegalArgumentException if the date is not legal
     */
    public Birthday(String name, int d, int m) {
        if(isLegalDate(d, m)) {
            this.name = name;
            this.day = d;
            this.month = m;
        } else {
            throw new IllegalArgumentException("Illegal date: " + d + "/" + m);
        }
    }

    /**
     * 2-arg constructor that constructs a birthday object with the given day and month
     * the name is set to "No Name"
     * if the date is not legal, throws an IllegalArgumentException
     * @param d int day of month (1-31)
     * @param m int day of month (1-12)
     * @throws IllegalArgumentException if the date is not legal
     */
    public Birthday(int d, int m) {
        this("No Name", d, m);
    }

    /**
     * Check if the date is legal or not
     * a legal date is one that could exist on the calendar (including leap years)
     * @param d int day of month (1-31)
     * @param m int month of year (1-12)
     * @return returns true if the date is legal, false otherwise
     */
    private boolean isLegalDate(int d, int m) {
        return !(d < 1 || d > 31||m < 1 || m > 12||(m == 2 && d >= 29)||((m == 4 || m == 6 || m == 9 || m == 11) && d > 30));
    }

    /**
     * gets the name of the person
     * @return string name of person
     */
    public String getName() {
        return name;
    }

    /**
     * gets the day of the month
     * @return int day of month
     */
    public int getDay() {
        return day;
    }

    /**
     * gets the month as a string
     * @return string month of year
     */
    public String getMonth() {
        switch (month) {
            case 1 -> {
                return "January";
            }
            case 2 -> {
                return "February";
            }
            case 3 -> {
                return "March";
            }
            case 4 -> {
                return "April";
            }
            case 5 -> {
                return "May";
            }
            case 6 -> {
                return "June";
            }
            case 7 -> {
                return "July";
            }
            case 8 -> {
                return "August";
            }
            case 9 -> {
                return "September";
            }
            case 10 -> {
                return "October";
            }
            case 11 -> {
                return "November";
            }
            case 12 -> {
                return "December";
            }
            default -> throw new IllegalArgumentException();
        }
    }

    /**
     * checks to see if this birthday is the same day and month as another birthday
     * @param other Birthday object to compare to
     * @return true if the two birthdays are on the same day and month, false otherwise
     */
    public boolean isSameDay(Birthday other) {
        return this.day == other.day && this.month == other.month;
    }

    /**
     * checks to see if there are any two birthdays in the array that are on the same day and month
     * @param birthdays array of Birthday objects to check
     * @return true if there are any two birthdays in the array that are on the same day and month, false otherwise
     */
    public static boolean birthdayParadox(Birthday[] birthdays) {
        for(int i = 0; i<birthdays.length; i++) {
            for(int j = i+1; j<birthdays.length; j++) {
                if(birthdays[i].isSameDay(birthdays[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * generates an array of random birthdays
     * @param numBirthdays number of random birthdays to generate
     * @return array of random Birthday objects
     */
    public static Birthday[] generateRandomBirthdays(int numBirthdays) {
        Birthday[] bdays = new Birthday[numBirthdays];
        int i = 0;
        while(i<numBirthdays) {
            try {
                bdays[i] = new Birthday("Person" + i, (int) (Math.random() * (31 - 1 + 1)) + 1, (int) (Math.random() * (12 - 1 + 1)) + 1);
                i++;
            } catch (IllegalArgumentException e) {
                // do nothing, just try again
            }
        } 
        return bdays;
    }

    /**
     * returns a string representation of the birthday object
     * @return string representation of the birthday object
     */
    @Override
    public String toString() {
        return "Birthday [name = " + name + ", month = " + getMonth() + ", day = " + day + "]";
    }

}