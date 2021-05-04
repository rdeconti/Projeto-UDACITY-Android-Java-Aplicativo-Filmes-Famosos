package com.rosemeire.deconti.elegantreader.database;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import android.net.Uri;

/* ************************************************************************************************/
/* **** Contract to get items
/* ************************************************************************************************/

public class ItemsContract {

    public static final String CONTENT_AUTHORITY = "com.rosemeire.deconti.elegantreader";
    private static final Uri BASE_URI = Uri.parse("content://com.rosemeire.deconti.elegantreader");

    interface ItemsColumns {

        String _ID = "_id";
        String SERVER_ID = "server_id";
        String TITLE = "title";
        String AUTHOR = "author";
        String BODY = "body";
        String THUMB_URL = "thumb_url";
        String PHOTO_URL = "photo_url";
        String ASPECT_RATIO = "aspect_ratio";
        String PUBLISHED_DATE = "published_date";
    }

    public static class Items implements ItemsColumns {

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.rosemeire.deconti.elegantreader.items";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.rosemeire.deconti.elegantreader.items";
        public static final String DEFAULT_SORT = PUBLISHED_DATE + " DESC";

        public static Uri buildDirUri() {
            return BASE_URI.buildUpon().appendPath("items").build();
        }

        public static Uri buildItemUri(long _id) {
            return BASE_URI.buildUpon().appendPath("items").appendPath(Long.toString(_id)).build();
        }

        public static long getItemId(Uri itemUri) {
            return Long.parseLong(itemUri.getPathSegments().get(1));
        }
    }

    private ItemsContract() {

    }
}
