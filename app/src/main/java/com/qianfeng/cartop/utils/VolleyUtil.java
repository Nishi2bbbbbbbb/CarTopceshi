package com.qianfeng.cartop.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ken on 2015/11/21.
 */
public class VolleyUtil {

    public static RequestQueue requestQueue;
    public static LruCache<String, Bitmap> lruCache;

    public static void initVolley(Context context){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }

        lruCache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory()/8)){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }


    /**
     * 图片请求
     * @param url
     * @param iv
     * @param resid
     * @param errorresid
     */
    public static void requestImage(String url, ImageView iv, int resid, int errorresid){
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url, bitmap);
            }
        });

        imageLoader.get(url, ImageLoader.getImageListener(iv, resid, errorresid));
    }

    /**
     * 字符串请求
     * @param url
     * @param onRequest
     */
    public static void requestString(final String url, final OnRequest onRequest){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //下载成功
                onRequest.response(url, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //下载失败
                onRequest.errorResponse(url, error);
            }
        });

        requestQueue.add(stringRequest);
    }

    public interface OnRequest{
        void response(String url, String response);
        void errorResponse(String url, VolleyError error);
    }
}
