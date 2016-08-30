package app.android.girod.imageur.data.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by germangirod on 8/30/16.
 */
public class Image implements Parcelable{

    public String id;
    public String title;
    public String description;
    public long datetime;
    public String type;
    public boolean animated;
    public int width;
    public int height;
    public int size;
    public int views;
    public long bandwidth;
    public String vote;
    public boolean favorite;
    public boolean nsfw;
    public String section;
    public String account_url;
    public String account_id;
    public boolean in_gallery;
    public String link;
    public boolean is_ad;
    public String comment_count;
    public String ups;
    public String downs;
    public String points;
    public int score;
    public boolean is_album;

    protected Image(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        datetime = in.readLong();
        type = in.readString();
        width = in.readInt();
        height = in.readInt();
        size = in.readInt();
        views = in.readInt();
        bandwidth = in.readLong();
        vote = in.readString();
        section = in.readString();
        account_url = in.readString();
        account_id = in.readString();
        link = in.readString();
        comment_count = in.readString();
        ups = in.readString();
        downs = in.readString();
        points = in.readString();
        score = in.readInt();
        animated = in.readByte() != 0;
        favorite = in.readByte() != 0;
        nsfw = in.readByte() != 0;
        in_gallery = in.readByte() != 0;
        is_ad = in.readByte() != 0;
        is_album = in.readByte() != 0;


    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    public int getViews() {
        return views;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public String getVote() {
        if(vote == null || vote.equals("0")){
            return "No votes";
        }
        return vote;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public String getSection() {
        return section;
    }

    public String getAccount_url() {
        return account_url;
    }

    public String getAccount_id() {
        return account_id;
    }

    public boolean isIn_gallery() {
        return in_gallery;
    }

    public String getLink() {
        return link;
    }

    public boolean is_ad() {
        return is_ad;
    }

    public String getComment_count() {
        return comment_count;
    }

    public String getUps() {
        return ups;
    }

    public String getDowns() {
        return downs;
    }

    public String getPoints() {
        return points;
    }

    public int getScore() {
        return score;
    }

    public boolean is_album() {
        return is_album;
    }


    public Uri showImage(){
        Uri uri = Uri.parse(link);

        return uri;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeLong(datetime);
        parcel.writeString(type);
        parcel.writeInt(width);
        parcel.writeInt(height);
        parcel.writeInt(size);
        parcel.writeInt(views);
        parcel.writeLong(bandwidth);
        parcel.writeString(vote);
        parcel.writeString(section);
        parcel.writeString(account_url);
        parcel.writeString(account_id);
        parcel.writeString(link);
        parcel.writeString(comment_count);
        parcel.writeString(ups);
        parcel.writeString(downs);
        parcel.writeString(points);
        parcel.writeInt(score);
        parcel.writeByte((byte) (animated ? 1 : 0));
        parcel.writeByte((byte) (favorite ? 1 : 0));
        parcel.writeByte((byte) (nsfw ? 1 : 0));
        parcel.writeByte((byte) (in_gallery ? 1 : 0));
        parcel.writeByte((byte) (is_ad ? 1 : 0));
        parcel.writeByte((byte) (is_album ? 1 : 0));

    }
}
