package com.rosemeire.deconti.elegantreader.dataImage;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import com.android.volley.toolbox.ImageLoader;
import com.rosemeire.deconti.elegantreader.ElegantReader;
import com.rosemeire.deconti.elegantreader.utilities.ImageLoaderHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/* ************************************************************************************************/
/* **** Dagger
/* ************************************************************************************************/

@Module
public class SingletonModule {

    @Singleton
    @Provides
    ImageLoaderHelper provideImageLoaderHelper(ElegantReader app) {
        return new ImageLoaderHelper(app);
    }

    @Singleton
    @Provides
    ImageLoader provideImageLoader(ImageLoaderHelper imageLoaderHelper) {
        return imageLoaderHelper.getImageLoader();
    }

}
