package com.zhangbao.service;

import com.zhangbao.vo.PoJoVo;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/16 9:46
 * @Version 1.0
 **/
public interface AccountService {
    /**
     * 登录,返回有值表示登录成功
     * @param username
     * @param password
     * @param type
     * @return
     */
    PoJoVo<?> login(String username, String password, String type);
}
