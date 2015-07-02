package com.spring.oa.service;

import com.spring.oa.dao.ChannelDao;
import com.spring.oa.domain.Channel;
import com.spring.oa.util.Const;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
@Service
public class ChannelServiceImpl implements ChannelService{
    @Resource
    private ChannelDao channelDao;
    public List<Channel> findAllChannels() {
        return channelDao.findAll(true);
    }

    public Channel findChannel(int channelId) {
        Channel channel=channelDao.findById(channelId);
        if(channel==null){
            channel=channelDao.findById(Const.DEFAULT_CHANNEL_ID);
        }
        return channel;
    }
}
