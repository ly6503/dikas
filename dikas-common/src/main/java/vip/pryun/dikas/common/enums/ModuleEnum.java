package vip.pryun.dikas.common.enums;

/**
 * 模块枚举
 *
 * @author 59941
 * @date 2019/5/30 15:55
 */
public enum ModuleEnum {

    /**
     * 文件模块
     */
    FILE("dikas-file"),
    ;

    /**
     * 模块名
     */
    private String name;

    ModuleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
