import com.personal.calculator.FractionCalculator;
import com.personal.calculator.impl.FractionCalculatorImpl;


public class MainClass {

    private final static int OPERAND_1 = 0;
    private final static int OPERATOR = 1;
    private final static int OPERAND_2 = 2;

    public static void main(String args[]) {
        if (args.length != 3) {
            printUsage();
            System.exit(0);
        }
        try {
            FractionCalculator fractionCalculator = new FractionCalculatorImpl();
            System.out.println(fractionCalculator.calculate(args[OPERAND_1], args[OPERATOR], args[OPERAND_2]));
        } catch (IllegalArgumentException e) {
            System.out.println ("The input fraction or operator is not in correct format. Please provide input in proper format.");
            printUsage();
        } catch (ArithmeticException e) {
            System.out.println("The operation resulted in calculation out of range for 4 bye Integer.");
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Please provide in the format of '{operand1} {operator} {operand2}");
        System.out.println("where operand 1 and 2 are fraction and operator is one of *, /, +, - ");
        System.out.println("Operand can be a whole number, improper or proper fraction only. ");
        System.out.println("Example x or x/y or x_y/z");
    }
}
