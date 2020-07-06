package com.taichi.myjavaapp.imageloader.glide;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

/**
 *  如果你想具有配置 @{@link Glide} 的权利,则需要让 {@link com.taichi.myjavaapp.imageloader.BaseImageLoaderStrategy}
 *  的实现类也必须实现 {@link GlideAppliesOptions}
 * @author hjz
 */
public interface GlideAppliesOptions {


    /**
     * 配置{@link Glide}  的自定义参数，此方法在{@link Glide} 初始化时执行(@{@link Glide} 在第一次被调用时初始化),只会执行一次
     * @param context
     * @param builder
     */
    void applyGlideOptions(@NonNull Context context, @NonNull GlideBuilder builder);

    /**
     * 注册{@link Glide}的组件 参考{@link com.bumptech.glide.module.LibraryGlideModule}
     * @param context
     * @param glide
     * @param registry
     */
    void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry);

}
