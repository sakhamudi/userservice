package com.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.model.User;


public class PostJSONWithHttpURLConnection {

    public static void main (String []args) throws IOException{

         User user = new User();
         user.setOrganization("Nisum");
         user.setUsername("Praveen");


        UserService.getUserDetails(user);
    }

}
