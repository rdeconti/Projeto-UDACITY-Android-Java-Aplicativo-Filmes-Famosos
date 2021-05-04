package com.rosemeire.deconti.elegantreader.userInterface;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import com.rosemeire.deconti.elegantreader.dataImage.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/* ************************************************************************************************/
/* **** Dagger
/* ************************************************************************************************/

@Module
public abstract class ArticleDetailActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ArticleDetailFragment contributeArticleDetailFragment();

}
