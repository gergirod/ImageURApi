package app.android.girod.imageur.data.model;

/**
 * Created by germangirod on 8/30/16.
 */
public class Image {

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
}
