package alanpan.gbi.com.frescodemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String URI_ONE = "https://test.reframehealth.com/UploadedAvatar/Small/2016/201607/20160727/8cc5167d-9d85-4df3-bbad-9dc40deabf19.png";
    public static final String URI_TWO = "https://test.reframehealth.com/UploadedAvatar/Small/2016/201609/20160901/fbb2eea8-f6b6-4fb0-94a9-382d6b02a5a0.png";

    public String uriStr;
    private SimpleDraweeView sd;
    private Picasso sPicasso;
    private ImageView picasssoView;

    @BindView(R.id.btn_rx_java) Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Drawable> backgroundList = null;
        List<Drawable> overlaysList = null;
        GenericDraweeHierarchyBuilder b =
                new GenericDraweeHierarchyBuilder(getResources());


        GenericDraweeHierarchy hierarchy = b
                .setFadeDuration(300)
                .setPlaceholderImage(R.drawable.default_avatar)
                .setBackgrounds(backgroundList)
                .setOverlays(overlaysList)
                .build();
        hierarchy.setProgressBarImage(new ProgressBarDrawable());
//        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER);

        sd = (SimpleDraweeView) findViewById(R.id.simple_drawee_view);
//        sd.setHierarchy(hierarchy);

        picasssoView = (ImageView) findViewById(R.id.imageview_picasso);

        Button btnOne = (Button) findViewById(R.id.btn_one);
        Button btnTwo = (Button) findViewById(R.id.btn_two);


        Button btnOnePic = (Button) findViewById(R.id.btn_one_picasso);
        Button btnTwoPic = (Button) findViewById(R.id.btn_two_picasso);

        Button skip_picasso = (Button) findViewById(R.id.skip_picasso);
        Button skip_fresso = (Button) findViewById(R.id.skip_fresso);


        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnOnePic.setOnClickListener(this);
        btnTwoPic.setOnClickListener(this);
        skip_fresso.setOnClickListener(this);
        skip_picasso.setOnClickListener(this);

        Picasso.Builder builder = new Picasso.Builder(this);
        sPicasso = builder.build();

    }

    private void initAnima() {
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (anim != null) {
                    // 其他控制逻辑
                    anim.start();
                }
            }
        };

        Uri uri = null;
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setControllerListener(controllerListener)
                // 其他设置（如果有的话）
                .build();
        sd.setController(controller);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                uriStr = URI_ONE;
                Uri uri = Uri.parse(uriStr);
                sd.setImageURI(uri);
                break;
            case R.id.btn_two:
                uriStr = URI_TWO;
                sd.setImageURI(Uri.parse(URI_TWO));
                break;
            case R.id.btn_one_picasso:
                sPicasso.load(URI_ONE)
                    .fit()
                    .centerCrop()
                    .config(Bitmap.Config.RGB_565)
                    .into(picasssoView);
                break;
            case R.id.btn_two_picasso:
                sPicasso.load(URI_TWO)
                        .fit()
                        .placeholder(R.drawable.icon_add_selected)
                        .error(R.drawable.icon_add_normal)
                        .centerCrop()
                        .config(Bitmap.Config.RGB_565)
                        .into(picasssoView);
                break;
            case R.id.skip_picasso:

                Intent intent = new Intent(this,PicassoActivity.class);
                startActivity(intent);

                break;
            case R.id.skip_fresso:

                Intent i = new Intent(this,FrescoActivity.class);
                startActivity(i);
                break;
        }




    }
}
