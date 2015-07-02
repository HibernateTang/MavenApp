package com.spring.oa.service;

import com.spring.oa.domain.Face;

import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface FaceService extends BaseService<Face> {
    public List<Face>findAllFaces();
    public Face findDefaultFace();
}
