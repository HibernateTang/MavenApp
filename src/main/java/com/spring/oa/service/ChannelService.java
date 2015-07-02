package com.spring.oa.service;

import com.spring.oa.domain.Channel;

import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface ChannelService{
    public List<Channel> findAllChannels();
    public Channel findChannel(int channelId);
}
