package com.spring.oa.service;

import com.spring.oa.domain.Channel;
import com.spring.oa.util.PageBean;

/**
 * Created by burning-.- on 2015/6/30.
 */
public interface PageService {
    public PageBean getVideoPageOfMain(Channel channel, int orderId, int page, int pageSize, int pageButtonSize);
}
