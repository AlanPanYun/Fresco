package alanpan.gbi.com.frescodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alan.pan on 2016/9/20.
 */
public class FrescoActivity extends AppCompatActivity implements View.OnClickListener {

    private int size = 10;
    private ArrayList<String> uris = new ArrayList<>();
    private FrescoListAdapter listAdapter;
    private RecyclerView recyclerView;
    private TextView membersize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_list);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        TextView add = (TextView) findViewById(R.id.add);
        membersize = (TextView) findViewById(R.id.membersize);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        add.setOnClickListener(this);


        long l = Runtime.getRuntime().freeMemory();
        membersize.setText("membersize  "+l);
        initList(size);
        setAdapter();


    }

    private void initList(int size) {
        for (int i = 0; i < size; i++) {
            uris.add(MainActivity.URI_TWO);
        }


    }
    private void setAdapter(){
        listAdapter = new FrescoListAdapter(this, uris);
        recyclerView.setAdapter(listAdapter);
    }

    private void notifyAdapter(){
        if (listAdapter != null){
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        size += 10;
        initList(size);
        notifyAdapter();
        long l = Runtime.getRuntime().freeMemory();
        membersize.setText("membersize  "+l);
    }
}
