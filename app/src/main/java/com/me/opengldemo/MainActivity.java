package com.me.opengldemo;

import androidx.appcompat.app.AppCompatActivity;

import com.me.opengldemo.tringle.RendererJNI;


import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

import static android.opengl.GLSurfaceView.RENDERMODE_WHEN_DIRTY;

public class MainActivity extends AppCompatActivity {

    private final int CONTEXT_CLIENT_VERSION = 3;
    private GLSurfaceView mGLSurfaceView;
    RendererJNI mRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLSurfaceView = new GLSurfaceView(this);
        mRenderer= new RendererJNI(this);
        if (detectOpenGLES20()) {
            // 设置OpenGl ES的版本
            mGLSurfaceView.setEGLContextClientVersion(CONTEXT_CLIENT_VERSION);
            // 设置与当前GLSurfaceView绑定的Renderer
            mGLSurfaceView.setRenderer(mRenderer);
            // 设置渲染的模式
            mGLSurfaceView.setRenderMode(RENDERMODE_WHEN_DIRTY);
        } else {
            Log.e("opengles30", "OpenGL ES 3.0 not supported on device.  Exiting...");
            finish();
        }

        setContentView(mGLSurfaceView);

        //setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    private boolean detectOpenGLES20() {
        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo info = am.getDeviceConfigurationInfo();

        return (info.reqGlEsVersion >= 0x20000);
    }
}
