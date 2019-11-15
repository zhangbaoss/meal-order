package com.zhangbao.handler;

import com.zhangbao.bo.MenuBo;
import com.zhangbao.feign.MenuFeign;
import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/13 9:27
 * @Version 1.0
 **/
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    /**
     * 查询所有菜单和菜品类型
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public PoJoVo<MenuBo> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int pageNum = (page - 1) * limit;
        return menuFeign.list(pageNum, limit);
    }

    /**
     * 添加菜单时需要选择菜品类型
     * @return
     */
    @GetMapping("/types")
    public PoJoVo<TypePoJo> list() {
        return menuFeign.types();
    }

    @PostMapping("/post")
    public PoJoVo<Void> post(@RequestBody MenuPoJo menuPoJo) {
        return menuFeign.post(menuPoJo);
    }

    @GetMapping("/get/{id}")
    public PoJoVo<MenuBo> get(@PathVariable("id") long id) {
        return menuFeign.get(id);
    }

    @PutMapping("/put")
    public PoJoVo<Void> put(@RequestBody MenuPoJo menuPoJo) {
        return menuFeign.put(menuPoJo);
    }

    @DeleteMapping("/delete/{id}")
    public PoJoVo<Void> delete(@PathVariable("id") long id) {
        return menuFeign.delete(id);
    }
}
