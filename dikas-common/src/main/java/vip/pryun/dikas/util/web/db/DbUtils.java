package vip.pryun.dikas.util.web.db;


import vip.pryun.dikas.util.StringUtils;

import java.lang.reflect.Field;

public class DbUtils {
    /**
     * 功能:      将一个dto对象中不为null的属性拼接成查询字段。
     * 例如:      GoodsParent gp = new GoodsParent;
     * gp.setId(1);
     * gp.setTitle("");
     * gp.setImgSrc("");
     * System.out.print(DbUtils.generateQueryColumns(gp));// id,title,img_src
     * 注意事项:  1.Dto类中的属性除serialVersionUID属性外不能存在默认值
     * 2.Dto类中的基本类型属性要使用对应的包装类
     *
     * @param targetDto 需要生成查询字符串的dto对象,只需要给这个dto对象中需要转换的属性设置任何一个值即可,不需要转换的属性不要设置值。
     * @return 转换后的查询字符串
     */
    public static String generateQueryColumns(Object targetDto) {
        Field[] fields = targetDto.getClass().getDeclaredFields();
        StringBuilder queryColumns = new StringBuilder();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (!field.getName().equals("serialVersionUID")) {
                    if (field.get(targetDto) != null) {
                        queryColumns.append(StringUtils.replaceToUnderlineAndLowerCase(field.getName()) + ",");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        queryColumns.deleteCharAt(queryColumns.length() - 1);
        return queryColumns.toString();
    }

}
