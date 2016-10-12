package alanpan.gbi.com.frescodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by alan.pan on 2016/9/18.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
