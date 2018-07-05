package tests;

import common.Film;
import common.People;
import common.Planet;
import org.junit.Assert;
import org.junit.Test;

public class TestAPI extends TestMethods{
    String apiURL = "https://swapi.co/api/";
    String peopleName = "Luke Skywalker";
    String planetName = "Tatooine";
    String population = "200000";
    String filmTitle = "Attack of the Clones";
    int peopleID = 1;


    @Test
    public void findPeopleTest(){
        People people = findPeople(peopleID, apiURL);
        Assert.assertEquals(people.getName(), peopleName);


    }

    @Test
    public void checkPlanetNameTest(){
        People people = findPeople(peopleID, apiURL);
        Planet planet = findHomePlanet(people);
        Assert.assertEquals(planet.getName(), planetName);
    }

    @Test
    public void checkPlanetPopulationTest(){
        People people = findPeople(peopleID, apiURL);
        Planet planet = findHomePlanet(people);
        Assert.assertEquals(planet.getPopulation(), population);
    }

    @Test
    public void checkFilmTitleTest(){
        People people = findPeople(peopleID, apiURL);
        Planet planet = findHomePlanet(people);
        Film film = findFilm(planet, 0);
        Assert.assertEquals(film.getTitle(), filmTitle);
    }

    @Test
    public void checkIsFilmContainPeopleAndPlanetTest(){
        People people = findPeople(peopleID, apiURL);
        Planet planet = findHomePlanet(people);
        Film film = findFilm(planet, 0);
        Assert.assertTrue(film.checkIsContainPeopleAndHisPlanet(people));
    }
}
