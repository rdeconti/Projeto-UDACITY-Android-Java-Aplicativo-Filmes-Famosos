package com.rosemeire.deconti.elegantreader.utilities;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class RemoteEndpointUtil {

    static final String BASE_URL = "https://nspf.github.io/XYZReader/data.json";

    private RemoteEndpointUtil() {
    }

    public static JSONArray fetchJsonArray() {
        String itemsJson;
        try {
            itemsJson = fetchPlainText();
        } catch (IOException e) {
            Timber.e(e, "Error fetching items JSON");
            return null;
        }

        try {
            JSONTokener tokener = new JSONTokener(itemsJson);
            Object val = tokener.nextValue();
            if (!(val instanceof JSONArray)) {
                throw new JSONException("Expected JSONArray");
            }
            return (JSONArray) val;
        } catch (JSONException e) {
            Timber.e(e, "Error parsing items JSON");
        }

        return null;
    }

    private static String fetchPlainText() throws IOException {
        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
