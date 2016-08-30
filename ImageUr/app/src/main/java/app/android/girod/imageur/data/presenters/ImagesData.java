package app.android.girod.imageur.data.presenters;

import app.android.girod.imageur.BuildConfig;
import app.android.girod.imageur.data.api.ApiRequest;
import app.android.girod.imageur.data.model.Image;
import app.android.girod.imageur.data.model.ImagesResponse;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by germangirod on 8/30/16.
 */
public class ImagesData {

    private ApiRequest apiRequest;
    private ImagesPresenter imagesPresenter;

    public ImagesData(ImagesPresenter imagesPresenter){

        apiRequest = new ApiRequest();
        this.imagesPresenter = imagesPresenter;

    }

    public void getImages(){

        apiRequest.getImages(BuildConfig.KEY_CLIENT)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<ImagesResponse, Observable<ImagesResponse>>() {
                    @Override public Observable<ImagesResponse> call(ImagesResponse imagesResponse) {
                        List<Image> images = new ArrayList<Image>();
                        for (Image image : imagesResponse.getData()) {
                            if (!image.isNsfw() && image.getType()!=null) {
                                if(image.getType().equals("image/jpeg")){
                                    images.add(image);
                                }
                            }
                        }

                        imagesResponse.data = images;

                        return Observable.just(imagesResponse);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ImagesResponse>() {
            @Override public void call(ImagesResponse imagesResponse) {

                imagesPresenter.onImageResponseSuccess(imagesResponse);
            }
        }, new Action1<Throwable>() {
            @Override public void call(Throwable throwable) {
                imagesPresenter.onError(throwable);
            }
        });

    }
}
