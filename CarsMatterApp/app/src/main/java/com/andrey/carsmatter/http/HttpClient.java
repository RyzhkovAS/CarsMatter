package com.andrey.carsmatter.http;

import android.graphics.Bitmap;

import com.andrey.carsmatter.models.User;

import java.io.File;
import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient {

    private String AuthorizationHeaderValue;

    private OkHttpClient httpClient = new OkHttpClient();

    public String loginRequest(String url, String requestJson) {
        final MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediaType, requestJson))
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String postHttpRequest(String url, String requestJson) {
        this.AuthorizationHeaderValue = Credentials.basic((User.getCurrentUser().Username), User.getCurrentUser().Password);
        final MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", AuthorizationHeaderValue)
                .post(RequestBody.create(mediaType, requestJson))
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String postFile(String url, byte[] file) {
        this.AuthorizationHeaderValue = Credentials.basic((User.getCurrentUser().Username), User.getCurrentUser().Password);
        final MediaType mediaType = MediaType.parse("image/jpeg");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", AuthorizationHeaderValue)
                .post(RequestBody.create(mediaType, file ))
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String putHttpRequest(String url, String requestJson) {
        this.AuthorizationHeaderValue = Credentials.basic((User.getCurrentUser().Username), User.getCurrentUser().Password);
        final MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", AuthorizationHeaderValue)
                .put(RequestBody.create(mediaType, requestJson))
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteHttpRequest(String url) {
        this.AuthorizationHeaderValue = Credentials.basic((User.getCurrentUser().Username), User.getCurrentUser().Password);
        final MediaType mediaType = MediaType.parse("application/json");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", AuthorizationHeaderValue)
                .delete(RequestBody.create(mediaType, ""))
                .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHttpResponse(String url) {
        this.AuthorizationHeaderValue = Credentials.basic((User.getCurrentUser().Username), User.getCurrentUser().Password);
        Request request = new Request.Builder()
            .url(url)
            .addHeader("Authorization", AuthorizationHeaderValue)
            .build();
        Response response;
        try {
            response = httpClient.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}