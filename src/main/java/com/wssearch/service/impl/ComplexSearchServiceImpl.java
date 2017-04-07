package com.wssearch.service.impl;

import com.wssearch.dao.ComplexSearchDao;
import com.wssearch.service.ComplexSearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by cristph on 2017/4/7.
 */

@Transactional
@Service("ajjbxxService")
public class ComplexSearchServiceImpl implements ComplexSearchService {

    @Resource
    ComplexSearchDao complexSearchDao;

}
