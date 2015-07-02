package com.spring.oa.action;

import com.opensymphony.xwork2.ActionContext;
import com.spring.oa.domain.Comment;
import com.spring.oa.domain.User;
import com.spring.oa.domain.Video;
import com.spring.oa.service.VideoService;
import com.spring.oa.util.SessionUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by burning-.- on 2015/6/29.
 */
@SuppressWarnings("serial")
@Controller
public class PlayerAction extends BaseAction{
    @Resource
    private VideoService videoService;
    private int videoId;
    private String commentContent;
    public String init(){
    Video video=videoService.findVideo(videoId);//****
        if(video==null){
            return "player_error";
        }
        List<Comment> comments=videoService.findComments(video);
        videoService.updateVideoOnPlay(video);
        ActionContext.getContext().put("video", video);
        ActionContext.getContext().put("comments",comments);
        return "player";
    }
    public String ding(){
        Video video=videoService.findVideo(videoId);
        if(video==null){
            return "player_error";
        }
        videoService.updateVideoOnDing(video);//*******
        ActionContext.getContext().put("video",video);
        return "player";
    }
    public String comment(){
        User user= SessionUtils.getUserFormSession(request);
        Video video=videoService.findVideo(videoId);
        if(video==null){
            return "player_error";
        }
        /*构造评论*/
        Comment comment=new Comment();
//        comment.setUser(user);
//        comment.setVideo(video);
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        videoService.addComment(comment, video);
        /*重新获得评论*/
        List<Comment> comments=videoService.findComment(video);
        ActionContext.getContext().put("video",video);
        ActionContext.getContext().put("comments",comments);
        return "player";
    }
}
