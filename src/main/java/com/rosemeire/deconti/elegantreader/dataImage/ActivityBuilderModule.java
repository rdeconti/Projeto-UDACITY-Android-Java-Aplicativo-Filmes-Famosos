package com.rosemeire.deconti.elegantreader.dataImage;

/* ********************************************************************************************** */
/* UDACITY Android Developer NanoDegree Program
/* Created by Rosemeire Deconti on 10/12/2018
/* Based on "XYZ READER" from Udacity Repository and adjusted to attend Rubric Review
/* https://github.com/udacity/xyz-reader-starter-code
/* ********************************************************************************************** */

import com.rosemeire.deconti.elegantreader.userInterface.ArticleDetailActivity;
import com.rosemeire.deconti.elegantreader.userInterface.ArticleDetailActivityModule;
import com.rosemeire.deconti.elegantreader.userInterface.ArticleListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/* ************************************************************************************************/
/* **** Dagger
/* ************************************************************************************************/

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ArticleListActivity contributeArticleListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ArticleDetailActivityModule.class)
    abstract ArticleDetailActivity contributeArticleDetailActivity();

}
