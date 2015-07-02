package com.spring.oa.util;

/**
 * Created by burning-.- on 2015/6/25.
 */
public class Const {
    /*标示session中的验证码*/
    public static final String KEY_VERIFICAITON_CODE="verification_code";
    /*标识session中的登陆用户对象*/
    public static final String KEY_LOGINED_USER="logined_user";
    /*注册时默认的用户头像的id*/
    public static final int DEFAULT_CHANNEL_ID=1;
    /*config表中代表"默认的用户头像id"的配置项的名称*/
    public static final String CONFIG_NAME_DEFAULT_FACE_ID="default_dace_id";
    /*存放视频及截图文件的文件夹*/
    public static final String UPLOAD_FOLDER="video";
    /*upload_folder的绝对路径*/
    public static String UPLOAD_REAL_PATH;
    /*上传文件的大小（200M）*/
    public static final long MAX_UPLOAD_FILE=1024*1024*1024;
    /*视频状态*/
    public static final String VIDEO_STATUS_UPLOADED="U";//已上传
    public static final String VIDEO_STATUS_CONVERTED="C";//已转码
    public static final String VIDEO_STATUS_APPROVED="A";//已审核
    /*转码工具*/
    public static final String MENCODER_EXE="C://mplayer/mencode.exe";
    public static final String FFMPEG_EXE="C://mplayer/ffmpeg.exe";
    /*用于排序的常量*/
    public static final String ODER_ASC="asc";
    public static final String ODER_DESC="desc";
    /*对视频排序时基于的字段名称*/
    public static final String [] VIDEO_ORDER_FILEDS={"uploadTime","playCount","commentCount","goodComment"};
    /*用于分页的常量*/
    public static final int VIDEO_SIZE_PER_PAGE=10;
    public static final int PAGE_BUTTON_SIZE_PER_PAGE=10;
}

