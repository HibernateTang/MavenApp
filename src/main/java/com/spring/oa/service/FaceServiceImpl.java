package com.spring.oa.service;

import com.spring.oa.dao.ConfigDao;
import com.spring.oa.dao.FaceDao;
import com.spring.oa.domain.Config;
import com.spring.oa.domain.Face;
import com.spring.oa.util.Const;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by burning-.- on 2015/6/27.
 */
@Service
public class FaceServiceImpl implements FaceService {
    @Resource
    private ConfigDao configDao;
    @Resource
    private FaceDao faceDao;
    /*获得并缓存所有的可选头像*/
    public List<Face>findAllFaces(){
        return faceDao.findAll(true);
    }
    public Face findDefaultFace(){
        Config config=configDao.findFirstByCondition("and o.name?",new Object[]{Const.CONFIG_NAME_DEFAULT_FACE_ID},true);
        if(config!=null){
            /*根据设置项的值获得对应的头像*/
            //Face face=faceDao.findById(Integer.parseInt(config.getValue()));
            return null;
//            return faceDao;
        }
        return null;
    }

    public void setEntity(Class<?> entityClass) {

    }

    public void save(Face entity) {

    }

    public void update(Face entity) {

    }

    public Face findById(Serializable id) {
        return null;
    }

    public void deleteById(Serializable... ids) {

    }

    public void deleteAll(Collection<Face> entityClass) {

    }

    public List<Face> findByCondition(String whereHql, Object[] params, Map<String, String> orderBy, boolean cacheable) {
        return null;
    }

    public List<Face> findByCondition(String whereHql, Object[] params, boolean cacheable) {
        return null;
    }

    public List<Face> findByCondition(Map<String, String> orderBy, boolean cacheable) {
        return null;
    }

    public List<Face> findAll(boolean cacheable) {
        return null;
    }

    public Face findFirstByCondition(String whereHql, Object[] params, boolean cacheable) {
        return null;
    }

    public List<Face> findConditionWithPaging(String whereHQl, Object[] params, Map<String, String> orderBy, int offset, int length) {
        return null;
    }

    public int getRowCount(String whereHql, Object[] params) {
        return 0;
    }
}
