package com.zhangbao.service.impl;

import com.zhangbao.mapper.AdminMapper;
import com.zhangbao.mapper.UserMapper;
import com.zhangbao.pojo.AdminPoJo;
import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.service.AccountService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/16 9:46
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PoJoVo<?> login(String username, String password, String type) {
        Example example = new Example(AdminPoJo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);

        switch (type) {
            case "admin" :
                AdminPoJo adminPoJo = adminMapper.selectOneByExample(example);
                return PoJoVo.ok(Collections.singletonList(adminPoJo));
            case "user" :
                UserPoJo userPoJo = userMapper.selectOneByExample(example);
                return PoJoVo.ok(Collections.singletonList(userPoJo));
            default :
                return PoJoVo.notFound();
        }
    }
}
