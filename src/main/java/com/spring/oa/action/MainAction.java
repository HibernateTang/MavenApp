package com.spring.oa.action;

import com.opensymphony.xwork2.ActionContext;
import com.spring.oa.dao.ChannelDao;
import com.spring.oa.dao.UserDao;
import com.spring.oa.dao.VideoDao;
import com.spring.oa.domain.Channel;
import com.spring.oa.domain.User;
import com.spring.oa.domain.Video;
import com.spring.oa.service.ChannelService;
import com.spring.oa.service.PageService;
import com.spring.oa.util.Const;
import com.spring.oa.util.PageBean;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

/**
 * Created by burning-.- on 2015/6/27.
 */
@SuppressWarnings("serial")
@Controller
public class MainAction extends BaseAction{
    @Resource
    private ChannelService channelService;
    @Resource
    private PageService pageService;
    @Resource
    private UserDao userDao;
    @Resource
    private ChannelDao channelDao;
    @Resource
    private VideoDao videoDao;

    private int channelId;//页面中选择的频道的下标

    private int orderId;//页面中选择的排序字段的下标

    private int page;//页面中选择的当前页号
    @Override
    public String execute(){
        generateData4Test(523);
        //判断字段的合法性
        if(orderId!=1&&orderId!=2&&orderId!=3&&orderId!=4){
            orderId=1;
        }
        List<Channel> all_channels=channelService.findAllChannels();
        Channel channel=channelService.findChannel(channelId);
        channelId=channel.getId();//传入的频道ip可能不存在
        /*根据传入的各参数获取分页对象*/
        PageBean videoPageBean=pageService.getVideoPageOfMain(channel,orderId-1,page, Const.VIDEO_SIZE_PER_PAGE, Const.PAGE_BUTTON_SIZE_PER_PAGE);
        /*将各对象写入到页面呈现*/
        ActionContext.getContext().put("all_channels",all_channels);
        ActionContext.getContext().put("channel",channel);
        ActionContext.getContext().put("page_bean",videoPageBean);
        return "main";
    }
    public void generateData4Test(int count){
        Random random=new Random();
        String s="视频";
        User u= userDao.findById(1);
        Channel c=channelDao.findById(1);
        int i=0;
        while (i++<count){
            Video video=new Video();
            video.setChannelId(1);
            video.setUserId(1);
            video.setClientFileName("");
            video.setPcFileName("");
            video.setTitle(s + "标题" + i);
            video.setTags("标签1标签2标签3");
            video.setDescription(s + "描述" + i);
            video.setPlayCount(random.nextInt(10000));
            video.setCommentCount(random.nextInt(1000));
//            video.setComments(new HashSet<Comment>());
            video.setGoodCommentCount(random.nextInt(1000));
            video.setBadCommentCount(random.nextInt(1000));
            video.setDuration(random.nextInt(3000) + 10);
            video.setUploadTime(new Timestamp(System.currentTimeMillis() - random.nextInt()));
            video.setStatus(Const.VIDEO_STATUS_CONVERTED);
            videoDao.save(video);
        }
    }

    public ChannelService getChannelService() {
        return channelService;
    }

    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    public PageService getPageService() {
        return pageService;
    }

    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
