package com.yhkx.restapi.controller;

import com.xmair.core.storage.dao.entity.TbEmpData;
import com.xmair.core.util.ResultBean;
import com.yhkx.restapi.apiversion.ApiVersion;
import com.xmair.core.service.EmpService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作数据库的Controller示例
 *
 * @author LiSs
 * @date on 2018/7/04
 */
@RestController
@RequestMapping(value = "/emp")
@ApiVersion(1)
public class EmpController {

    @Autowired
    private EmpService empService;

    @ApiOperation(value = "获取单条记录", notes = "根据url的id来获取详细信息")
    @GetMapping(value = "/get/{empId}")
    public ResultBean<TbEmpData> get(@PathVariable String empId) {
        TbEmpData tbEmpData = empService.selectById(empId);
        return new ResultBean<>(tbEmpData);
    }


    @GetMapping(value = "/list")
    public ResultBean<List<TbEmpData>> getList() {
        List<TbEmpData> list = empService.list();
        return new ResultBean<>(list);
    }

    @PostMapping(value = "/create")
    public ResultBean<String> create(@Validated @RequestBody TbEmpData item) {
        empService.insertEmp(item);
        return new ResultBean<>("");
    }

    @PostMapping(value = "/update")
    public ResultBean<String> update(@Validated @RequestBody TbEmpData item) {
        empService.updateEmp(item);
        return new ResultBean<>("");
    }

    @PostMapping(value = "/delete/{empId}")
    public ResultBean<String> delete(@Validated @RequestBody String empId) {
        empService.deleteEmp(empId);
        return new ResultBean<>("");
    }
}

