package zebra.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.github.siyamed.shapeimageview.CircularImageView;

import example.zxing.R;
import zebra.beans.ReviewItem;
import zebra.manager.MemberManager;

/**
 * Created by multimedia on 2016-05-13.
 */
public class ReviewItemView extends FrameLayout{
    ImageView profileImage;
    TextView memberEmail;
    RatingBar ratingBar;
    TextView reviewText;

    public ReviewItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.review_item, this);

        profileImage = (ImageView) findViewById(R.id.profileImage);
        memberEmail = (TextView)findViewById(R.id.memberEmail);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        reviewText = (TextView)findViewById(R.id.reviewText);
    }

    public void setViewItem(ReviewItem item) {
        Glide.with(getContext()).load(item.profileImage).asBitmap().centerCrop().into(new BitmapImageViewTarget(profileImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                profileImage.setImageDrawable(circularBitmapDrawable);
            }
        });
        memberEmail.setText(item.memberEmail);
        ratingBar.setRating((float)item.ratingBar);
        reviewText.setText(item.reviewText);
    }
}
