package com.wssearch.service.impl;

import com.wssearch.dao.TestDao;
import com.wssearch.model.User;
import com.wssearch.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/24.
 */

@Transactional
@Service("testService")
public class TestServiceImpl implements TestService{

    @Resource
    TestDao testDao;

    @Override
    public List<User> getAll() {
        return testDao.getAll();
    }

    @Override
    public String test() {
        return testDao.test();
    }
}
