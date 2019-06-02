package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        //(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image,
        // List<String> ingredients) {

        try {
            JSONObject jsonObject= new JSONObject(json);

            JSONArray jsonArray1 =jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for (int i=0;i<jsonArray1.length();i++)
               alsoKnownAsList.add((String)jsonArray1.get(i));

            JSONArray jsonArray2 =jsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i=0;i<jsonArray2.length();i++)
                ingredientsList.add((String)jsonArray2.get(i));


            String mainName = jsonObject.getJSONObject("name").getString("mainName");
            String placeOfOrigin =jsonObject.getString("placeOfOrigin");
            String description=jsonObject.getString("description");
            String image=jsonObject.getString("image");;

            return new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredientsList) ;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


}
