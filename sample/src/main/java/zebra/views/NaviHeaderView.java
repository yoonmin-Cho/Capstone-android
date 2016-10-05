package zebra.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import example.zxing.R;
import zebra.manager.MemberManager;

/**
 * Created by multimedia on 2016-05-18.
 */
public class NaviHeaderView extends FrameLayout {

    ImageView profileImage;
    TextView name;
    String appUserName;

    public NaviHeaderView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.navi_header, this);

        profileImage = (ImageView)findViewById(R.id.profileImage);
        name = (TextView)findViewById(R.id.name);

        profileImage.setImageResource(R.drawable.bang);
        name.setText("임인혁님 반갑습니다.");
    }

    public void setLoginStatus(){
        if(MemberManager.getInstance().getIsLogin()){
            appUserName = MemberManager.getInstance().getName();
            name.setText(appUserName + "님 반갑습니다.");

            Glide.with(getContext()).load(MemberManager.getInstance().getMemberUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(profileImage) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    profileImage.setImageDrawable(circularBitmapDrawable);
                }
            });
        }
        else{
            profileImage.setImageResource(R.drawable.zebra_icon);
            name.setText("로그인 부탁드립니다.");
        }
    }
}
