package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ming
 */
@Service
public class RightsServiceImpl implements RightsService {
    @Autowired
    private RightsMapper rightsMapper;

    /*
    * 查询一级/二级菜单
    * 查询条件: 一级菜单 parent_id=0
    *           二级菜单 parent_id= 一级菜单的id
    * */
    @Override
    public List<Rights> findRightsList() {
        //1.查询一级菜单数据
        QueryWrapper<Rights> queryWrapper = new QueryWrapper<>();
        //相等
        queryWrapper.eq("parent_id",0);
        List<Rights> oneList = rightsMapper.selectList(queryWrapper);
        //2.查询二级菜单 父子关系的封装
        for(Rights oneRights : oneList){
            //查询二级菜单
            queryWrapper.clear();
            queryWrapper.eq("parent_id",oneRights.getId());
            List<Rights> twoList = rightsMapper.selectList(queryWrapper);
            oneRights.setChildren(twoList);
        }
        return oneList;
    }
}
