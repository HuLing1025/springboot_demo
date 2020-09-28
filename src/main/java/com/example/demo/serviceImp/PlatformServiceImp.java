package com.example.demo.serviceImp;

import com.example.demo.dao.PlatformDao;
import com.example.demo.pojo.Platform;
import com.example.demo.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImp implements PlatformService {

    @Autowired
    PlatformDao platformDao;

    @Override
    public boolean insertPlatform(Platform platform) {
        boolean flag = false;
        try {
            platformDao.insertPlatform(platform);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deletePlatform(int id) {
        boolean flag = false;
        try {
            platformDao.deletePlatform(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updatePlatform(Platform platform) {
        boolean flag = false;
        try {
            platformDao.updatePlatform(platform);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Platform> selectPlatforms() {
        return platformDao.selectPlatforms();
    }

    @Override
    public Platform selectPlatform(int id) {
        return platformDao.selectPlatformById(id);
    }
}
