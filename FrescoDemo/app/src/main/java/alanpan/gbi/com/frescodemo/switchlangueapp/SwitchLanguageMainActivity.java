package alanpan.gbi.com.frescodemo.switchlangueapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import alanpan.gbi.com.frescodemo.R;

public class SwitchLanguageMainActivity
        extends SwitchLanguageBaseActivity
        implements OnClickListener {

    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_language_activity_main);

        
        TextView textView = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.btn);
        Button button2 = (Button) findViewById(R.id.btn_2);
        textView.setText(R.string.hello_world);
        button.setText(R.string.switch_language);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mDialog == null) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.dialog_select_lanuage, null);
                    TextView english = (TextView) layout.findViewById(R.id.select_english);
                    TextView chinese = (TextView) layout.findViewById(R.id.select_chinese);
                    mDialog = new Dialog(SwitchLanguageMainActivity.this, R.style.Custom_Dialog_Theme);
                    mDialog.setCanceledOnTouchOutside(false);
                    english.setOnClickListener(SwitchLanguageMainActivity.this);
                    chinese.setOnClickListener(SwitchLanguageMainActivity.this);
                    mDialog.setContentView(layout);
                }
                mDialog.show();
            }
        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(SwitchLanguageMainActivity.this, SecondActivity.class);
                startActivity(it);
            }
        });
    }



    @Override
    public void onClick(View v) {
        mDialog.dismiss();
        switch (v.getId()) {
            case R.id.select_english:
                switchLanguage("en");
                break;
            case R.id.select_chinese:
                switchLanguage("zh");
                break;

            default:
                break;
        }
        //更新语言后，destroy当前页面，重新绘制
        finish();
        Intent it = new Intent(SwitchLanguageMainActivity.this, SwitchLanguageMainActivity.class);
        startActivity(it);
    }

}
