package com.rosemeire.deconti.elegantreader.utilities;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/* ************************************************************************************************/
/* **** Volley
/* ************************************************************************************************/

public class ImageLoaderHelper {
    private final LruCache<String, Bitmap> imageCache = new LruCache<>(20);
    private ImageLoader imageLoader;

    public ImageLoaderHelper(Context context) {
        final RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        final ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String key, Bitmap value) {
                ImageLoaderHelper.this.imageCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return ImageLoaderHelper.this.imageCache.get(key);
            }
        };
        imageLoader = new ImageLoader(queue, imageCache);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
