package tests;

import common.Film;
import common.JsonReader;
import common.People;
import common.Planet;

public class TestMethods {

    public People findPeople(int id, String apiURL){
        String request = apiURL+"people/"+id;

        JsonReader reader = new JsonReader();

        return reader.getPeople(reader.convertToString(request));
    }

    public Planet findHomePlanet(People people) {
        String request = people.getHomeworld();
        JsonReader reader = new JsonReader();

        return reader.getPlanet(reader.convertToString(request));
    }

    public Film findFilm(Planet planet, int index){
        String request = planet.getFilms().get(index);
        JsonReader reader = new JsonReader();

        return reader.getFilm(reader.convertToString(request));
    }


}
