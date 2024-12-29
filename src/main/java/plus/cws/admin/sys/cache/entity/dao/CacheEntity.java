package plus.cws.admin.sys.cache.entity.dao;

import lombok.Data;

@Data
public class CacheEntity {

    /**
     * 缓存键
     */
    private String key;

    /**
     * 缓存值
     */
    private Object value;

    /**
     * 过期时间
     */
    private Long expireTime;
}
