package alanpan.gbi.com.frescodemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import alanpan.gbi.com.frescodemo.BaseCompatActivity;
import alanpan.gbi.com.frescodemo.R;

/**
 * Created by alan.pan on 2016/10/24.
 */
public class DataBindingActivity extends BaseCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final alanpan.gbi.com.frescodemo.databinding.ActivityDatabingdingBinding databingdingBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_databingding);
        databingdingBinding.setUser(new User("name", "user"));
//        databingdingBinding.getUser().getAge().set
        databingdingBinding.tvAge.setOnClickListener(this);

//        databingdingBinding.setClick(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()) {
//                    case R.id.tv_age:
//                        databingdingBinding.getUser().setAge("jjafa456");
//                        Toast.makeText(DataBindingActivity.this,"ahahahha",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_age:
                Toast.makeText(DataBindingActivity.this,"ahahahha",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

