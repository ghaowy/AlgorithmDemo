package com.imprexion.source;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * @author : gongh
 * @date : 2020/8/19 9:22
 * @desc : TODO
 */
class GlideSource extends AppCompatActivity {

    public void setViewDrawable(Context context, ImageView view) {
        String uri = "wahaha";
        ViewTarget<ImageView, Drawable> into = Glide.with(context).load(uri).into(view);
    }
}
