package com.spring.oa.action;

import com.opensymphony.xwork2.ActionContext;
import com.spring.oa.domain.User;
import com.spring.oa.service.ChannelService;
import com.spring.oa.service.VideoService;
import com.spring.oa.util.Const;
import com.spring.oa.util.SessionUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by burning-.- on 2015/6/27.
 */
@SuppressWarnings("serial")
@Controller
public class UploadAction extends BaseAction{
    @Resource
    private ChannelService channelService;
    @Resource
    private VideoService videoService;

    private int userId;
    private File video;
    private String videoFileName;
    private String title;
    private String description;
    private int channelId;
    private String tags;

    public String init() {
        ActionContext.getContext().put("all_channels",channelService);
        return "upload";
    }
    public String upload()throws Exception{
       if(video.length()> Const.MAX_UPLOAD_FILE) {
           throw new Exception("文件超过了 "+ Const.MAX_UPLOAD_FILE/1024/1024+"兆 ");
       }
        User user=new SessionUtils().getUserFormSession(request);
        videoService.addVideo(user,channelId,title,tags,description,video,videoFileName);
        return "upload_success";
    }
}
