package alanpan.gbi.com.frescodemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by alan.pan on 2016/9/28.
 */
public class JSActivity extends AppCompatActivity {

    private static final String LOGTAG = "MainActivity";

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        final WebView myWebView = (WebView) findViewById(R.id.web_view);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new JsInteration(), "control");
        myWebView.setWebChromeClient(new WebChromeClient() {
        });
        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                testMethod(myWebView);
            }
        });

        myWebView.evaluateJavascript("", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {

            }
        });
        myWebView.loadUrl("file:///C:/Users/alan.pan/Desktop/Alan/android_js.html");
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void testMethod(WebView webView) {
        String call = "javascript:sayHello()";
        call = "javascript:alertMessage(\"" + "content" + "\")";
        call = "javascript:toastMessage(\"" + "content" + "\")";
        call = "javascript:sumToJava(1,2)";
        webView.loadUrl(call);
    }

    public class JsInteration {
        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface
        public void onSumResult(int result) {
            Log.i(LOGTAG, "onSumResult result=" + result);
        }
    }

}
