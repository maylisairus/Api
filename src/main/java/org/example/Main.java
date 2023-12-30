package org.example;

import netscape.javascript.JSObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import org.json.*;


public class Main {

    private static final String TEST_URL =
            "https://jsonplaceholder.typicode.com/users";
    private static final String URL_POSTS =
            "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException {
        getAllUsers();
        create();
        System.out.println(getUserById(1));
        getUserByUserName("Antonette");
        delete(1);
        update();
        System.out.println(getComments(3));
        getTasks(1);
    }

    private static void getAllUsers() throws IOException {
        URL url = new URL(TEST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }

    private static void create() throws IOException {
        URL url = new URL(TEST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(Files.readAllBytes(new File("src/main/resources/user.json").toPath()));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }
    private static String getUserById(int id) throws IOException {
        URL url = new URL(TEST_URL+"/"+ id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET user by id response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "GET request not worked";
        }
    }
    private static void getUserByUserName(String userName) throws IOException {
        URL url = new URL(TEST_URL+"?username="+ userName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET user by username response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }
    private static void delete(int id) throws IOException {
        URL url = new URL(TEST_URL+"/"+id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);
        connection.connect();
        int responseCode = connection.getResponseCode();
        System.out.println("DELETE response code: " + responseCode);
        if(responseCode!=HttpURLConnection.HTTP_OK){
            System.out.println("DELETE request not worked");
        }
    }
    private static void update() throws IOException {
        URL url = new URL(TEST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(("{\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"Timur Pekar\",\n" +
                        "        \"username\": \"Timur\",\n" +
                        "        \"email\": \"Sincere@april.biz\",\n" +
                        "        \"address\": {\n" +
                        "            \"street\": \"Kulas Light\",\n" +
                        "            \"suite\": \"Apt. 556\",\n" +
                        "            \"city\": \"Gwenborough\",\n" +
                        "            \"zipcode\": \"92998-3874\",\n" +
                        "            \"geo\": {\n" +
                        "                \"lat\": \"-37.3159\",\n" +
                        "                \"lng\": \"81.1496\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        \"phone\": \"1-770-736-8031 x56442\",\n" +
                        "        \"website\": \"hildegard.org\",\n" +
                        "        \"company\": {\n" +
                        "            \"name\": \"Romaguera-Crona\",\n" +
                        "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "            \"bs\": \"harness real-time e-markets\"\n" +
                        "        }\n" +
                        "    }").getBytes());
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }
    private static String getPosts(int userId) throws IOException {
        URL url = new URL(TEST_URL+"/"+ userId+"/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
           return response.toString();

        }
        return null;
    }
    private static String getComments(int userId) throws IOException {
        JSONArray posts = new JSONArray(getPosts(userId));
        int id = -1;
        for(Object post: posts){
            JSONObject p = new JSONObject(post.toString());
            if(p.getInt("id")>id){
                id = (p.getInt("id"));
            }
            System.out.println(p.toString());
        }
        System.out.println("max id" + id);
        URL url = new URL(URL_POSTS+"/"+ id+"/comments");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        String fileName = "user-"+ userId+ "-post-" + id + "-comments.json";
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            FileWriter file = new FileWriter(fileName);
            file.write(response.toString());
            file.close();
            return response.toString();

        }
        return null;
    }
    private static void getTasks(int userId) throws IOException {
        URL url = new URL(TEST_URL+"/"+ userId+"/todos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONArray posts = new JSONArray(response.toString());
            for(Object post: posts){
                JSONObject p = new JSONObject(post.toString());
                if(p.getBoolean("completed")){
                    System.out.println(p.toString());
                }
            }
        }
        else {
            System.out.println("bad get request");
        }
    }
}