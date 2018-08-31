package com.ast.blcheung.fakeneteaseuidemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Created by BLCheung
 * @email 925306022@qq.com
 * @date Created on 2018/8/27 16:10
 */
public class ToastUtil {
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
