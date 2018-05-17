package CleanCode.Functions;

import com.sun.tools.javac.util.List;

import java.util.Collections;

public class ComposeMethod {
    // have a code fragment that can be grouped together.
    public static class BeforeExtractMethod {
        String name;
        void printBanner(){
        }

        int getOutstanding(){
            return 0;
        }

        void printOwing() {
            printBanner();

            //print details
            System.out.println("name: " + name);
            System.out.println("amount: " + getOutstanding());
        }
    }

    public static class AfterExtractMethod {
        String name;
        void printBanner(){
        }

        int getOutstanding(){
            return 0;
        }

        void printOwing() {
            printBanner();
            printDetails(getOutstanding());
        }

        void printDetails(double outstanding) {
            System.out.println("name: " + name);
            System.out.println("amount: " + outstanding);
        }
    }

    // When a method body is more obvious than the method itself
    class PizzaDeliveryBefore {
        int numberOfLateDeliveries;

        int getRating() {
            return moreThanFiveLateDeliveries() ? 2 : 1;
        }

        boolean moreThanFiveLateDeliveries() {
            return numberOfLateDeliveries > 5;
        }
    }

    class PizzaDelivery {
        int numberOfLateDeliveries;

        int getRating() {
            return numberOfLateDeliveries > 5 ? 2 : 1;
        }
    }
}
