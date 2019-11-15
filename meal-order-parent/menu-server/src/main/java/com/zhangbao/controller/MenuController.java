package com.zhangbao.controller;

import com.zhangbao.bo.MenuBo;
import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import com.zhangbao.service.MenuService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 17:58
 * @Version 1.0
 **/
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public PoJoVo<MenuBo> list(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        return menuService.list(pageNum, pageSize);
    }

    @GetMapping("/types")
    public PoJoVo<TypePoJo> types() {
        return menuService.types();
    }

    @PostMapping("/post")
    public PoJoVo<Void> post(@RequestBody MenuPoJo menuPoJo) {
        return menuService.post(menuPoJo);
    }

    @GetMapping("/get/{id}")
    public PoJoVo<MenuBo> get(@PathVariable("id") long id) {
        return menuService.get(id);
    }

    @PutMapping("/put")
    public PoJoVo<Void> put(@RequestBody MenuPoJo menuPoJo) {
        return menuService.put(menuPoJo);
    }

    @DeleteMapping("/delete/{id}")
    public PoJoVo<Void> delete(@PathVariable("id") long id) {
        return menuService.delete(id);
    }
}
