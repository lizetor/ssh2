package com.tornado.utils;

import com.tornado.utils.MD5;
import org.junit.Assert;
import org.junit.Test;

import static com.tornado.utils.CheckBankCard.checkBankCard;
import static com.tornado.utils.CheckIdCard.isValidatedAllIdcard;

public class TestUtils {

    @Test
    public void testMd5() {
        Assert.assertEquals(MD5.encryptPassword("123456", ""), "e10adc3949ba59abbe56e057f20f883e");
    }

    @Test
    public void testBankCard() {
        Assert.assertEquals(checkBankCard("6217991100001804444"), false);
    }

    @Test
    public void testIdCard() {
        Assert.assertEquals(isValidatedAllIdcard("370213199008211234"), false);
    }
}
