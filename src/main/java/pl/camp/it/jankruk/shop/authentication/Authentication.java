package pl.camp.it.jankruk.shop.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class Authentication implements IAuthentication {
    private static final String seed = "^*nY5V2PDbErXib!N7GBGwK2g^!8d6iZGbB993r";
    @Override
    public String hexPassword(String password) {
        return DigestUtils.md2Hex((password + seed).toLowerCase());
    }
}
