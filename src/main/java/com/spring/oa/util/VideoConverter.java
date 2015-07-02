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
    /*添加视频到队列*/
    public void add(Video v){
        queue.offer(v);
    }
    /*停止转码*/
    public void stopConvertJob(){
        stopFlag=true;
    }
    /*开始转码*/
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
        /*得到待转码视频的完整路径*/
        String oldFileFullName= Const.UPLOAD_REAL_PATH+filename;
        /*转码得到的avi文件*/
        String aviFileFullName=oldFileFullName+".avi";
        /*转码得到的flv文件*/
        String flvFileFullName=oldFileFullName+".flv";
        /*转码得到的截图文件的完整路径*/
        String picFileFullName=oldFileFullName+".jpg";
        File oldFile=new File(oldFileFullName);
        File aviFile=new File(aviFileFullName);
        /*拼接mencoder转码命令*/
        StringBuffer cmd=new StringBuffer(Const.MENCODER_EXE);
        cmd.append(" ");
        cmd.append(oldFileFullName);
        cmd.append(" -oac mp3lame -lameopts preset=64 -ovc xvid -xvidencopts bitrate=600 -of avi -o ");
        cmd.append(flvFileFullName);
        cmd.append("\r\n");
        /*拼接ffmpeg截图命令*/
        cmd.append(Const.FFMPEG_EXE);
        cmd.append("-i");
        cmd.append(flvFileFullName);
        /*视频播放时长的中间处截图*/
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
            System.out.println("转码开始");
            /*调用本地cmd命令执行批处理文件*/
            Runtime runtime= Runtime.getRuntime();
            Process process=runtime.exec("cmd.exe /C start"+batchFile.getAbsolutePath());
            /*下面的代码主要使得proc与当前线程同步，与转码业务无关*/
            InputStream stream1=process.getErrorStream();
            InputStreamReader inputStreamReader=new InputStreamReader(stream1);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while (bufferedReader.readLine()!=null){
            }
            process.waitFor();
            bufferedReader.close();
            batchFile.delete();
            System.out.println("转码完毕");
        } catch (IOException e) {
            System.out.println("文件读写失败");
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






















