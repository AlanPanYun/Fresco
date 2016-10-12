package alanpan.gbi.com.frescodemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

/**
 * Created by alan.pan on 2016/9/20.
 */
public class FrescoListViewHolder extends RecyclerView.ViewHolder {


    private final SimpleDraweeView sd;
    private Picasso sPicasso;

    public FrescoListViewHolder(View itemView) {
        super(itemView);
        this.sPicasso = sPicasso;
        sd = (SimpleDraweeView) itemView.findViewById(R.id.simple_drawee_view);
    }

    public void updateView(String uri, int position) {
        sd.setImageURI(uri);
    }

}
