package yin.deng.dymediachooseutils;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.luck.picture.lib.useMain.MediaChooseUtil;
import com.luck.picture.lib.useMain.MediaListInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaChooseUtil.getInstance(R.style.myPhotoChooseThem).choosePhotoSingle(this,true,true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MediaChooseUtil.getInstance().onActivityResultDealWithMedia(requestCode, resultCode, data, new MediaChooseUtil.OnMediaListInfoGetListener() {
            @Override
            public void onPhotoVideoMediaGet(MediaListInfo listInfo) {
                Log.d("Dylog","获取到照片地址："+listInfo.getMedias().get(0).getCompressPath());
            }

            @Override
            public void onShotMediaGet(MediaListInfo listInfo) {
                Log.i("Dylog","获取到拍摄的照片地址："+listInfo.getMedias().get(0).getCompressPath());
            }
        });
    }
}
