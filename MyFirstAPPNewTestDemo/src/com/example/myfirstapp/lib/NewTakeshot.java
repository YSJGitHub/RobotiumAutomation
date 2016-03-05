package com.example.myfirstapp.lib;
/**
 * 因为Solo的截屏方法会默认保存在sd卡中，但是有些手机没有sd卡
 * 用于封装截屏和保存截屏图片方法的类，将图片存储到自定义的路径中
 * 图片路径如果是存储在/data/data路径下，需要再adb shell中执行命令:chmod 777 /data/data来改变目录的操作权限
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import android.app.Activity;
import android.graphics.Rect;
import java.io.FileOutputStream;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

@SuppressWarnings("deprecation")
public class NewTakeshot 
{
    public static boolean shoot(Activity a, String absolutepath) 
    {
    	return NewTakeshot.savePic(NewTakeshot.takeScreenShot(a), absolutepath);
    }
    
    
    // 保存到目录
    private static boolean savePic(Bitmap b, String strFileName) 
    {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            if (null != fos) 
            {
            	if(strFileName.endsWith(".png"))
            	{
            		b.compress(Bitmap.CompressFormat.PNG, 90, fos);
            	}
            	else
            	{
            		b.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            	}
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) 
        {
            return false;
        } catch (IOException e) 
        {
            return false;
        }
        return true;
    }
    
    
	 // 获取指定Activity的截屏，保存到png文件
    private static Bitmap takeScreenShot(Activity activity) 
    {
    	 // View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i("TAG", "" + statusBarHeight);

        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
		int height = activity.getWindowManager().getDefaultDisplay().getHeight();
		// 去掉状态栏
        // Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

  

    
}

