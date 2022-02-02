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

    public enum VotePage {
        CZECH_CRAFT,
        CRAFTLIST;
    }

    private final Gson gson = new GsonBuilder().create();

    public List<CzechCraftVote> czechCraftVotes(String serverSlug, int year, int month) {
        JsonObject object = getElement(String.format("https://czech-craft.eu/api/server/%s/votes/%s/%s/", serverSlug, year, month)).getAsJsonObject();
        JsonElement jsonElement = object.get("data");
        return gson.fromJson(jsonElement.toString(), getType(VotePage.CZECH_CRAFT));
    }

    public List<CraftListVote> craftListVotes(String token, int year, int month) {
        JsonElement element = getElement(String.format("https://api.craftlist.org/v1/%s/votes/%s/%s/", token, year, month));
        return gson.fromJson(element.toString(), getType(VotePage.CRAFTLIST));
    }

    @SneakyThrows
    private JsonElement getElement(String rawUrl) {
        URL url = new URL(rawUrl);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String json = bufferedReader.readLine().trim();
        JsonParser parser = new JsonParser();
        return parser.parse(json);
    }

    private Type getType(VotePage votePage) {
        switch (votePage) {
            case CZECH_CRAFT:
            case CRAFTLIST:
                return new TypeToken<List<CzechCraftVote>>(){}.getType();
        }
        return null;
    }

}
