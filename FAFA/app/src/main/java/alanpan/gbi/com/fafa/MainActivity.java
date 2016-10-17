package alanpan.gbi.com.fafa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import alanpan.gbi.com.nexuslibrary.TestActivty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s = TestActivty.justTest();
    }
}
