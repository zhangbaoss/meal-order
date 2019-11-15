package com.zhangbao.feign;

import com.zhangbao.bo.MenuBo;
import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import com.zhangbao.vo.PoJoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * FeignClient中menu-server是menu-server微服务在eureka中的注册名,
 * 是在menu-server的配置文件bootstrap.yml中spring.application.name配置的值
 * 它会将其代理到http://localhost:7004这个路径,
 * 即使配置了server.servlet.context-path=/menu/server也只会代理到端口号
 * @Author zhangbao
 * @Date 2019/11/13 9:15
 * @Version 1.0
 **/
@FeignClient("menu-server")
@RequestMapping("/menu/server")
public interface MenuFeign {

    /**
     * 分页查询所有的菜单
     * 可能由于MenuHandler中传递参数是直接方法参数传递,
     * 使用@PathVariable接收参数报错,使用@RequestParam接收
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    PoJoVo<MenuBo> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 查询所有的菜品类型
     * @return
     */
    @GetMapping("/types")
    PoJoVo<TypePoJo> types();

    /**
     * 添加菜单
     * @param menuPoJo
     * @return
     */
    @PostMapping("/post")
    PoJoVo<Void> post(@RequestBody MenuPoJo menuPoJo);

    /**
     * 修改菜单时需要先获取被修改的菜单
     * @param id 根据id来获取菜单
     * @return
     */
    @GetMapping("/get/{id}")
    PoJoVo<MenuBo> get(@PathVariable("id") long id);

    /**
     * 修改菜单
     * @param menuPoJo
     * @return
     */
    @PutMapping("/put")
    PoJoVo<Void> put(@RequestBody MenuPoJo menuPoJo);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    PoJoVo<Void> delete(@PathVariable("id") long id);
}
