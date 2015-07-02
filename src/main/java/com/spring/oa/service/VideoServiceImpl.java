package com.spring.oa.service;

import com.spring.oa.dao.ChannelDao;
import com.spring.oa.dao.CommentDao;
import com.spring.oa.dao.UserDao;
import com.spring.oa.dao.VideoDao;
import com.spring.oa.domain.Comment;
import com.spring.oa.domain.User;
import com.spring.oa.domain.Video;
import com.spring.oa.util.Const;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.beans.Encoder;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by burning-.- on 2015/6/27.
 */
@Service
public class VideoServiceImpl implements VideoService{
    @Resource
    private ChannelDao channelDao;
    @Resource
    private VideoDao videoDao;
    @Resource
    private UserDao userDao;
    @Resource
    private CommentDao commentDao;

    public void addVideo(User user,int channelId,String title,String tags,String description,File videoFile,String fileNameOnClient)throws Exception{
       if(videoFile!=null) {
           long duration=0;
           Encoder encoder=new Encoder();
           /*MutimediaInfo*/
           /*随机产生一个UUID串，作为视频文件在服务端的名称*/
           String fileNameOnServer= UUID.randomUUID().toString();
           File fileOnServer=new File(Const.UPLOAD_REAL_PATH,fileNameOnServer);
           try {
               FileCopyUtils.copy(videoFile, fileOnServer);
           }catch (Exception e){
              throw new Exception("复制文件时发生错误");
           }
           Video video=new Video();
           /*需要在daoimpl中实现findById方法*/
//           video.setChannelId(ChannelDao.findById(channelId));
       }
    }

    public void updateVideoOnPlay(Video video) {
        video.setPlayCount(video.getPlayCount()+1);

//        User user=video.getUser(); //导致分层不清代码不好
        /*修改相应用户的视频播放总数*/
//        user.setTotalPlayCount(user.getTotalPlayCount()+1);
        videoDao.update(video);
//        userDao.update(user);
    }

    public Video findVideo(Serializable id) {
        return videoDao.findById(id);
    }

    public List<Comment> findComments(Video video) {
        Object []params=new Object[]{video};
        Map<String,String> orderBy=new LinkedHashMap<String, String>();
        orderBy.put("o.time", Const.ODER_DESC);
        return commentDao.findByCondition("and o.video=?",params,orderBy,false);
    }



    public void updateVideoOnDing(Video video){
        video.setGoodCommentCount(video.getGoodCommentCount() + 1);
        videoDao.update(video);
    }
    /*修改视频的差评次数*/
    public void updateVideoOnCai(Video video){
        video.setBadCommentCount(video.getBadCommentCount() + 1);
        videoDao.update(video);
    }
    /*获取视频的评论*/
    public List<Comment> findComment(Video video){
        Object [] params=new Object[]{video};
        Map<String ,String > orderBy=new LinkedHashMap<String, String>();
        orderBy.put("o.time", Const.ODER_DESC);
        return commentDao.findByCondition("and o.video=?",params,orderBy,false);
    }
    /*添加评论*/
    public void addComment(Comment comment,Video video){
        commentDao.save(comment);
        video.setCommentCount(video.getCommentCount() + 1);
        videoDao.update(video);
    }
}




















