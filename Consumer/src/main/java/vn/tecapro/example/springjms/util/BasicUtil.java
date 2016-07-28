package vn.tecapro.example.springjms.util;

import java.util.UUID;

/**
 * Created by hoangtd on 7/28/2016.
 */
public class BasicUtil {
    public static String getUniqueId() {
        return UUID.randomUUID().toString();
    }
}
