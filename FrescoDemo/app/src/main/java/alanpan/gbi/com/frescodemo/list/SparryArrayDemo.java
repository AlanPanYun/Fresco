package alanpan.gbi.com.frescodemo.list;

import android.util.SparseArray;

import java.util.HashMap;

/**
 * Created by alan.pan on 2016/10/20.
 */
public class SparryArrayDemo {

    public static void initSparry(){
        SparseArray<String> stringSparseArray = new SparseArray<>();
        stringSparseArray.append(1,"fadfa");
        stringSparseArray.get(5);

        for (int i = 0; i < 5; i++) {
            stringSparseArray.append();
        }
        int i = stringSparseArray.keyAt(4);

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("jaf","jjf");

    }


}
