package com.luck.picture.lib.useMain;

import android.app.Activity;
import android.content.Intent;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

public class MediaChooseUtil {
    static MediaChooseUtil util;
    static int styleRes= R.style.myPhotoChooseThem;
    private MediaChooseUtil(){

    }

    public static MediaChooseUtil getInstance(int customerStyleRes){
        styleRes=customerStyleRes;
        if(util==null){
            util=new MediaChooseUtil();
        }
        return util;
    }

    public static MediaChooseUtil getInstance(){
        if(util==null){
            util=new MediaChooseUtil();
        }
        return util;
    }

    /**
     * 选择单张图片，（可选）支持拍照
     * @param ac
     * @param isNeedTakePhoto 是否支持拍照
     * @param isCompress 是否压缩
     */
    public  void choosePhotoSingle(Activity ac, boolean isNeedTakePhoto, boolean isCompress){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(ac)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(isNeedTakePhoto)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.JPEG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/DyPhotos")// 自定义拍照保存路径,可不填
                .compress(isCompress)// 是否压缩 true or false
                .theme(styleRes)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    /**
     * 选择多张图片，（可选）支持拍照
     * @param ac
     * @param isNeedTakePhoto 是否支持拍照
     * @param isCompress 是否压缩
     */
    public  void choosePhotoMuilt(Activity ac,int maxNum,boolean isNeedTakePhoto,boolean isCompress){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(ac)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(maxNum)
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(isNeedTakePhoto)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.JPEG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/DyPhotos")// 自定义拍照保存路径,可不填
                .compress(isCompress)// 是否压缩 true or false
                .theme(styleRes)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }



    /**
     * 选择单个视频
     * @param ac
     * @param isCompress 是否压缩
     */
    public  void chooseVideoSingle(Activity ac,boolean isCompress){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(ac)
                .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewVideo(true)// 是否可预览视频 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/DyPhotos")// 自定义拍照保存路径,可不填
                .compress(isCompress)// 是否压缩 true or false
                .theme(styleRes)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    /**
     * 选择多个视频，（可选）是否压缩
     * @param ac
     * @param isCompress 是否压缩
     */
    public  void chooseVideoMuilt(Activity ac,int maxNum,boolean isCompress){
        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(ac)
                .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(maxNum)
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewVideo(true)// 是否可预览视频 true or false
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/DyPhotos")// 自定义拍照保存路径,可不填
                .compress(isCompress)// 是否压缩 true or false
                .theme(styleRes)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    public  void openCamera(Activity ac,boolean isCompress){
        PictureSelector.create(ac)
                .openCamera(PictureMimeType.ofImage())
                .compress(isCompress)
                .theme(styleRes)
                .forResult(PictureConfig.REQUEST_CAMERA);
    }


    public  void openVideoCamera(Activity ac,boolean isCompress){
        PictureSelector.create(ac)
                .openCamera(PictureMimeType.ofVideo())
                .compress(isCompress)
                .theme(styleRes)
                .forResult(PictureConfig.REQUEST_CAMERA);
    }


    public  void previewPhotos(Activity ac, int position, List<LocalMedia> selectList){
        PictureSelector.create(ac).themeStyle(styleRes).openExternalPreview(position, selectList);
    }


    public void onActivityResultDealWithMedia(int requestCode, int resultCode, Intent data,OnMediaListInfoGetListener onMediaListInfoGetListener){
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频选择回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    MediaListInfo listInfo = new MediaListInfo();
                    if (selectList != null) {
                        listInfo.getMedias().addAll(selectList);
                    }
                    listInfo.setRequestCode(PictureConfig.CHOOSE_REQUEST);
                    if (onMediaListInfoGetListener != null) {
                        onMediaListInfoGetListener.onPhotoVideoMediaGet(listInfo);
                    }
                    break;
                case PictureConfig.REQUEST_CAMERA:
                    // 图片、视频拍摄回调
                    List<LocalMedia> cselectList = PictureSelector.obtainMultipleResult(data);
                    MediaListInfo listInfo2 = new MediaListInfo();
                    if (cselectList != null) {
                        listInfo2.getMedias().addAll(cselectList);
                    }
                    listInfo2.setRequestCode(PictureConfig.REQUEST_CAMERA);
                    if (onMediaListInfoGetListener != null) {
                        onMediaListInfoGetListener.onShotMediaGet(listInfo2);
                    }
                    break;
            }
        }
    }



    public interface OnMediaListInfoGetListener {
        //普通图片和媒体回调
        void onPhotoVideoMediaGet(MediaListInfo listInfo);
        //拍摄的媒体的回调
        void onShotMediaGet(MediaListInfo listInfo);
    }

}
