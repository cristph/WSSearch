package com.wssearch.dao.impl;

import com.wssearch.dao.ComplexSearchDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by cristph on 2017/4/7.
 */

@Repository
public class ComplexSearchDaoImpl implements ComplexSearchDao {

    @Resource
    protected SessionFactory sessionFactory;


}
