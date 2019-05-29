package vip.pryun.dikas.mybatis.annotation.property;

import java.lang.annotation.*;

/**
 * 使用大于等于符号比较的属性
 *
 * @author 59941
 * @date 2019/4/25 21:36
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GE {
    /**
     * 数据库的列名,如果不设置.那么就以属性名转换的下划线命名作为列名
     *
     * @return
     */
    String value() default "";
}