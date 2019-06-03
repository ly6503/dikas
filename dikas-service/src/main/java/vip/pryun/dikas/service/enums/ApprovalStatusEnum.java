package vip.pryun.dikas.service.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;

/**
 * @author CJ
 * @date 2019/5/31 10:16
 * @note
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApprovalStatusEnum {
    UNAPPROVED("未审批", 0),
    APPROVED("通过", 0),
    REFUSE ("拒绝", 0);
    public final String name;
    public final Integer value;

    ApprovalStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static ApprovalStatusEnum of (Integer value) {
        return Arrays.stream(values())
                .filter(i -> i.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
