package Hamurabi;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hamurabi {
        private Integer people = 100;
        private Integer grain = 2800;
        private Integer landAcres = 1000;
        private Integer bushelsPerAcreValue = 19;
        private boolean gameOver = false;

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        public Hamurabi() {
        }

        public static void main(String[] args) {
                new Hamurabi().playGame();

        }

        void playGame() {
                while (!gameOver) {

                }


        // declare local variables here: grain, population, etc.
            // statements go after the declations
        }

        public void startGameMessage() {
                System.out.println("O great Hammurabi!\n" +
                        "You are in year 1 of your ten year rule.\n" +
                        "In the previous year 0 people starved to death.\n" +
                        "In the previous year 5 people entered the kingdom.\n" +
                        "The population is now 100.\n" +
                        "We harvested 3000 bushels at 3 bushels per acre.\n" +
                        "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                        "The city owns 1000 acres of land.\n" +
                        "Land is currently worth 19 bushels per acre.\n");
        }



        public Integer askHowManyAcresToBuy(Integer bushelsPerAcreValue, Integer grain) {
                boolean skipQuestion = true;
                Integer answer = 0;
                do {
                    System.out.println("How many acres would you like to buy?\n");
                    try {
                            answer = scanner.nextInt();
                            if ((grain / bushelsPerAcreValue) > answer) {
                                    return answer;
                            } else {
                                    System.out.println("O Great Hamurabi, surely you jest!\nYou must have enough grain to pay for this land.");
                            }
                    } catch (InputMismatchException e) {
                            System.out.println("Try again!");
                            scanner.nextLine();
                            skipQuestion = false;
                    }

                } while (!skipQuestion);
                        System.out.println("No land? Your citizens will be very unhappy with you Great Hamurabi.");
                        return answer;
        }
        public Integer askHowManyAcresToSell(Integer landAcres) {
                boolean skipQuestion = true;
                Integer answer = 0;
                do {
                        System.out.println("How many acres would you like to sell?\n");
                        try {
                                answer = scanner.nextInt();
                                if (landAcres > answer) {
                                        return answer;
                                } else {
                                        System.out.println("O Great Hamurabi, surely you jest!\nYou must can't sell more land than you already have.");
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Try again!");
                                scanner.nextLine();
                                skipQuestion = false;
                        }

                } while (!skipQuestion);
                return null;
        }

        public Integer askHowMuchGrainToFeedPeople(Integer grain) {
                boolean skipQuestion = true;
                Integer answer = 0;
                do {
                        System.out.println("How many bushels of grain would you like to feed your citizens?\n");
                        try {
                                answer = scanner.nextInt();
                                if (grain > answer) {
                                        return answer;
                                } else {
                                        System.out.println("O Great Hamurabi, surely you jest!\nYou can't feed people more grain than you have.");
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Try again!");
                                scanner.nextLine();
                                skipQuestion = false;
                        }

                } while (!skipQuestion);
                return null;
        }

        public Integer askHowManyAcresToPlant(Integer landAcres) {
                boolean skipQuestion = true;
                Integer answer = 0;
                do {
                        System.out.println("How many acres will you plant?\n");
                        try {
                                answer = scanner.nextInt();
                                if (landAcres > answer) {
                                    if (people * 20 > grain) {
                                        if(people * 10 > answer) {
                                           if (grain / 2 > answer) {
                                                   return answer;
                                           }
                                           else {
                                                   System.out.println("You do not have enough grain to plant!");
                                           }
                                        }
                                        else {
                                                System.out.println("You do not have enough people to plant that much grain!");
                                        }
                                    }
                                    else {
                                            System.out.println("Your citizens will not be happy!");
                                    }
                                } else {
                                        System.out.println("O Great Hamurabi, surely you jest!\nYou can't plant on more land than you own.");
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Try again!");
                                scanner.nextLine();
                                skipQuestion = false;
                        }

                } while (!skipQuestion);
                return answer;
        }
}
