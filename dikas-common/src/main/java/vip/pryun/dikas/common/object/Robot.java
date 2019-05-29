package vip.pryun.dikas.common.object;

/**
 * 机器操作的用户
 *
 * @author 59941
 * @date 2019/5/21 11:35
 */
public class Robot extends UnifyUser {

    private static final Robot INSTANCE = new Robot(0L, "robot");

    private Robot(Long id, String username) {
        super(id, username);
    }

    public static Robot getInstance() {
        return INSTANCE;
    }
}
