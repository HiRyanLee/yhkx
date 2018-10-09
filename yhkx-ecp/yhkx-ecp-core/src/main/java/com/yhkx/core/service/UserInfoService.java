package com.yhkx.core.service;

import com.yhkx.core.storage.dao.entity.TbEmpData;
import com.yhkx.core.storage.dao.entity.UserInfo;
import com.yhkx.core.storage.dao.mapper.TbEmpDataMapper;
import com.yhkx.core.storage.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiSs
 * @date on 2018/7/9
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper mapper;

    public UserInfo selectById(String empId) {
        UserInfo item = mapper.selectByPrimaryKey(empId);
        return item;
    }
/*
    public List<TbEmpData> list() {
        List<TbEmpData> list = mapper.selectAll();
        return list;
    }

    public Map<String, String> insertEmp(TbEmpData item) {
        int id = mapper.insert(item);
        Map<String, String> result = new HashMap<>();
        result.put("id", id + "");
        return result;
    }

    public Map<String, String> updateEmp(TbEmpData item) {
        int id = mapper.updateByPrimaryKey(item);
        Map<String, String> result = new HashMap<>();
        result.put("id", id + "");
        return result;
    }

    public Map<String, String> deleteEmp(String empId) {
        int id = mapper.deleteByPrimaryKey(empId);
        Map<String, String> result = new HashMap<>();
        result.put("id", id + "");
        return result;
    }*/
}
