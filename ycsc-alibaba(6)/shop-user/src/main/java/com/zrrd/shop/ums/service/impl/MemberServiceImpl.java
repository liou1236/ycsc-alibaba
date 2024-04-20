package com.zrrd.shop.ums.service.impl;

import com.zrrd.shop.ums.entity.Member;
import com.zrrd.shop.ums.mapper.MemberMapper;
import com.zrrd.shop.ums.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Ming
 * @since 2024-04-02
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
