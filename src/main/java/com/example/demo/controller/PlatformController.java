package com.example.demo.controller;

import com.example.demo.pojo.Platform;
import com.example.demo.service.PlatformService;
import com.example.demo.utils.ResponseCode;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zb/admin")
public class PlatformController {
    @Autowired
    private PlatformService platformService;

    @RequestMapping(value = "/platform", method = RequestMethod.POST)
    public Result insertPlatform(@RequestBody Platform platform) {
        if(platformService.insertPlatform(platform)){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "添加直播平台失败!");
        }
    }

    @RequestMapping(value = "/platform/{id}", method = RequestMethod.DELETE)
    public Result deletePlatform(@PathVariable int id) {
        if(platformService.deletePlatform(id)){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "删除直播平台失败!");
        }
    }

    @RequestMapping(value = "/platform", method = RequestMethod.PUT)
    public Result updatePlatform(@RequestBody Platform platform) {
        if(platformService.updatePlatform(platform)){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "更新直播平台失败!");
        }
    }

    @RequestMapping(value = "/platform", method = RequestMethod.GET)
    public Result selectPlatforms() {
        List<Platform> platforms = platformService.selectPlatforms();
        if(platforms != null){
            return Result.success(platforms);
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "查询失败,或者数据为空!");
        }
    }

    @RequestMapping(value = "/platform/{id}", method = RequestMethod.GET)
    public Result selectPlatformById(@PathVariable int id) {
        Platform platform = platformService.selectPlatform(id);
        if(platform != null){
            return Result.success(platform);
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "该直播平台不存在或者查询失败!");
        }
    }
}
