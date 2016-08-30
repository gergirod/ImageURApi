package app.android.girod.imageur.data.api;

import app.android.girod.imageur.data.model.ImagesResponse;
import rx.Observable;

/**
 * Created by germangirod on 8/30/16.
 */
public interface Request {

    Observable<ImagesResponse> getImages(String accessToken);

}
