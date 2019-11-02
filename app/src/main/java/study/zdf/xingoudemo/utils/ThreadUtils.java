package study.zdf.xingoudemo.utils;


import android.os.Handler;
import android.os.Looper;

/**
 * @author ZhengDeFeng
 * @description:运行在主线程util类
 * @date :2019/11/2 10:31
 */
public class ThreadUtils {
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    /**
     * 让子线程方法运行在指定线程
     * @param runnable 需要运行在主线程的线程
     */
    public static void runOnMainThread(Runnable runnable) {
        mHandler.post(runnable);
    }
}
