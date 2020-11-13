package service;

import domain.Province;

import java.util.List;

/**
 * @author wyl
 * @create 2020-11-12
 * @Description
 * @Version
 */
public interface ProvinceService {

    //引入缓存

    public List<Province> findAll();
    public String findAllJson();

}
