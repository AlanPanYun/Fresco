package alanpan.gbi.com.frescodemo.image_manage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alan.pan on 2016/10/12.
 */
public class ImageCompressUtils {

    /**
     * @param imgPath image path
     * @param pixelW  target pixel of width
     * @param pixelH  target pixel of height
     */
    public static Bitmap compressWithSize(String imgPath, float pixelW, float pixelH) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把optins.inJustDecodeBounds 设置为true，即读边不读内容
        newOpts.inJustDecodeBounds = true;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        //Get bitmap info,but notice that bitmap is bull now
        Bitmap bitmap = BitmapFactory.decodeFile(imgPath, newOpts);

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;

        // 想要缩放的目标尺寸
        float hh = pixelW;
        float ww = pixelH;
        // 缩放比，由于是固定比缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;
        if (w > h && w > ww) {
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {
            be = (int) (h / hh);
        }
        if (be <= 0) {
            be = 1;
        }
        newOpts.inSampleSize = be; // 设置缩放比
        bitmap = BitmapFactory.decodeFile(imgPath, newOpts);
        return bitmap;

    }


    /**
     * @param image  image bitmap
     * @param pixelW target pixel of width
     * @param pixelH target pixel of height
     */
    public static Bitmap compressWithSize(Bitmap image, float pixelW, float pixelH) {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, os);
        if (os.toByteArray().length / 1024 > 1024) {
            os.reset();
            image.compress(Bitmap.CompressFormat.JPEG, 50, os);
        }

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        // 开始读入图片，此时把optins.inJustDecodeBounds 设置为true，即读边不读内容
        newOpts.inJustDecodeBounds = true;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        //Get bitmap info,but notice that bitmap is bull now

        Bitmap bitmap = BitmapFactory.decodeStream(is, null, newOpts);

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;

        // 想要缩放的目标尺寸
        float hh = pixelW;
        float ww = pixelH;
        // 缩放比，由于是固定比缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;
        if (w > h && w > ww) {
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {
            be = (int) (h / hh);
        }
        if (be <= 0) {
            be = 1;
        }
        newOpts.inSampleSize = be; // 设置缩放比
        bitmap = BitmapFactory.decodeStream(is, null, newOpts);
        return bitmap;

    }

    public static void compressWithQuality(Bitmap image, String outPath, int maxSize) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        image.compress(Bitmap.CompressFormat.JPEG,20,os);

        while (os.toByteArray().length / 1024 >1024 ){
            os.reset();
            image.compress(Bitmap.CompressFormat.JPEG,20,os);
        }

        FileOutputStream fi = new FileOutputStream(outPath);
        fi.write(os.toByteArray());
        fi.flush();
        fi.close();

    }

}
