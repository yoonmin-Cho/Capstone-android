package zebra.beans;

/**
 * Created by multimedia on 2016-05-29.
 */
public class MyReviewItem {

    public String productImage;
    public String memberEmail;
    public double ratingBar;
    public String reviewText;

    public MyReviewItem(String productImage, String memberEmail, double ratingBar, String reviewText){
        this.productImage = productImage;
        this.memberEmail = memberEmail;
        this.ratingBar = ratingBar;
        this.reviewText = reviewText;
    }

}
