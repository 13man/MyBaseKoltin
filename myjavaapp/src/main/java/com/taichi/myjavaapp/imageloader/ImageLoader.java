package com.taichi.myjavaapp.imageloader;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author hjz
 */
@Singleton
public class ImageLoader {

    @Inject
    @Nullable
    BaseImageLoaderStrategy mStrategy;

    @Inject
    public ImageLoader() {

    }

    /**
     * 加载图片
     *
     * @param context
     * @param config
     * @param <T>
     */
    @SuppressLint("RestrictedApi")
    public <T extends ImageConfig> void loadImage(Context context, T config) {
        Preconditions.checkNotNull(mStrategy, "Please implement BaseImageLoaderStrategy and call GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy) in the applyOptions method of ConfigModule");
        this.mStrategy.loadImage(context, config);
    }

    /**
     * 停止加载或者清理缓存
     * @param context
     * @param config
     * @param <T>
     */
    @SuppressLint("RestrictedApi")
    public  <T extends  ImageConfig> void  clear(Context context,T config){
        Preconditions.checkNotNull(mStrategy, "Please implement BaseImageLoaderStrategy and call GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy) in the applyOptions method of ConfigModule");

    }
    @Nullable
    public   BaseImageLoaderStrategy  getLoadImgStrategy(){
        return  mStrategy;
    }

    @SuppressLint("RestrictedApi")
    public  void   setLoadImgStrategy(BaseImageLoaderStrategy strategy){
        Preconditions.checkNotNull(strategy, "strategy == null");
        this.mStrategy = strategy;
    }

}
