package com.sachin.dmilf.views.activites;

import android.app.Application;
import android.content.Context;

import com.sachin.dmilf.utils.LocaleHelper;


public class UpdateApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}