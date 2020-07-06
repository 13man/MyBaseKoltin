package com.taichi.myjavaapp.imageloader;

import android.widget.ImageView;

/**
 * @author hjz
 * 这里是图片加载配置信息的基类，定义一些所有图片加载框架都可以用的通用参数
 *
 */
public class ImageConfig {
    protected  String  url;
    protected ImageView imageView;
    /**
     * 错误占位符
     */
    protected  int  placeholder;
    /**
     * 错误占位符
     */
    protected  int errorPic;

    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public int getErrorPic() {
        return errorPic;
    }

}
