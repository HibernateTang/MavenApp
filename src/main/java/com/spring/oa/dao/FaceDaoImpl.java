package com.spring.oa.dao;

import com.spring.oa.domain.Face;
import org.springframework.stereotype.Repository;

/**
 * Created by burning-.- on 2015/6/27.
 */
@Repository
public class FaceDaoImpl extends BaseDaoImpl<Face> implements FaceDao {
    public int findById(int faceId) {
       Face face=super.findById(faceId);
        return face.getId();
    }
}
