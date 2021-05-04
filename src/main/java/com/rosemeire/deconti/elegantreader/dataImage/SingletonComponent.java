package com.rosemeire.deconti.elegantreader.dataImage;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import com.rosemeire.deconti.elegantreader.ElegantReader;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/* ************************************************************************************************/
/* **** Dagger
/* ************************************************************************************************/

@Singleton
@Component(modules = {SingletonModule.class,
        ActivityBuilderModule.class,
        AndroidInjectionModule.class})

public interface SingletonComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(ElegantReader app);

        SingletonComponent build();
    }

    void inject(ElegantReader app);

}
