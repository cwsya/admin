package plus.cws.admin.sys.cache.service.impl;

import org.noear.solon.annotation.Component;
import org.noear.solon.scheduling.annotation.Scheduled;
import plus.cws.admin.sys.cache.entity.dao.CacheEntity;
import plus.cws.admin.sys.cache.service.ICacheService;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheServiceImpl implements ICacheService {


    private final static Map<String, CacheEntity> CACHE_DATA = new ConcurrentHashMap<>();


    @Override
    public void put(String key, Object value) {
        this.put(key, value, 0L);
    }

    @Override
    public void put(String key, Object value, long expire) {
        CacheEntity cacheEntity = new CacheEntity();
        cacheEntity.setKey(key);
        cacheEntity.setValue(value);
        if (expire > 0) {
            // 计算过期时间
            Long expireTime = System.currentTimeMillis() + Duration.ofSeconds(expire).toMillis();
            cacheEntity.setExpireTime(expireTime);
        }
        CACHE_DATA.put(key, cacheEntity);
    }

    @Override
    public Object get(String key) {
        if (CACHE_DATA.containsKey(key)) {
            return CACHE_DATA.get(key);
        }
        return null;
    }

    @Override
    public void remove(String key) {
        CACHE_DATA.remove(key);
    }

    @Scheduled(fixedRate = 1000)
    public static void clear() {
        if (CACHE_DATA.isEmpty()) {
            return;
        }
        CACHE_DATA.entrySet().removeIf(entityEntry -> entityEntry.getValue().getExpireTime() != null && entityEntry.getValue().getExpireTime() > System.currentTimeMillis());
    }

}
