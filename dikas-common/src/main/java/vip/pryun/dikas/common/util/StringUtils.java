package vip.pryun.dikas.common.util;

public class StringUtils {
    /**
     * 将一个字符串中的大写字母替换为：_小写字母
     * 如：optionName转换为: option_name
     *
     * @param srcString 被转换的字符串
     * @return 转换后的字符串
     */
    public static String replaceToUnderlineAndLowerCase(String srcString) {
        String lowerString = srcString.toLowerCase();
        if (!srcString.equals(lowerString)) {
            StringBuilder targetString = new StringBuilder();
            char[] srcChars = srcString.toCharArray();
            for (int i = 0; i < srcChars.length; i++) {
                if (srcChars[i] >= 'A' && srcChars[i] <= 'Z') {
                    targetString.append("_");
                    targetString.append(lowerString.toCharArray()[i]);
                } else {
                    targetString.append(srcChars[i]);
                }
            }
            return targetString.toString();
        } else {
            return srcString;
        }
    }

    /**
     * 得到字符串中的扩展名<br/>
     * 如果传入的字符串没有扩展名或为空,则返回空串
     *
     * @param parseStr 被解析的字符串
     * @return
     */
    public static String getExtensionName(String parseStr) {
        if (parseStr == null || parseStr.length() == 0) {
            return "";
        }

        int dotIndex = parseStr.lastIndexOf('.');
        return (dotIndex == -1) ? "" : parseStr.substring(dotIndex + 1);
    }
}
