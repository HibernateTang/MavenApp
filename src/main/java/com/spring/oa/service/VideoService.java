package com.spring.oa.service;

import com.spring.oa.domain.Comment;
import com.spring.oa.domain.User;
import com.spring.oa.domain.Video;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface VideoService {
    public void addVideo(User user, int channelId, String title, String tags, String description, File videoFile, String filenameOnClient) throws Exception;
    public void updateVideoOnPlay(Video video);
    public Video findVideo(Serializable id);
    public List<Comment> findComments(Video video);
    public void updateVideoOnDing(Video video);
    public void addComment(Comment comment, Video video);
    public List<Comment> findComment(Video video);
}
