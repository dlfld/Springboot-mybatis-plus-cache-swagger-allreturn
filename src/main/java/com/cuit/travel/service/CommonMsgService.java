package com.cuit.travel.service;

import com.cuit.travel.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class CommonMsgService {
    @Autowired
    CommonDao commonDao;

    /**
     * 查询消息条数并返回
     *
     * @return
     */
    @Cacheable(value = "getTotalCount")
    public Integer getTotalCount() {
        Integer count = commonDao.selectCount(null);
        return count;
    }
}
