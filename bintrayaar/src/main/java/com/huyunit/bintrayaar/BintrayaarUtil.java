package com.huyunit.bintrayaar;

import android.text.TextUtils;
import android.util.Log;

/**
 * 打印log日志信息
 *
 * Created by bobo on 2016/9/13.
 */
public class BintrayaarUtil {
    //是否需要打印Log日志信息
    public static boolean isDebug = true;
    public static String customTagPrefix = "Debug";
    private static final int MAX_LENGTH = 8000;
    private static final String EMPTY = "====>Empty<====";

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (!isDebug) return;
        String tag = generateTag();
        if (TextUtils.isEmpty(content)) content = EMPTY;
        if (content.length() > MAX_LENGTH) {
            d(content.substring(0, content.length() / 2));
            d(content.substring(content.length() / 2, content.length()));
        } else {
            Log.d(tag, content);
        }
    }

    public static void d(String content, Throwable tr) {
        if (!isDebug) return;
        String tag = generateTag();
        if (TextUtils.isEmpty(content)) content = EMPTY;
        if (content.length() > MAX_LENGTH) {
            d(content.substring(0, content.length() / 2), tr);
            d(content.substring(content.length() / 2, content.length()), tr);
        } else {
            Log.d(tag, content, tr);
        }
    }

    public static void e(String content) {
        if (!isDebug) return;
        String tag = generateTag();
        if (TextUtils.isEmpty(content)) content = EMPTY;
        if (content.length() > MAX_LENGTH) {
            e(content.substring(0, content.length() / 2));
            e(content.substring(content.length() / 2, content.length()));
        } else {
            Log.e(tag, content);
        }
    }

    public static void e(String content, Throwable tr) {
        if (!isDebug) return;
        String tag = generateTag();
        if (TextUtils.isEmpty(content)) content = EMPTY;
        if (content.length() > MAX_LENGTH) {
            e(content.substring(0, content.length() / 2), tr);
            e(content.substring(content.length() / 2, content.length()), tr);
        } else {
            Log.e(tag, content, tr);
        }
    }

}
