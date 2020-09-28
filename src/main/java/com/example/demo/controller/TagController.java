package com.example.demo.controller;

import com.example.demo.pojo.Tag;
import com.example.demo.service.TagService;
import com.example.demo.serviceImp.TagServiceImp;
import com.example.demo.utils.ResponseCode;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zb/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public Result insertTag(@RequestBody Tag tag) {
        if(tagService.insertTag(tag)) {
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_SERVICE_VALIDATOR, "添加直播标签失败!");
        }
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.DELETE)
    public Result deleteTag(@PathVariable int id) {
        if(tagService.deleteTag(id)) {
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_SERVICE_VALIDATOR, "删除直播标签失败!");
        }
    }

    @RequestMapping(value = "/tag", method = RequestMethod.PUT)
    public Result updateTag(@RequestBody Tag tag) {
        if(tagService.updateTag(tag)) {
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_SERVICE_VALIDATOR, "更新直播标签失败!");
        }
    }

    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public Result selectTags() {
        List<Tag> tags = tagService.selectTags();
        if(tags != null) {
            return Result.success(tags);
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "标签数据为空!");
        }
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public Result selectTagById(@PathVariable int id) {
        Tag tag = tagService.selectTagById(id);
        if(tag != null){
            return Result.success(tag);
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "找不到该标签!");
        }
    }
}