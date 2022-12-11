package codegym.controller;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class SlackAPI {

    static String web_hook_url = "https://nextlevelbot.com/telegram/webhook/RDBPNzEvTHp5QnUrWlI3dzZnL3NIZEQzOEpoMDllYU04OWt4QlA2UFJzU3phd0p4RzhocEpwYmxvK0Jma0toczQ0b3FuVmMxcFRmcWZjcThLTDFhNHZKRThOd1d6OUtvMWRXeGZlbHV3eCtIWlV2OVlBYzlYTzN4cjdhNmRHQ2M=";

    public static void main(String[] args) {


        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(web_hook_url);

        try {
            String json = "{\"name\": John}";
            System.out.println(json);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            client.execute(httpPost);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
