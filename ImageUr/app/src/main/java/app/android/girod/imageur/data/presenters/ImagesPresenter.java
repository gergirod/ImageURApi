package app.android.girod.imageur.data.presenters;

import app.android.girod.imageur.data.model.ImagesResponse;

/**
 * Created by germangirod on 8/30/16.
 */
public interface ImagesPresenter {

    void onImageResponseSuccess(ImagesResponse imagesResponse);

    void onError(Throwable throwable);

}
