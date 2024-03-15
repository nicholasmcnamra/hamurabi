package Hamurabi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.logging.Handler;

public class HammurabiTest {

//    @Test
////    public void constructorTest() {
////        Integer people = 100;
////        Integer grain = 2800;
////        Integer landAcres = 1000;
////        Integer bushelsPerAcre = 19;
////
////        Hamurabi hamurabi = new Hamurabi();
////
////        Assert.assertEquals(people, hamurabi.getPeople());
////        Assert.assertEquals(grain, hamurabi.getGrain());
////        Assert.assertEquals(landAcres, hamurabi.getLandAcres());
////        Assert.assertEquals(bushelsPerAcre, hamurabi.getBushelsPerAcre());
////
////    }

    @Test
    public void askHowManyAcresToBuyTest() {
        Integer bushelsPerAcre = 19;
        Integer landAcres = 50;

        Hamurabi hamurabi = new Hamurabi();

        Integer expectedAcresToBuy = landAcres/bushelsPerAcre;
        Integer actualAcresToBuy = hamurabi.askHowManyAcresToBuy(bushelsPerAcre, landAcres);

        Assert.assertEquals(expectedAcresToBuy, actualAcresToBuy);
    }

    @Test
    public void askHowManyAcresToSellTest() {
        Integer acresOwned = 100;
        Integer acresToSell = 50;

        Hamurabi hamurabi = new Hamurabi();

        Integer expectedAcresLeft = acresOwned-acresToSell;
        Integer actualAcresLeft = hamurabi.askHowManyAcresToSell();

        Assert.assertEquals(expectedAcresLeft, actualAcresLeft);
    }

    @Test
    public void askHowMuchGrainToFeedPeopleTest() {
        Integer grainToFeedPeople = 1000;

        Hamurabi hamurabi = new Hamurabi();

        Integer expectedGrainToFeedPeople = grainToFeedPeople;
        Integer actualGrainToFeedPeople = hamurabi.askHowMuchGrainToFeedPeople();

        Assert.assertEquals(expectedGrainToFeedPeople, actualGrainToFeedPeople);
    }

    @Test
    public void askHowManyAcresToPlantTest() {
        Integer acresToPlant = 500;

        Hamurabi hamurabi = new Hamurabi();

        Integer expectedAcresToPlant = acresToPlant;
        Integer actualAcresToPlant = hamurabi.askHowManyAcresToPlant();

        Assert.assertEquals(expectedAcresToPlant, actualAcresToPlant);
    }

    @Test
    public void plagueDeathsTest() {

    }

    @Test
    public void starvationDeathsTest() {

    }

    @Test
    public void uprisingTest() {

    }

    @Test
    public void immigrantsTest() {

    }

    @Test
    public void harvestTest() {

    }

    @Test
    public void grainEatenByRatsTest() {

    }

    @Test
    public void newCostOfLandTest() {

    }
}