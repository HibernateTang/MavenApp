package com.spring.oa.util;

/**
 * Created by burning-.- on 2015/6/25.
 */
public class Const {
    /*��ʾsession�е���֤��*/
    public static final String KEY_VERIFICAITON_CODE="verification_code";
    /*��ʶsession�еĵ�½�û�����*/
    public static final String KEY_LOGINED_USER="logined_user";
    /*ע��ʱĬ�ϵ��û�ͷ���id*/
    public static final int DEFAULT_CHANNEL_ID=1;
    /*config���д���"Ĭ�ϵ��û�ͷ��id"�������������*/
    public static final String CONFIG_NAME_DEFAULT_FACE_ID="default_dace_id";
    /*�����Ƶ����ͼ�ļ����ļ���*/
    public static final String UPLOAD_FOLDER="video";
    /*upload_folder�ľ���·��*/
    public static String UPLOAD_REAL_PATH;
    /*�ϴ��ļ��Ĵ�С��200M��*/
    public static final long MAX_UPLOAD_FILE=1024*1024*1024;
    /*��Ƶ״̬*/
    public static final String VIDEO_STATUS_UPLOADED="U";//���ϴ�
    public static final String VIDEO_STATUS_CONVERTED="C";//��ת��
    public static final String VIDEO_STATUS_APPROVED="A";//�����
    /*ת�빤��*/
    public static final String MENCODER_EXE="C://mplayer/mencode.exe";
    public static final String FFMPEG_EXE="C://mplayer/ffmpeg.exe";
    /*��������ĳ���*/
    public static final String ODER_ASC="asc";
    public static final String ODER_DESC="desc";
    /*����Ƶ����ʱ���ڵ��ֶ�����*/
    public static final String [] VIDEO_ORDER_FILEDS={"uploadTime","playCount","commentCount","goodComment"};
    /*���ڷ�ҳ�ĳ���*/
    public static final int VIDEO_SIZE_PER_PAGE=10;
    public static final int PAGE_BUTTON_SIZE_PER_PAGE=10;
}

