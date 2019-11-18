package com.zhangbao.feign;

import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.vo.PoJoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/13 9:15
 * @Version 1.0
 **/
@FeignClient("user-server")
@RequestMapping("/user/server")
public interface UserFeign {

    /**
     * 分页查询所有的用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    PoJoVo<UserPoJo> list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

    /**
     * 添加用户
     * @param userPoJo
     * @return
     */
    @PostMapping("/post")
    PoJoVo<Void> post(@RequestBody UserPoJo userPoJo);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    PoJoVo<UserPoJo> get(@PathVariable("id") long id);

    /**
     * 修改用户
     * @param userPoJo
     * @return
     */
    @PutMapping("/put")
    PoJoVo<Void> put(@RequestBody UserPoJo userPoJo);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    PoJoVo<Void> delete(@PathVariable("id") long id);
}
