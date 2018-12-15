package uk.co.strangeowl.scraper.results;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResultSerializer {

    public static String serialize(Result result) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();

        return gson.toJson(result);
    }

}
