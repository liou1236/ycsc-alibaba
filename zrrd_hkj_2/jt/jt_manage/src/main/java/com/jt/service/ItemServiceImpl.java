package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.mapper.ItemParamMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.pojo.ItemParam;
import com.jt.vo.ItemParamVO;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author : Ming
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemParamMapper itemParamMapper;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public PageResult findItemList(PageResult pageResult) {
        IPage page = new Page(pageResult.getPageNum(),pageResult.getPageSize());
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        //是否传递参数
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        queryWrapper.like(flag,"title",pageResult.getQuery());
        page = itemMapper.selectPage(page,queryWrapper);
        long total = page.getTotal();
        List<Item> itemList = page.getRecords();
        return pageResult.setTotal(total).setRows(itemList);
    }

    @Override
    public void updateItemStatus(Item item) {
        itemMapper.updateById(item);
    }
    /*
    * 实现三张表入库 商品表/商品的详情表/商品的参数表
    * */
    @Override
    @Transactional
    public void saveItem(ItemVO itemVO) {
        //1.入库商品表
        Item item = itemVO.getItem();
        item.setStatus(true);//默认启用状态
        //要求入库之后返回主键
        //MP如果设定了主键自增则会自动的实现数据的回显
        itemMapper.insert(item);
        //2.入库商品的详情
        ItemDesc itemDesc = itemVO.getItemDesc();
        itemDesc.setId(item.getId());
        itemDescMapper.insert(itemDesc);
        //3.入库商品参数
        //1.一个商品应该有自己单独的参数  动态参数/静态属性  KEY-VALUE
        ItemParam itemParam = itemVO.getItemParam();
        ItemParamVO[] dynamic = itemParam.getDynamicArray();
        ItemParamVO[] staticParam = itemParam.getStaticArray();
        try {
            //将页面传递的数据转化为JSON 之后进行数据的保存
            String dynamicJSON = MAPPER.writeValueAsString(dynamic);
            String staticJSON = MAPPER.writeValueAsString(staticParam);
            //封装商品的参数信息
            itemParam.setDynamicArgs(dynamicJSON)
                    .setStaticArgs(staticJSON)
                    .setId(item.getId());
            //实现入库操作
            itemParamMapper.insert(itemParam);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            //如果程序执行报错则抛出异常
            throw new RuntimeException(e);
        }
    }


}
