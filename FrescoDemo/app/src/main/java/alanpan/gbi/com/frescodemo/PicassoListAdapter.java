package alanpan.gbi.com.frescodemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by alan.pan on 2016/9/20.
 */
public class PicassoListAdapter extends RecyclerView.Adapter<PicassoListViewHolder> {

    private ArrayList<String> uris;
    private Activity activity;
    private Picasso sPicasso;

    public PicassoListAdapter(Activity activity, ArrayList<String> uris,Picasso sPicasso) {
        this.uris = uris;
        this.activity = activity;
        this.sPicasso = sPicasso;
    }

    @Override
    public PicassoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PicassoListViewHolder(
                LayoutInflater.from(activity).inflate(
                        R.layout.picasso_item,
                        null
                ),
                sPicasso
        );
    }

    @Override
    public void onBindViewHolder(PicassoListViewHolder holder, int position) {
        holder.updateView(uris.get(position),position);
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }
}
