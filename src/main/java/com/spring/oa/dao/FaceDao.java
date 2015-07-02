package com.spring.oa.dao;

import com.spring.oa.domain.Face;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface FaceDao extends BaseDao<Face>{
    public int findById(int faceId);
}
