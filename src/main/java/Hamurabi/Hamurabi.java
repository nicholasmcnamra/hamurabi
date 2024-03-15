package Hamurabi;
import java.util.Random;
import java.util.Scanner;

public class Hamurabi {
        private Integer people = 100;
        private Integer grain = 2800;
        private Integer landAcres = 1000;
        private Integer bushelsPerAcre = 19;

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        public Hamurabi() {
        }

        public static void main(String[] args) {
                new Hamurabi().playGame();

        }

        void playGame() {
                askHowManyAcresToBuy(19,50);
        // declare local variables here: grain, population, etc.
            // statements go after the declations
        }

        public Integer askHowManyAcresToBuy(Integer bushelsPerAcre, Integer landAcres) {
                System.out.println("How many acres would you like to buy?\n");
                Integer answer = scanner.nextInt();

                return answer/bushelsPerAcre;
        }
        public Integer askHowManyAcresToSell() {
                return null;
        }

        public Integer askHowMuchGrainToFeedPeople() {
                return null;
        }

        public Integer askHowManyAcresToPlant() {
                return null;
        }



}
