package com.zhangbao.controller;

import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.service.UserService;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/15 13:51
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public PoJoVo<UserPoJo> list(@RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        return userService.list(pageNum, pageSize);
    }

    @GetMapping("/get/{id}")
    public PoJoVo<UserPoJo> get(@PathVariable("id") int id) {
        return userService.get(id);
    }

    @PostMapping("/post")
    public PoJoVo<Void> post(@RequestBody UserPoJo userPoJo) {
        return userService.post(userPoJo);
    }

    @PutMapping("/put")
    public PoJoVo<Void> put(@RequestBody UserPoJo userPoJo) {
        return userService.put(userPoJo);
    }

    @DeleteMapping("/delete/{id}")
    public PoJoVo<Void> delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
}
