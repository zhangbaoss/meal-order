package com.zhangbao.service;

import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.vo.PoJoVo;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/15 13:52
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 分页查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    PoJoVo<UserPoJo> list(int pageNum, int pageSize);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    PoJoVo<UserPoJo> get(int id);

    /**
     * 添加用户
     * @param userPoJo
     * @return
     */
    PoJoVo<Void> post(UserPoJo userPoJo);

    /**
     * 修改用户信息
     * @param userPoJo
     * @return
     */
    PoJoVo<Void> put(UserPoJo userPoJo);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    PoJoVo<Void> delete(int id);
}
