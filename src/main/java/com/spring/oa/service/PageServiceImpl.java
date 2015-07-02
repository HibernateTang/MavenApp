package com.spring.oa.service;

import com.spring.oa.dao.VideoDao;
import com.spring.oa.domain.Channel;
import com.spring.oa.domain.Video;
import com.spring.oa.util.Const;
import com.spring.oa.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by burning-.- on 2015/6/30.
 */
@Service
public class PageServiceImpl implements PageService{
    @Resource
    VideoDao videoDao;
    public PageBean getVideoPageOfMain(Channel channel, int orderId, int page, int pageSize, int pageButtonSize) {
        String whereHql="and o.channel=? and o.status=? ";
        Object []params=new Object[]{channel, Const.VIDEO_STATUS_CONVERTED};
        /*∞¥≈≈–Ú◊÷∂Œ√˚Ωµ–Ú≈≈¡–*/
        Map<String,String> orderBy=new LinkedHashMap<String, String>();
        orderBy.put("o"+ Const.VIDEO_ORDER_FILEDS[orderId], Const.ODER_DESC);
        int rowCount=videoDao.getRowCount(whereHql,params);
        PageBean pageBean=new PageBean(rowCount,page,pageSize,pageButtonSize);
        List<Video> list=videoDao.findConditionWithPaging(whereHql,params,orderBy,pageBean.getOffset(),pageSize);
        pageBean.setContents(list);
        return pageBean;
    }
}
