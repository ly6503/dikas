package vip.pryun.dikas.common.object;


import vip.pryun.dikas.common.enums.Msg;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    public static final String SUCCESS = "success";
    private static final long serialVersionUID = -2410305335190791152L;
    private int code;
    private String message;
    private List<String> messages;
    private T content;

    public Result() {
        this.code = 0;
        this.message = SUCCESS;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Msg msg) {
        this.code = msg.code();
        this.message = msg.message;
    }

    public static Result success() {
        return new Result();
    }

    public static <T> Result<T> success(T content) {
        Result<T> result = new Result<>();
        result.setContent(content);
        return result;
    }

    public static Result<String> message(String message) {
        Result<String> result = new Result<>();
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> error(Msg msg) {
        return new Result<>(msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMessages() {
        return messages;
    }

    public Result<T> setMessages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    public T getContent() {
        return content;
    }

    public Result<T> setContent(T content) {
        this.content = content;
        return this;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }
}
