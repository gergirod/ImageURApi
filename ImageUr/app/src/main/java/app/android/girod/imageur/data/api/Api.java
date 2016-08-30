package app.android.girod.imageur.data.api;

import app.android.girod.imageur.data.model.ImagesResponse;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by germangirod on 8/30/16.
 */
public interface Api {

    @GET("3/gallery/r/funny") Observable<ImagesResponse> getImages(@Header("Authorization") String accessToken);

}
