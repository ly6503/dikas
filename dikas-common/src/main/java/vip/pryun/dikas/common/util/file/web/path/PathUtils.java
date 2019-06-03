package vip.pryun.dikas.common.util.file.web.path;

import java.io.File;

import static vip.pryun.dikas.common.util.file.FileUtils.SEPARATOR;

public class PathUtils {

    public static String getTargetDirClassPath() {
        return new File(PathUtils.class.getResource("/").getPath()).getPath();
    }

    public static String getProjectPath() {
        return new File(getTargetDirClassPath()).getParentFile() // 得到target目录
                .getParentFile()// 得到模块目录
                .getParentFile().getPath();
    }

    public static String getMainJavaPath(String moduleName) {
        return getProjectPath() + SEPARATOR + moduleName + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "java";
    }

    public static String getResourcesPath(String moduleName) {
        return new File(getMainJavaPath(moduleName)).getParentFile().getPath() + SEPARATOR + "resources";
    }

}
