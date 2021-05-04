package com.rosemeire.deconti.elegantreader.utilities;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import android.support.annotation.Nullable;

public class Preconditions {

    private Preconditions() {
        throw new AssertionError("No instances for you!");
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }

        return reference;
    }

    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }

        return reference;
    }

}
