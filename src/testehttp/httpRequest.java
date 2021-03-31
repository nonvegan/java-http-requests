package testehttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;
import org.json.JSONArray;

public class httpRequest {

    private static String key = "YutHLWtzBbK2pAzEhFbO7kWLDI3ddam1";

    public static ArrayList<JSONObject> httpGet(String url) throws IOException {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("key", key);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String responseString = org.apache.commons.io.IOUtils.toString(rd);
            if (responseString.charAt(0) != '[') {
                responseString = "[" + responseString + "]";
            }
            JSONArray jsonArray = new JSONArray(responseString);
            for (Object object : jsonArray) {
                arrayList.add((JSONObject) object);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            response.close();
            return arrayList;
        }
    }

    public static ArrayList<JSONObject> httpPost(String url, JSONObject jsonBody) throws IOException {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("key", key);
        httppost.setEntity(new StringEntity(jsonBody.toString(), ContentType.create("application/json")));
        CloseableHttpResponse response = httpclient.execute(httppost);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String responseString = org.apache.commons.io.IOUtils.toString(rd);
            if (responseString.charAt(0) != '[') {
                responseString = "[" + responseString + "]";
            }
            JSONArray jsonArray = new JSONArray(responseString);
            for (Object object : jsonArray) {
                arrayList.add((JSONObject) object);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            response.close();
            return arrayList;
        }
    }

    public static ArrayList<JSONObject> httpPut(String url, JSONObject jsonBody) throws IOException {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);
        httpput.addHeader("key", key);
        httpput.setEntity(new StringEntity(jsonBody.toString(), ContentType.create("application/json")));
        CloseableHttpResponse response = httpclient.execute(httpput);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String responseString = org.apache.commons.io.IOUtils.toString(rd);
            if (responseString.charAt(0) != '[') {
                responseString = "[" + responseString + "]";
            }
            JSONArray jsonArray = new JSONArray(responseString);
            for (Object object : jsonArray) {
                arrayList.add((JSONObject) object);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            response.close();
            return arrayList;
        }
    }

    public static ArrayList<JSONObject> httpDelete(String url) throws IOException {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete httpdelete = new HttpDelete(url);
        httpdelete.addHeader("key", key);
        CloseableHttpResponse response = httpclient.execute(httpdelete);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String responseString = org.apache.commons.io.IOUtils.toString(rd);
            if (responseString.charAt(0) != '[') {
                responseString = "[" + responseString + "]";
            }
            JSONArray jsonArray = new JSONArray(responseString);
            for (Object object : jsonArray) {
                arrayList.add((JSONObject) object);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            response.close();
            return arrayList;
        }
    }

    public static void main(String[] args) throws IOException {
        //---GET---//
        //ArrayList array = httpGet("URL");
        //System.out.println(array.get(0));
        //System.out.println(array.get(1));
        //---POST---//---PUT---//
        //JSONObject jsonBody = new JSONObject();
        // jsonBody.accumulate("Key", "Value");
        //System.out.println(httpPost("URL", jsonBody));
    }
}
