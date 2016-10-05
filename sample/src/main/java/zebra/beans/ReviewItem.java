package zebra.beans;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewItem {
    public String profileImage;
    public String memberEmail;
    public double ratingBar;
    public String reviewText;


    public ReviewItem(String profileImage, String memberEmail, double ratingBar, String reviewText){
        this.profileImage = profileImage;
        this.memberEmail = memberEmail;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }
}
