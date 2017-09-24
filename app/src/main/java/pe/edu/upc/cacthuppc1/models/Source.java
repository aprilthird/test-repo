package pe.edu.upc.cacthuppc1.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.cacthuppc1.networking.ClearbitLogoApiService;

/**
 * Created by Usuario on 21/09/2017.
 */

public class Source {
    private String id;
    private String name;
    private String url;
    private String description;
    private String category;
    private String language;
    private String country;
    private List<String> sortBysAvailable;

    public Source() {
    }

    public Source(String id, String name, String url, String description, String category, String language, String country, List<String> sortBysAvailable) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.category = category;
        this.language = language;
        this.country = country;
        this.sortBysAvailable = sortBysAvailable;
    }

    public String getId() {
        return id;
    }

    public Source setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Source setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Source setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Source setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Source setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Source setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Source setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public Source setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("name", name);
        bundle.putString("description", description);
        bundle.putString("category", category);
        bundle.putString("url", url);
        bundle.putString("country", country);
        bundle.putString("language", language);
        bundle.putStringArrayList("sortBysAvailable", (ArrayList<String>) sortBysAvailable);
        return bundle;
    }

    public static Source from(JSONObject jsonSource){
        Source source = new Source();
        try{
            List<String> sortBysAvailable = new ArrayList<>();
            JSONArray jsonSortBysAvailable = jsonSource.getJSONArray("sortBysAvailable");
            for(int i = 0; i<jsonSortBysAvailable.length(); ++i)
                sortBysAvailable.add(jsonSortBysAvailable.getString(i));
            source.setId(jsonSource.getString("id"))
                    .setName(jsonSource.getString("name"))
                    .setDescription(jsonSource.getString("description"))
                    .setCategory(jsonSource.getString("category"))
                    .setUrl(jsonSource.getString("url"))
                    .setLanguage(jsonSource.getString("language"))
                    .setCountry(jsonSource.getString("country"))
                    .setSortBysAvailable(sortBysAvailable);
            return source;
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Source> from(JSONArray jsonSources){
        List<Source> sources = new ArrayList<>();
        for(int i = 0; i < jsonSources.length(); ++i)
            try {
                sources.add(Source.from(jsonSources.getJSONObject(i)));
            }
            catch(JSONException e){
                e.printStackTrace();
            }
            return sources;
    }

    public String getUrlToLogo() {
        return ClearbitLogoApiService.getUrlToLogo(url);
    }
}
