package common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class JsonReader {
    public People getPeople(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<People>(){}.getType());
    }

    public Planet getPlanet(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<Planet>(){}.getType());
    }

    public Film getFilm(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<Film>(){}.getType());
    }

    public String convertToString(String request){
        String json = "";
        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(new HttpGet(request))
        ) {
            HttpEntity entity = response.getEntity();
            if (entity!=null){
                json = IOUtils.toString(entity.getContent());
            }
        } catch(Throwable throwable){
            throwable.printStackTrace();
        }
        return json;
    }
}
