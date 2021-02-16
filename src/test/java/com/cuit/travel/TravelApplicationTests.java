package com.cuit.travel;

import com.cuit.travel.dao.CommonDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelApplicationTests {
    @Autowired
    CommonDao commonDao;

    @Test
    /**
     * 查所有
     */
    void contextLoads() {
        Integer integer = commonDao.selectCount(null);
        System.out.println(integer);
    }

}
