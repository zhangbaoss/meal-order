package com.zhangbao.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhangbao.bo.MenuBo;
import com.zhangbao.mapper.MenuMapper;
import com.zhangbao.mapper.TypeMapper;
import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import com.zhangbao.service.MenuService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 17:59
 * @Version 1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PoJoVo<MenuBo> list(int pageNum, int pageSize) {
        // 开启分页插件
        PageHelper.startPage(pageNum, pageSize);
        // 查询所有菜单
        List<MenuPoJo> menus = menuMapper.selectAll();
        if (CollectionUtils.isEmpty(menus)) {
            return PoJoVo.notFound();
        }
        List<MenuBo> menuBos = menus.stream().map(menuPoJo -> {
            MenuBo menuBo = new MenuBo();
            // 拷贝属性
            BeanUtils.copyProperties(menuPoJo, menuBo);
            // 查询菜品类型
            TypePoJo typePoJo = typeMapper.selectByPrimaryKey(menuPoJo.getTid());
            menuBo.setType(typePoJo);
            return menuBo;
        }).collect(Collectors.toList());
        // 查询菜单总数
        int count = menuMapper.selectCount(new MenuPoJo());
        return PoJoVo.ok(menuBos, count);
    }

    @Override
    public PoJoVo<TypePoJo> types() {
        List<TypePoJo> typePoJos = typeMapper.selectAll();
        if (CollectionUtils.isEmpty(typePoJos)) {
            return PoJoVo.notFound();
        }
        return PoJoVo.ok(typePoJos);
    }

    @Override
    public PoJoVo<Void> post(MenuPoJo menuPoJo) {
        menuMapper.insert(menuPoJo);
        return PoJoVo.noContent();
    }

    @Override
    public PoJoVo<MenuBo> get(long id) {
        MenuPoJo menuPoJo = menuMapper.selectByPrimaryKey(id);
        if (menuPoJo == null) {
            return PoJoVo.notFound();
        }
        TypePoJo typePoJo = typeMapper.selectByPrimaryKey(menuPoJo.getTid());
        MenuBo menuBo = new MenuBo();
        BeanUtils.copyProperties(menuPoJo, menuBo);
        menuBo.setType(typePoJo);
        return PoJoVo.ok(Collections.singletonList(menuBo));
    }

    @Override
    public PoJoVo<Void> put(MenuPoJo menuPoJo) {
        menuMapper.updateByPrimaryKey(menuPoJo);
        return PoJoVo.noContent();
    }

    @Override
    public PoJoVo<Void> delete(long id) {
        menuMapper.deleteByPrimaryKey(id);
        return PoJoVo.noContent();
    }
}
