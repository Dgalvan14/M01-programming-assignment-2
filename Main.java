
/* Devlyn Galvan
 * SDEV200
 * 08/29/2024
 * M01 programming assignment 2
 * Create a program that verifies card numbers
 */
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        // Creating a scanner variable to retrieve user input
        Scanner userCardNumber = new Scanner(System.in);

        long cardNumber = 0;


        // getting card info from user.
        System.out.print("Enter Card Number : ");
        cardNumber = userCardNumber.nextLong();
        userCardNumber.close(); // closing scanner


        // this is printing out whether the card is valid and what card company it is from
        if (isValid(cardNumber) && prefixMatched(cardNumber)) {
            System.out.println("The Card number is valid.");
            System.out.println("Card Type: " + getCardType(cardNumber));
        } else {
            System.out.println("The card number is invalid.");
        }


    }

    // ensure totals from adding doubled even place and the sum of odd place is divisable by 10 using modulo to ensure this is accurate
    public static boolean isValid(long cardNumber) {

            int sum = sumOfDoubleEvenPlace(cardNumber) + sumOfOddPlace(cardNumber);
            
            boolean isValid;

            if (sum % 10 == 0){
                isValid = true;
            } else {
                isValid = false;
            }

            return isValid;
    
    }

    public static int sumOfDoubleEvenPlace(long cardNumber) {
        int sumOfEvenPlace = 0;
        boolean isEven = false; // using this to validate whether the digit is in the even place or odd place

        while (cardNumber > 0) {

            int digit = (int) (cardNumber % 10);
            cardNumber /= 10;

            if (isEven) {
                sumOfEvenPlace += getDigit(digit);
            }

            isEven = !isEven;
        }

        return sumOfEvenPlace;
    }
    

    // this function takes the number from the even place and doubles them then checks if the doubled number is double digits and adds the 1s and 2s place if it is.
    public static int getDigit(int digit) {
        int doubled = digit * 2;
        if (doubled > 9) {
            return doubled / 10 + doubled % 10; // sums digits from two digit doubles
        }
        return doubled;
    }
    
    // this adds the sums of the numbers in the odd place of the card number no doubling is required so we can just get the sum of these numbers
    public static int sumOfOddPlace(long cardNumber) {
        int sumOfOdd = 0;
        boolean isOdd = true;
    
        while (cardNumber > 0) {

            int digit = (int) (cardNumber % 10);
            cardNumber /= 10;
    
            if (isOdd) {
                sumOfOdd += digit;
            }
            isOdd = !isOdd;
    
        }

        return sumOfOdd;     
    }

    // this gets the prefix from the beginning of the card number and matches that with the card company
    public static boolean prefixMatched(long cardNumber) {
        int prefix = (int) getPrefix(cardNumber, 2); // Use a single digit for matching
        return (prefix / 10 == 4 || prefix / 10 == 5 || prefix == 37 || prefix / 10 == 6); // I use a division of 10 to take into account the second digit that is gathered from getPrefix
    }
    
    // this gets the size of the card number it would be possible to expand on this to ensure the card number is either 13 or 16 based on the project description
    public static int getSize(long cardNumber) {
        int size = 0;
        while (cardNumber > 0) {
            cardNumber /= 10;
            size++;
        }
        return size;
    }

    // this gets the prefix of the card number by taking numbers off until size is the same as k
    public static long getPrefix(long cardNumber, int k) {
        int size = getSize(cardNumber);
        while (size > k) {
            cardNumber /= 10;
            size--;
        }
        return cardNumber;
    }
    

    // matching prefix match to the specific card company to ensure it is a valid card and returning a string based off the card
    public static String getCardType(long cardNumber) {
        int prefix = (int) getPrefix(cardNumber, 2);
        if (prefix == 37) {
            return "American Express Card";
        } else if (prefix / 10 == 4) {
            return "Visa";
        } else if (prefix / 10 == 5) {
            return "Master Card";
        } else if (prefix / 10 == 6) {
            return "Discover Cards";
        } else {

            return "Unknown Card";
        }
    }
    



}
