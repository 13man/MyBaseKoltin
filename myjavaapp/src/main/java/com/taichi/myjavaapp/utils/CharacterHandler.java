package com.taichi.myjavaapp.utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

/**
 * 字符串管理类
 *
 * @author hjz
 */
public class CharacterHandler {

    public   static   final InputFilter EMOJI_FILTER =new InputFilter() {
       Pattern emoji = Pattern.compile(
               "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
               Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE
       );


        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {



            return null;
        }
    };

}
