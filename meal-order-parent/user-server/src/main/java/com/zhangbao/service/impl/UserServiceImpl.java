package com.zhangbao.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhangbao.mapper.UserMapper;
import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.service.UserService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/15 13:52
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PoJoVo<UserPoJo> list(int pageNum, int pageSize) {
        int count = userMapper.selectCount(new UserPoJo());
        PageHelper.startPage(pageNum, pageSize);
        List<UserPoJo> list = userMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            return PoJoVo.notFound();
        }
        return PoJoVo.ok(list, count);
    }

    @Override
    public PoJoVo<UserPoJo> get(int id) {
        UserPoJo userPoJo = userMapper.selectByPrimaryKey(id);
        if (userPoJo == null) {
            return PoJoVo.notFound();
        }
        return PoJoVo.ok(Collections.singletonList(userPoJo));
    }

    @Override
    public PoJoVo<Void> post(UserPoJo userPoJo) {
        userMapper.insert(userPoJo);
        return PoJoVo.noContent();
    }

    @Override
    public PoJoVo<Void> put(UserPoJo userPoJo) {
        userMapper.updateByPrimaryKey(userPoJo);
        return PoJoVo.noContent();
    }

    @Override
    public PoJoVo<Void> delete(int id) {
        userMapper.deleteByPrimaryKey(id);
        return PoJoVo.noContent();
    }
}
