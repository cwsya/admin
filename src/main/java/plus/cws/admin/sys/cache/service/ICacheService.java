package plus.cws.admin.sys.cache.service;

public interface ICacheService {

    /**
     * 存储至缓存
     * @param key key
     * @param value 数据
     */
    void put(String key, Object value);

    /**
     * 存储至缓存且设置时效
     * @param key key
     * @param value 数据
     * @param expire 时效（毫秒）
     */
    void put(String key, Object value, long expire);

    /**
     * 获取数据 如果已过期返回null
     * @param key key
     * @return 数据
     */
    Object get(String key);

    /**
     * 手动删除缓存
     * @param key key
     */
    void remove(String key);
}
