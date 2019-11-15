package com.zhangbao.service;

import com.zhangbao.bo.MenuBo;
import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import com.zhangbao.vo.PoJoVo;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 17:59
 * @Version 1.0
 **/
public interface MenuService {
    /**
     * 分页查询所有菜单和菜品类型
     * @param pageNum 第几页
     * @param pageSize 每页显示几条
     * @return
     */
    PoJoVo<MenuBo> list(int pageNum, int pageSize);

    /**
     * 查询所有菜品类型
     * @return
     */
    PoJoVo<TypePoJo> types();

    /**
     * 添加菜单
     * @param menuPoJo
     * @return
     */
    PoJoVo<Void> post(MenuPoJo menuPoJo);

    /**
     * 根据id来查找菜单
     * @param id
     * @return
     */
    PoJoVo<MenuBo> get(long id);

    /**
     * 修改菜单
     * @param menuPoJo
     * @return
     */
    PoJoVo<Void> put(MenuPoJo menuPoJo);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    PoJoVo<Void> delete(long id);
}
