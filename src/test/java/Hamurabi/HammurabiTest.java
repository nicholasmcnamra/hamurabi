package Hamurabi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.logging.Handler;

public class HammurabiTest {

    @Test
    public void plagueDeathsTest() {
        Integer people = 100;
        Hamurabi hamurabi = new Hamurabi();

        boolean actual = hamurabi.plagueDeaths(people) <= 50;

        Assert.assertTrue(actual);
    }

    @Test
    public void starvationDeathsTest() {
        Integer people = 100;
        Integer bushelsFedToPeople = 1500;
        Hamurabi hamurabi = new Hamurabi();

        Integer expectedStarvationDeath = 25;

        Integer actualStarvationDeath = hamurabi.starvationDeaths(people, bushelsFedToPeople);

        Assert.assertEquals(expectedStarvationDeath, actualStarvationDeath);
    }

    @Test
    public void starvationDeathsTest2() {
        Integer people = 50;
        Integer bushelsFedToPeople = 900;
        Hamurabi hamurabi = new Hamurabi();

        Integer expectedStarvationDeath = 10;

        Integer actualStarvationDeath = hamurabi.starvationDeaths(people, bushelsFedToPeople);

        Assert.assertEquals(expectedStarvationDeath, actualStarvationDeath);
    }

    @Test
    public void uprisingTest() {
        Integer people = 100;
        Integer peopleStarved = 45;
        Hamurabi hamurabi = new Hamurabi();

        boolean expectedUprising = true;
        boolean actualUprising = hamurabi.uprising(people, peopleStarved);

        Assert.assertEquals(expectedUprising, actualUprising);
    }

    @Test
    public void uprisingTest2() {
        Integer people = 95;
        Integer peopleStarved = 30;
        Hamurabi hamurabi = new Hamurabi();

        boolean expectedUprising = false;
        boolean actualUprising = hamurabi.uprising(people, peopleStarved);

        Assert.assertEquals(expectedUprising, actualUprising);
    }

    @Test
    public void immigrantsTest() {
        Integer people = 100;
        Integer acresOwned = 1000;
        Integer grain = 1500;
        Hamurabi hamurabi = new Hamurabi();

        Integer expectedImmigrants = 3;
        Integer actualImmigrants = hamurabi.immigrants(people, acresOwned, grain);
        Assert.assertEquals(expectedImmigrants, actualImmigrants);
    }

    @Test
    public void harvestTest() {
        Integer acresOwned = 500;
        Hamurabi hamurabi = new Hamurabi();

        boolean actualHarvest = hamurabi.harvest(acresOwned) <= 3000;
        Assert.assertTrue(actualHarvest);
    }

    @Test
    public void grainEatenByRatsTest() {
        Integer grain = 1000;
        Hamurabi hamurabi = new Hamurabi();

        boolean actualEatenByRats = hamurabi.grainEatenByRats(grain) <= 300;

        Assert.assertTrue(actualEatenByRats);
    }

    @Test
    public void newCostOfLandTest() {
        Hamurabi hamurabi = new Hamurabi();

        boolean actualCost = hamurabi.newCostOfLand() >= 17 && hamurabi.newCostOfLand() <= 23;

        Assert.assertTrue(actualCost);
    }
}