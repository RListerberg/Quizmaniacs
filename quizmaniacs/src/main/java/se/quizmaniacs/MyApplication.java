package se.quizmaniacs;

import android.app.Application;

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
