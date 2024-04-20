package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Ming
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    //只查询一次数据库  2.Map<parentid,List<ItemCat>>
    public Map<Integer,List<ItemCat>> getMap(){
        Map<Integer,List<ItemCat>> map = new HashMap<>();
        //1.查询所有数据
        List<ItemCat> itemCatList = itemCatMapper.selectList(null);
        //2.封装map集合数据
        //2.1存储依据: 如果key存在 获取子集add操作
        //2.2如果key不存在 则将key进行存储  同时将自己当作第一个元素进行保存
        for (ItemCat itemCat : itemCatList){
            int parentId = itemCat.getParentId();
            //判断map集合中是否有父级
            if (map.containsKey(parentId)){
                //有父级 将自己添加到子级
                map.get(parentId).add(itemCat);
            }else {
                List<ItemCat> list = new ArrayList<>();
                list.add(itemCat);
                map.put(parentId,list);
            }
        }
        return map;
    }
    public List<ItemCat> findChildrenList(Integer id, Integer type,Map<Integer,List<ItemCat>> map){
        if (id==null) id=0;
        List<ItemCat> itemCatList = map.get(id);
        if (type == 1){
            return itemCatList;
        }
        if (itemCatList == null){
            return null;
        }
        for (ItemCat itemCat : itemCatList){
            if (itemCat.getLevel()<type){
                List<ItemCat> childrenList = findChildrenList(itemCat.getId(),type,map);
                itemCat.setChildren(childrenList);
            }
        }
        return itemCatList;
    }
    /*
     * 如何实现3级商品分类的嵌套
     * //select * from item_cat where parent_id=0
     * 1.for循环    2.递归写法    3.左外连接 mysql的执行速度快        3.尽可能降低数据库的查询次数
     * */
    /*@Override
    public List<ItemCat> findItemCatList(Integer type) {
        if (type == 1) {//只查询一级商品分类
            QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", 0);
            List<ItemCat> oneList = itemCatMapper.selectList(queryWrapper);
            return oneList;
        }
        if (type == 2) {
            QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", 0);
            List<ItemCat> oneList = itemCatMapper.selectList(queryWrapper);
            //根据一级查询二级信息
            for (ItemCat oneItemCat : oneList) {
                QueryWrapper<ItemCat> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("parent_id", oneItemCat.getId());
                List<ItemCat> twoList = itemCatMapper.selectList(queryWrapper2);
                oneItemCat.setChildren(twoList);
            }
            return oneList;
        }
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",0);
        List<ItemCat> oneList = itemCatMapper.selectList(queryWrapper);
        //根据一级查询二级
        if (oneList == null) return null;
        for (ItemCat oneItemCat : oneList){
            QueryWrapper<ItemCat> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("parent_id",oneItemCat.getId());
            List<ItemCat> twoList = itemCatMapper.selectList(queryWrapper2);
            //根据二级查询三级
            if (twoList == null) return null;
            for (ItemCat twoItemCat : twoList){
                QueryWrapper<ItemCat> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.eq("parent_id",twoItemCat.getId());
                List<ItemCat> threeList = itemCatMapper.selectList(queryWrapper3);
                twoItemCat.setChildren(threeList);
            }
            oneItemCat.setChildren(twoList);
        }
        return oneList;
    }*/

    @Override
    public List<ItemCat> findItemCatList(Integer type) {
        //获取数据
        Map<Integer,List<ItemCat>> map = getMap();
        return findChildrenList(null,type,map);
    }

    @Override
    public void updateStatus(ItemCat itemCat) {
        itemCatMapper.updateById(itemCat);
    }

    @Override
    @Transactional//对方法进行事务的控制
    public void saveItemCat(ItemCat itemCat) {
        //自控填充功能created/updated
        itemCat.setStatus(true);
        itemCatMapper.insert(itemCat);
    }
    /*
    * 实现商品分类删除
    * 实现思路: 根据level 判断层级  之后根据id删除数据
    *
    * */
    @Override
    public void deleteItemCat(ItemCat itemCat) {
        //1.判断等级是否为3级
        if (itemCat.getLevel() == 3){
            itemCatMapper.deleteById(itemCat.getId());
        }
        if (itemCat.getLevel() == 2){
            //1.先删除3及信息
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("parent_id",itemCat.getId());
            itemCatMapper.delete(queryWrapper);
            //2.再去删除自己
            itemCatMapper.deleteById(itemCat.getId());

        }
        if (itemCat.getLevel() == 1){
            //1.查询所有的二级菜单
            QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id",itemCat.getId());
            List<ItemCat> twoList = itemCatMapper.selectList(queryWrapper);
            for (ItemCat itemCat2 : twoList){
                QueryWrapper queryWrapper2 = new QueryWrapper();
                queryWrapper2.eq("parent_id",itemCat2.getId());
                itemCatMapper.delete(queryWrapper2);//删除三级
                itemCatMapper.deleteById(itemCat2.getId());//删除二级
            }
            itemCatMapper.deleteById(itemCat.getId());
        }
    }

    @Override
    public void updateItemCat(ItemCat itemCat) {
        itemCatMapper.updateById(itemCat);
    }


}
