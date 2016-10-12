package alanpan.gbi.com.frescodemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alan.pan on 2016/9/20.
 */
public class FrescoListAdapter extends RecyclerView.Adapter<FrescoListViewHolder> {

    private ArrayList<String> uris;
    private Activity activity;

    public FrescoListAdapter(Activity activity, ArrayList<String> uris) {
        this.uris = uris;
        this.activity = activity;
    }

    @Override
    public FrescoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FrescoListViewHolder(
                LayoutInflater.from(activity).inflate(
                        R.layout.fresco_item,
                        null
                )
        );
    }

    @Override
    public void onBindViewHolder(FrescoListViewHolder holder, int position) {
        holder.updateView(uris.get(position),position);
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }
}
