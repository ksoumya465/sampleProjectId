package com.concepts;

public class JSONExample {

	public static void main() {}
	
	/**
	 * {
    "pageInfo": {
            "pageName": "Homepage",
            "logo": "https://www.example.com/logo.jpg"
    },
    "posts": [
	            {
	                "post_id": "0123456789",
	                "actor_id": "1001",
	                "author_name": "Jane Doe",
	                "post_title": "How to parse JSON in Java",
	                "comments": [],
	                "time_of_post": "1234567890"
	            }
	    ]
	}
	 */
	
	/**
	 * Parse JSON Using org.json
	 */
	/*
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {
    static String json = "...";
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);
        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
    }
}
	 */
	
	/**
	 * Parse JSON Using Gson
	 */
	
	/*
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseJSON {
    static String json = "...";
    public static void main(String[] args) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        String pageName = jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
        System.out.println(pageName);

        JsonArray arr = jsonObject.getAsJsonArray("posts");
        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
            System.out.println(post_id);
        }
    }
	 */
	/**
	 * Parse JSON Using JsonPATH
	 */
	
/*
 import com.jayway.jsonpath.JsonPath;

public class ParseJSON {
    static String json = "...";
    public static void main(String[] args) {
        String pageName = JsonPath.read(json, "$.pageInfo.pageName");
        System.out.println(pageName);

        Integer posts = JsonPath.read(json, "$.posts.length()");

        for(int i=0; i < posts; i++) {
            String post_id = JsonPath.read(json, "$.posts[" + i + "].post_id");
            System.out.println(post_id);
        }
    }
}	
 */
}
