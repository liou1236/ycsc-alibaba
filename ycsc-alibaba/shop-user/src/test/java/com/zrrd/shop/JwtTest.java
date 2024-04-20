package com.zrrd.shop;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author : Ming
 */
@Slf4j
public class JwtTest {
    @Test
    public void testBCrypt(){
        String password = "123456";
        String hashpw = BCrypt.hashpw(password,BCrypt.gensalt());
        log.info("密码加密之后的样子:{}",hashpw);
    }

}
