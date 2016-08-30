package app.android.girod.imageur.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by germangirod on 8/30/16.
 */
public class ImagesResponse implements Parcelable {

    public List<Image> data;

    public List<Image> getData() {
        return data;
    }

    public ImagesResponse (){

    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel parcel, int i) {

        parcel.writeTypedList(data);

    }

    public static final Parcelable.Creator<ImagesResponse> CREATOR
            = new Parcelable.Creator<ImagesResponse>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public ImagesResponse createFromParcel(Parcel in) {
            return new ImagesResponse(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public ImagesResponse[] newArray(int size) {
            return new ImagesResponse[size];
        }
    };

    private ImagesResponse(Parcel in) {
        data = new ArrayList<>();
        in.readTypedList(data, Image.CREATOR);

    }

}
