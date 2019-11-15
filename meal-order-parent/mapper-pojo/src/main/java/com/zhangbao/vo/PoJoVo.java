package com.zhangbao.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/12 23:32
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoJoVo<T> implements Serializable {

    private Integer code;

    private String msg;

    private Integer count;

    private List<T> data;

    public PoJoVo(Builder<T> builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.count = builder.count;
        this.data = builder.data;
    }

    public static <T> PoJoVo<T> ok(List<T> data) {
        return builder()
                .code(HttpStatus.OK.value())
                .msg(HttpStatus.OK.getReasonPhrase())
                .count(data.size())
                .data(data)
                .build();
    }

    public static <T> PoJoVo<T> ok(List<T> data, Integer count) {
        return builder()
                .code(HttpStatus.OK.value())
                .msg(HttpStatus.OK.getReasonPhrase())
                .count(count)
                .data(data)
                .build();
    }

    public static <T> PoJoVo<T> noContent() {
        return builder()
                .code(HttpStatus.NO_CONTENT.value())
                .msg(HttpStatus.NO_CONTENT.getReasonPhrase())
                .count(0)
                .data(Collections.emptyList())
                .build();
    }

    public static <T> PoJoVo<T> notFound() {
        return builder()
                .code(HttpStatus.NOT_FOUND.value())
                .msg(HttpStatus.NOT_FOUND.getReasonPhrase())
                .count(0)
                .data(Collections.emptyList())
                .build();
    }

    public static <T> PoJoVo<T> failed() {
        return builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .msg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .count(0)
                .data(Collections.emptyList())
                .build();
    }

    public static <T> Builder builder() {
        return new Builder<T>();
    }

    public static class Builder<T> {
        private Integer code;

        private String msg;

        private Integer count;

        private List<T> data;

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder<T> count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public PoJoVo<T> build() {
            return new PoJoVo<>(this);
        }
    }
}
