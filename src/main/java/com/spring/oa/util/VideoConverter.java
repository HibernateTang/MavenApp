package com.spring.oa.util;


import com.spring.oa.dao.VideoDao;
import com.spring.oa.domain.Video;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by burning-.- on 2015/6/25.
 */
public class VideoConverter {
    private static boolean isRunning=false;
    private boolean stopFlag=false;
    private static Queue<Video> queue;
    private VideoDao videoDao;
    private static VideoConverter instance;
    static {
        instance=new VideoConverter();
        queue=new LinkedList<Video>();
    }
    private VideoConverter(){}
    public static VideoConverter getInstance(){
        return instance;
    }
    public VideoDao getVideoDao(){
        return videoDao;
    }
    public void setVideoDao(VideoDao videoDao){
        this.videoDao=videoDao;
    }
    /*�����Ƶ������*/
    public void add(Video v){
        queue.offer(v);
    }
    /*ֹͣת��*/
    public void stopConvertJob(){
        stopFlag=true;
    }
    /*��ʼת��*/
    public void startConverJob(){
       if(isRunning) {
           return;
       }
        new Thread(){
           @Override
            public void run(){
              while (!stopFlag){
                Video v=queue.peek();
                  if(v!=null){
                      convert(v);
                  }
                  try {
                      sleep(1000);
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
              }
           }
        }.start();
    }
    public void convert(Video v){
        String filename=v.getServerFileName();
        long duration=v.getDuration();
        /*�õ���ת����Ƶ������·��*/
        String oldFileFullName= Const.UPLOAD_REAL_PATH+filename;
        /*ת��õ���avi�ļ�*/
        String aviFileFullName=oldFileFullName+".avi";
        /*ת��õ���flv�ļ�*/
        String flvFileFullName=oldFileFullName+".flv";
        /*ת��õ��Ľ�ͼ�ļ�������·��*/
        String picFileFullName=oldFileFullName+".jpg";
        File oldFile=new File(oldFileFullName);
        File aviFile=new File(aviFileFullName);
        /*ƴ��mencoderת������*/
        StringBuffer cmd=new StringBuffer(Const.MENCODER_EXE);
        cmd.append(" ");
        cmd.append(oldFileFullName);
        cmd.append(" -oac mp3lame -lameopts preset=64 -ovc xvid -xvidencopts bitrate=600 -of avi -o ");
        cmd.append(flvFileFullName);
        cmd.append("\r\n");
        /*ƴ��ffmpeg��ͼ����*/
        cmd.append(Const.FFMPEG_EXE);
        cmd.append("-i");
        cmd.append(flvFileFullName);
        /*��Ƶ����ʱ�����м䴦��ͼ*/
        cmd.append(" -y -f image2 -ss + (duration/2)" + "-t 0.001 -s 120*90");
        cmd.append(picFileFullName);
        cmd.append("\r\n");
        cmd.append("exit");
        try{
            File batchFile=new File(Const.UPLOAD_REAL_PATH+"conver.bat");
            FileWriter fw=new FileWriter(batchFile);
            fw.write(cmd.toString());
            fw.flush();
            fw.close();
            System.out.println("ת�뿪ʼ");
            /*���ñ���cmd����ִ���������ļ�*/
            Runtime runtime= Runtime.getRuntime();
            Process process=runtime.exec("cmd.exe /C start"+batchFile.getAbsolutePath());
            /*����Ĵ�����Ҫʹ��proc�뵱ǰ�߳�ͬ������ת��ҵ���޹�*/
            InputStream stream1=process.getErrorStream();
            InputStreamReader inputStreamReader=new InputStreamReader(stream1);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while (bufferedReader.readLine()!=null){
            }
            process.waitFor();
            bufferedReader.close();
            batchFile.delete();
            System.out.println("ת�����");
        } catch (IOException e) {
            System.out.println("�ļ���дʧ��");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        oldFile.delete();
        aviFile.delete();
        queue.remove(v);
        v.setStatus(Const.VIDEO_STATUS_CONVERTED);
        videoDao.update(v);
    }
}






















