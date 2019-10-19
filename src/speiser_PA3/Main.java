package speiser_PA3;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    private static int generateQuestion (int userDifficulty, int userArithmetic) {

        Scanner userInput = new Scanner (System.in);
        SecureRandom random = new SecureRandom();

        int number1 = 0, number2 = 0, solution = 0;

        number1 = Math.abs(random.nextInt(10) * userDifficulty);
        number2 = Math.abs(random.nextInt(10) * userDifficulty);

        if (userArithmetic == 5) {

            userArithmetic = (Math.abs(random.nextInt(4) + 1));
        }

        if (userArithmetic == 1) {

            solution = number1 + number2;

            System.out.printf("How much is %d + %d?\n", number1, number2);
        }

        else if (userArithmetic == 2) {

            solution = number1 - number2;

            while (solution == -1) {

                number1 = Math.abs(random.nextInt(10) * userDifficulty);

                number2 = Math.abs(random.nextInt(10) * userDifficulty);

                solution = number1 - number2;
            }

            System.out.printf("How much is %d - %d?\n", number1, number2);
        }

        else if (userArithmetic == 3) {

            solution = number1 * number2;

            System.out.printf("How much is %d * %d?\n", number1, number2);

        }

        else if (userArithmetic == 4) {
            if  (number2 > 0) {
                number2 = Math.abs(random.nextInt(10) * userDifficulty) + 1;
            }
            solution = (number1 / number2);
            System.out.printf("How much is %d / %d?\n", number1, number2);
        }

        return solution;
    }



    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        String [] good = {"Very good!", "Excellent!", "Nice Work!", "Keep up the good work!"};
        String [] gitGud = {"No. Please try again.", "Wrong. Try once more!", "Don't give up!", "No. Keep trying.", "Noob."};
        int realAnswer = 0, userAnswer = 0, difficultySetting = 0, arithmeticType = 1;

        do {
            System.out.println("Please choose the difficulty setting: 1-4");
            difficultySetting = userInput.nextInt();

            System.out.println("Enter which operation you would like to practice: ");

            System.out.println("1 = Addition");
            System.out.println("2 = Subtraction");
            System.out.println("3 = Multiplication");
            System.out.println("4 = Division");
            System.out.println("5 = Mixed ");

            arithmeticType = userInput.nextInt();

            realAnswer = generateQuestion(difficultySetting, arithmeticType);

            System.out.print("Please enter you answer: (-1 to exit)");
            userAnswer = userInput.nextInt();


            while (userAnswer != -1) {
                double numRight = 0, numWrong = 0;

                while ((numRight + numWrong) < 10) {

                    while (userAnswer != realAnswer) {
                        numWrong++;
                        if ((numRight + numWrong) == 10)
                            break;

                        if (userAnswer != -1) {
                            System.out.printf("%s\n", gitGud[Math.abs(random.nextInt() % 4)]);

                            System.out.print("Enter your answer (-1 to exit): ");
                            userAnswer = userInput.nextInt();
                        } else if (userAnswer == -1)
                            break;
                    }

                    if (userAnswer == realAnswer) {
                        numRight++;
                        System.out.printf("%s\n\n", good[Math.abs(random.nextInt() % 4)]);

                        if ((numRight + numWrong) != 10) {

                            realAnswer = generateQuestion(difficultySetting, arithmeticType);

                            System.out.print("Enter your answer (-1 to exit): ");
                            userAnswer = userInput.nextInt();
                        }
                    }
                }
                if (userAnswer != -1) {
                    if ((numRight / 10) >= .75) {
                        System.out.print("Congratulations, you are ready to go to the next level!\n\n");
                        System.out.printf("You scored %.0f%%\n", ((numRight / 10) * 100));
                    } else {
                        System.out.printf("You scored %.0f%%\n", ((numRight / 10) * 100));
                        System.out.print("Please ask your teacher for extra help.\n\n");
                    }
                    break;

                    //realAnswer = generateQuestion(difficultySetting, arithmeticType);

                    //System.out.print("Enter your answer (-1 to exit): ");
                   // userAnswer = userInput.nextInt();
                }
            }

        }while (userAnswer != -2);
            System.out.println();
    }
}
