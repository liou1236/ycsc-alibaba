package com.jt.controller;

import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Ming
 */
@RestController
@CrossOrigin
@RequestMapping("/rights")
public class RightsController {
    @Autowired
    private RightsService rightsService;

    /*
    * url: /rights/getRightsList
    * 参数:null
    * 类型: get
    * 返回值 SysResult对象 List
    * 业务: 只查询2级权限
    * */
    @GetMapping("/getRightsList")
    public SysResult getRightsList(){
        List<Rights> rightsList = rightsService.findRightsList();
        return SysResult.success(rightsList);
    }
}
