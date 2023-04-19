package eus.ehu.final2;

import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public  class Utils {
    OkHttpClient client = new OkHttpClient();





    public static String request (String endpoint){
        String result = "";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://mastodon.social/api/v1/" + endpoint)
                .build();
        try{
            Response response = client.newCall(request).execute();
            if(response.code() == 200){
                result = response.body().string();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }









    static String query(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }




    public static List <Status> dameList() throws IOException {
        String id = "109903390691977965";
        String json = Utils.request("accounts/"+id+"/statuses");
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(json, JsonArray.class);
        Type statusList= new TypeToken<List<Status>>(){}.getType();
        return gson.fromJson(json, statusList);

    }




}
