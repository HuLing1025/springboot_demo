package com.example.demo.service;

import com.example.demo.pojo.Platform;

import java.util.List;

public interface PlatformService {
    /*
    * 新增平台
    * @param platform
    * @return
    * */
    boolean insertPlatform(Platform platform);

    /*
     * 删除平台
     * @param id
     * @return
     * */
    boolean deletePlatform(int id);

    /*
     * 更新平台
     * @param platform
     * @return
     * */
    boolean updatePlatform(Platform platform);

    /*
     * 查询平台列表
     * @return
     * */
    List<Platform> selectPlatforms();

    /*
     * 根据id查询平台
     * @param int
     * @return
     * */
    Platform selectPlatform(int id);
}
