package com.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserService {

    public static  void getUserDetails(User user){

        try{

        URL url = new URL ("http://localhost:8080/user/useradmin/searchuser/byuserid");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        // con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        //JSON String need to be constructed for the specific resource.
        //We may construct complex JSON using any third-party JSON libraries such as jackson or org.json


        ObjectMapper mapper = new ObjectMapper();
        String jsonInputString = mapper.writeValueAsString(user);
        System.out.println(" Json string ::: "+jsonInputString);
        OutputStream os = con.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);

           int code = con.getResponseCode();
        System.out.println(code);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }catch (Exception e){

            System.out.println("Exception ::: "+e.getMessage());
        }
    }
}
