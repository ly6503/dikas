package vip.pryun.dikas.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Msg {
    S00000("成功", "S00000"),
    E40000("未知的错误信息", "E40000"),
    E40001("需要登录", "E40001"),
    E40002("登录失败：错误的用户名或密码", "E40002"),
    E40003("没有权限：您没有权限请求当前信息", "E40003"),
    E40004("登录过期：您的身份验证已过期，请重新登录", "E40004"),
    E40011("参数错误", "E40011"),
    E40012("参数类型错误", "E40012"),
    E40013("上传文件超出限制大小", "E40013"),
    E40014("未做任何修改", "E40014"),
    E40015("短信验证频繁,次日恢复", "E40015"),
    E40016("验证码无效", "E40016"),
    E40017("邮件发送失败", "E40017"),
    E40018("无查询结果", "E40018"),
    E20001("您已报名过活动,请核对你的报名表单!", "E20001"),

    /**
     * A40000~A40299用于景点
     */
    A40001("查询失败", "A40001"),
    /**
     * E40200~E40299用于景点
     */
    E40201("添加景点信息失败", "E40201"),
    E40202("修改景点信息失败", "E40202"),
    E40203("删除景点失败", "E40203"),
    E40204("修改景点状态失败", "E40204"),

    /**
     * F00001用于人才招聘
     */
    F00001("投递失败或该职位已招满，请刷新页面再投递！", "F00001"),
    F00002("添加招聘职位失败，或该招聘职位已存在", "F00002"),
    F00004("操作失败", "F00004"),
    ;

    private static final Pattern NUMPTN = Pattern.compile("\\d{5}");

    public final String message;
    public final String code;

    Msg(String message, String code) {
        this.message = message;
        this.code = code;

    }

    public int code() {
        Matcher matcher = NUMPTN.matcher(this.name());
        return matcher.find() ? Integer.parseInt(matcher.group(0)) : 0;
    }

    public boolean isError() {
        return this.name().startsWith("E");
    }

    public String getMessage() {
        return message;
    }

}
