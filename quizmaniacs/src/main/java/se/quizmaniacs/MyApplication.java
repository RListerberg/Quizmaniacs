package se.quizmaniacs;

import android.app.Application;

/**
 * Created by LeoAsp on 2017-02-13.
 */

public class MyApplication extends Application {

    private static MyApplication app;

    @Override
    public void onCreate() {
        app = this;
    }

    public static MyApplication get() {
        return app;
    }
}
