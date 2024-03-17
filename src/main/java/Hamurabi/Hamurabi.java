package Hamurabi;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hamurabi {
    private Integer people = 100;
    private Integer grain = 2800;
    private Integer landAcres = 1000;
    private Integer bushelsPerAcreValue = 19;
    private Integer grainUsed = 0;
    private Integer userAcrestoPlant;
    private boolean gameOver = false;
    private Integer year = 0;
    private Integer peopleStarved = 0;
    private Integer immigrated = 0;
    private Integer bushelsEatenByRat = 0;
    private boolean boughtLand = false;
    Integer newBushels = 0;
    private Integer diedFromPlague = 0;
    private boolean uprising = false;




    Random rand = new Random();

    Scanner scanner = new Scanner(System.in);

    public Hamurabi() {
    }


    public static void main(String[] args) {
        new Hamurabi().playGame();
        }
        void playGame() {
        startGameMessage();
        while (!gameOver) {
            if (year > 10) {
                gameOver = true;
            }
            else {
                // main game -- user input
                landAcres += askHowManyAcresToBuy(bushelsPerAcreValue, grain);
                if (!boughtLand) {
                    landAcres -= askHowManyAcresToSell(landAcres);
                }
                peopleStarved = starvationDeaths(people, askHowMuchGrainToFeedPeople(grain));
                userAcrestoPlant = askHowManyAcresToPlant(landAcres);

                // variables that could happen
                newBushels = harvest(userAcrestoPlant);
                diedFromPlague = plagueDeaths(people);
                uprising = uprising(people,peopleStarved);
                immigrated = immigrants(people, landAcres, grain);
                bushelsEatenByRat = grainEatenByRats(grain);
                grain = grain + newBushels - grainUsed - bushelsEatenByRat;
                bushelsPerAcreValue = newCostOfLand();

                year++;

                if (grain < 0) {
                    grain = 0;
                }

                if (diedFromPlague > 0) {
                    people = people - diedFromPlague;
                }

                if (peopleStarved == 0) {
                    people = people + immigrated;
                }

                else {
                    people = people - peopleStarved;
                }

                if (uprising) {
                    gameOverMessage();
                    gameOver = true;
                }
                else {

                    yearlyMessage();
                }
            }
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
        boughtLand = false;
        boolean skipQuestion = true;
        Integer answer = 0;
        do {
            System.out.println("How many acres would you like to buy?\n");
            try {
                answer = scanner.nextInt();
                if (answer <= 0) {
                    break;
                }
                else if ((grain / bushelsPerAcreValue) > answer) {
                    boughtLand = true;
                    return answer;
                } else {
                    System.out.println("O Great Hamurabi, surely you jest!\nYou must have enough grain to pay for this land.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try again!");
                scanner.nextLine();
                skipQuestion = false;
            }
        } while (skipQuestion);
        System.out.println("No land? Your citizens will be very unhappy with you Great Hamurabi.");
        return answer;
    }
    public Integer askHowManyAcresToSell(Integer landAcres) {
        boolean skipQuestion = true;
        Integer answer = 0;
        if (!boughtLand) {
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
            } while (skipQuestion);
        }
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
                    grainUsed = answer;
                    return answer;
                } else {
                    System.out.println("O Great Hamurabi, surely you jest!\nYou can't feed people more grain than you have.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try again!");
                scanner.nextLine();
                skipQuestion = false;
            }
        } while (skipQuestion);
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
                    if (people * 20 < grain) {
                        if(people * 10 > answer) {
                            if (grain / 2 > answer) {
                                return answer;
                            } else {
                                System.out.println("You do not have enough grain to plant!");
                            }
                        } else {
                            System.out.println("You do not have enough people to plant that much grain!");
                        }
                    } else {
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

    public Integer plagueDeaths(int population) {
        Integer diedByPlague = 0;
        if(rand.nextDouble() <= .15) {
            diedByPlague = population/2;
        }
        return diedByPlague;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {
        double grainNeeded = population * 20;
        double peopleStarved = 0;
        if (bushelsFedToPeople < grainNeeded) {
            peopleStarved = ((grainNeeded - bushelsFedToPeople) / grainNeeded) * 100;
        }
        //this may need to be cast to Integer (check types)
        return (int) peopleStarved;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        Double uprising = 0.45;
        Double percentageOfPeopleStarved = (double) howManyPeopleStarved / population;
        return percentageOfPeopleStarved >= uprising;
    }

    public Integer immigrants(int population, int acresOwned, int grainInStorage) {
        Integer immigrantsImmigrating = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
        return immigrantsImmigrating;
    }

    public Integer harvest(int acres) {
        Integer yield = rand.nextInt(6) +1;
        Integer harvested = acres * yield;
        return harvested;
    }

    public Integer grainEatenByRats(int bushels) {
        Integer grainEaten = 0;
        Double grainEatenProbability = .10 + rand.nextDouble() * .20;
        if(rand.nextDouble() <= .40) {
            grainEaten = (int) (bushels * grainEatenProbability);
        }
        return grainEaten;
    }

    public Integer newCostOfLand(){
        Integer newCost = rand.nextInt(7) + 17;
        return newCost;
    }

    public void yearlyMessage() {
        System.out.printf("Hamurabi:\nI beg to report to you in year %d, %d people starved, %d came to the city." +
                        "\nPopulation is now %d." +
                        "\nThe city now owns %d acres." +
                        "\nYou harvested %d bushels per acre." +
                        "\nRats ate %d bushels.\nYou now have %d bushels in store." +
                        "\nLand now costs %d bushels per acre.\n\n"
                , year, peopleStarved, immigrated, people, landAcres, newBushels, bushelsEatenByRat, grain, bushelsPerAcreValue);
    }

    public void gameOverMessage() {
        System.out.printf("You starved %d people in %d year!\n" +
                "Due to this extreme mismanagement you have not only" +
                "\nbeen impeached and thrown out of office" +
                "\nbut you have also been declared persona non grata!", peopleStarved, year);
    }
}

