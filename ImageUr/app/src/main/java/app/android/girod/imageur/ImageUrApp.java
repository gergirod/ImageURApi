package app.android.girod.imageur;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by germangirod on 8/30/16.
 */
public class ImageUrApp extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
