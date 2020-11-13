package service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import utils.JedisPoolUtils;

import java.util.List;

/**
 * @author wyl
 * @create 2020-11-13
 * @Description
 * @Version
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDaoImpl dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if (province_json == null|| province_json.length() == 0){
            System.out.println("redis 缓存中没有数据，从数据库读取");
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);

        }else {
            System.out.println("redis 缓存中有数据，查询缓存");
        }

        return province_json;
    }
}
