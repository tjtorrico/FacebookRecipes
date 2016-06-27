package net.tjtorrico.facebookrecipes.libs;

import android.widget.ImageView;

/**
 * Created by TJT on 27/06/2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedLoadingListener(Object listener);
}
