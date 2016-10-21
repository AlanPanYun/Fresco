package alanpan.gbi.com.frescodemo.rxjava;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import alanpan.gbi.com.frescodemo.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by alan.pan on 2016/10/20.
 */
public class RxJavaDemo {


    public static void demo1() {

        Action0 action0 = new Action0() {
            @Override
            public void call() {

            }
        };

        final String string = "fj;a";

        String[] strings = new String[]{"aa", "bb", "cc"};
        Observable
                .from(strings)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                        Log.i("alan", "rxjava  " + s);
                    }
                });

//        Observable
//                .from(strings)
//                .flatMap(new Func1<String, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(String s) {
//                        return null;
//                    }
//                })
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
//                        return null;
//                    }
//                })
//                .map(new Func1<String, Bitmap>() {
//                    @Override
//                    public Bitmap call(String s) {
//                        return null;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Bitmap>() {
//                    @Override
//                    public void call(Bitmap bitmap) {
//
//                    }
//                });
    }

    public static void byId(final Activity context) {
        final int drawableRes = R.drawable.default_avatar;

        final ImageView imageView = new ImageView(context);
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = context.getTheme().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onNext(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void returbList(final Context context) {
        Observable
                .from(new String[]{"url1", "url2"})
                .create(new Observable.OnSubscribe<ArrayList<Bitmap>>() {
                    @Override
                    public void call(Subscriber<? super ArrayList<Bitmap>> subscriber) {
                        ArrayList<Bitmap> drawables = new ArrayList<>();
                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_avatar);
                        drawables.add(bitmap);
                        subscriber.onNext(drawables);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<ArrayList<Bitmap>>() {
                    @Override
                    public void call(ArrayList<Bitmap> drawables) {
                        Log.i("alan", "bitmaps ---" + drawables);
                    }
                });
    }

    public static void flatMap() {

        String[] strings = new String[]{};

        Observable
                .from(strings)
                .flatMap(new Func1<String, Observable<Bitmap>>() {
                    @Override
                    public Observable<Bitmap> call(String s) {
                        return Observable.from(new Bitmap[]{BitmapFactory.decodeFile(s)});
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bitmap bitmap) {

                    }
                });
    }

}
