package cz.maku.topvoters.v1.service;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import cz.maku.topvoters.v1.model.CraftListVote;
import cz.maku.topvoters.v1.model.CzechCraftVote;
import lombok.SneakyThrows;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

@Service
public class TopVotersService {

    private final Gson gson = new GsonBuilder().create();

    /*

        Maybe sometimes when I will have more time I will rewrite this. But now it's not time for that. :P
        - maku 04.12.2021 20:40

     */


    @SneakyThrows
    public List<CzechCraftVote> czechCraftVotes(String serverSlug, int year, int month) {
        URL url = new URL(String.format("https://czech-craft.eu/api/server/%s/votes/%s/%s/", serverSlug, year, month));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String json = bufferedReader.readLine().trim();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        JsonObject object = element.getAsJsonObject();
        JsonElement jsonElement = object.get("data");
        Type type = new TypeToken<List<CzechCraftVote>>(){}.getType();
        return gson.fromJson(jsonElement.toString(), type);
    }

    @SneakyThrows
    public List<CraftListVote> craftListVotes(String token, int year, int month) {
        URL url = new URL(String.format("https://api.craftlist.org/v1/%s/votes/%s/%s/", token, year, month));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String json = bufferedReader.readLine().trim();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        Type type = new TypeToken<List<CraftListVote>>(){}.getType();
        return gson.fromJson(element.toString(), type);
    }

}
