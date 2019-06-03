package vip.pryun.dikas.service.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;

/**
 * @author CJ
 * @date 2019/5/29 21:58
 * @note
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RecruitStatusEnum {
    VACANT("空缺", 0),
    NONVACANT("不空缺", 1);

    public final String name;
    public final Integer value;
    RecruitStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static RecruitStatusEnum of(Integer value) {
        return Arrays.stream(values())
                .filter(i -> i.value.equals(value))
                .findFirst()
                .orElse(null);
    }
}
