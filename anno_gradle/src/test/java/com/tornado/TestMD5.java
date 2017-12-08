package com.tornado;

import com.tornado.utils.MD5;
import org.junit.Assert;
import org.junit.Test;

public class TestMD5 {

    @Test
    public void demo() {
        Assert.assertEquals(MD5.encryptPassword("123456", ""), "e10adc3949ba59abbe56e057f20f883e");
    }

}
