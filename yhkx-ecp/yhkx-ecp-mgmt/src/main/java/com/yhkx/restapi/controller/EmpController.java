package com.yhkx.restapi.controller;

import com.yhkx.core.service.UserInfoService;
import com.yhkx.core.storage.dao.entity.UserInfo;
import com.yhkx.restapi.apiversion.ApiVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 操作数据库的Controller示例
 *
 * @author LiSs
 * @date on 2018/7/04
 */
@RestController
@RequestMapping(value = "/userInfo")
@ApiVersion(1)
public class EmpController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "获取单条记录", notes = "根据url的id来获取详细信息")
    @GetMapping(value = "/get/{userId}")
    public UserInfo get(@PathVariable String userId) {
        UserInfo userInfo = userInfoService.selectById(userId);
        return userInfo;
    }
/*

    @GetMapping(value = "/list")
    public ResultBean<List<TbEmpData>> getList() {
        List<TbEmpData> list = userInfoService.list();
        return new ResultBean<>(list);
    }

    @PostMapping(value = "/create")
    public ResultBean<String> create(@Validated @RequestBody TbEmpData item) {
        userInfoService.insertEmp(item);
        return new ResultBean<>("");
    }

    @PostMapping(value = "/update")
    public ResultBean<String> update(@Validated @RequestBody TbEmpData item) {
        userInfoService.updateEmp(item);
        return new ResultBean<>("");
    }

    @PostMapping(value = "/delete/{empId}")
    public ResultBean<String> delete(@Validated @RequestBody String empId) {
        userInfoService.deleteEmp(empId);
        return new ResultBean<>("");
    }*/
}

