package alanpan.gbi.com.frescodemo;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

/**
 * Created by alan.pan on 2016/9/20.
 */
public class PicassoListViewHolder extends RecyclerView.ViewHolder {


    private final ImageView sd;
    private Picasso sPicasso;

    public PicassoListViewHolder(View itemView, Picasso sPicasso) {
        super(itemView);
        this.sPicasso = sPicasso;

        sd = (ImageView) itemView.findViewById(R.id.imageview);
    }

    public void updateView(String uri,int position){
        sPicasso.load(uri)
                .fit()
                .placeholder(R.drawable.icon_add_selected)
                .error(R.drawable.icon_add_normal)
                .centerCrop()
                .config(Bitmap.Config.RGB_565)
                .into(sd);
    }

}
