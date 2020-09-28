package com.example.demo.controller;

import com.example.demo.pojo.Suggest;
import com.example.demo.service.SuggestService;
import com.example.demo.utils.ResponseCode;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zb/admin")
public class SuggestController {
    @Autowired
    private SuggestService suggestService;

    @RequestMapping(value = "/suggest", method = RequestMethod.POST)
    public Result insertSuggest(@RequestBody Suggest suggest) {
        if(suggestService.insertSuggest(suggest)){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "新增建议失败!");
        }
    }

    @RequestMapping(value = "/suggest/{id}", method = RequestMethod.DELETE)
    public Result deleteSuggest(@PathVariable int id) {
        if(suggestService.deleteSuggest(id)){
            return Result.success();
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "删除建议失败!");
        }
    }

    @RequestMapping(value = "/suggest", method = RequestMethod.GET)
    public Result selectSuggests() {
        List<Suggest> suggests = suggestService.selectSuggests();
        if(suggests != null){
            return Result.success(suggests);
        }else{
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR, "查询建议列表失败!");
        }
    }
}
