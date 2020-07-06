package com.taichi.myjavaapp.imageloader;

import android.content.Context;

import androidx.annotation.Nullable;


/**
 * 图片加载策略
 *
 * @author hjz
 */
public interface BaseImageLoaderStrategy<T extends ImageConfig> {

    /**
     * 加载图片
     *
     * @param context {@link Context}
     * @param config  图片加载配置信息
     */
    void loadImage(@Nullable Context context, @Nullable T config);


    /**
     * 图片加载
     *
     * @param context {@link  Context}
     * @param config  图片加载配置信息
     */
    void clear(@Nullable Context context, @Nullable T config);
}
