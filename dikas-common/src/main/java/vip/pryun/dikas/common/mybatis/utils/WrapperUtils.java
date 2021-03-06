package vip.pryun.dikas.common.mybatis.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import vip.pryun.dikas.common.mybatis.annotation.property.*;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.dto.Sort;
import vip.pryun.dikas.common.util.ReflectUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Wrapper操作类
 *
 * @author 59941
 * @date 2019/4/25 14:12
 */
public class WrapperUtils {

    /**
     * <p>根据{@link C}类中的属性上的注解添加查询条件.</p>
     * <p><b>注意:</b>C类中继承超类的属性上的注解不会进行判断</p>
     *
     * @param condition 含有查询注解的对象
     * @param <T>       Bean的类型
     * @param <C>       condition属性的类型
     * @return
     */
    public static <T, C> QueryWrapper<T> getConditionWrapper(C condition) {
        if (condition == null) {
            throw new IllegalArgumentException("condition对象不能为null");
        }

        QueryWrapper<T> conditionWrapper = new QueryWrapper<>();

        Field[] conditionFields = condition.getClass().getDeclaredFields();

        Map<String, Between> betweenMap = Maps.newHashMap();

        for (Field conditionField : conditionFields) {
            if (conditionField.getDeclaredAnnotations().length == 0) {
                continue;
            }

            // 属性有@Equal注解
            if (conditionField.isAnnotationPresent(Equal.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(Equal.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.eq(columnName, columnValue);

                continue;
            }

            // 属性有@GT注解
            if (conditionField.isAnnotationPresent(GT.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(GT.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.gt(columnName, columnValue);

                continue;
            }

            // 属性有@GE注解
            if (conditionField.isAnnotationPresent(GE.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(GE.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.ge(columnName, columnValue);

                continue;
            }

            // 属性有@LT注解
            if (conditionField.isAnnotationPresent(LT.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(LT.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.lt(columnName, columnValue);

                continue;
            }

            // 属性有@LE注解
            if (conditionField.isAnnotationPresent(LE.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(LE.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.le(columnName, columnValue);

                continue;
            }

            // 属性有@Like注解
            if (conditionField.isAnnotationPresent(Like.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(Like.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.like(columnName, columnValue);

                continue;
            }

            // 属性有@LikeLeft注解
            if (conditionField.isAnnotationPresent(LikeLeft.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(LikeLeft.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.likeLeft(columnName, columnValue);

                continue;
            }

            // 属性有@LikeRight注解
            if (conditionField.isAnnotationPresent(LikeRight.class)) {
                String fieldName = conditionField.getName();

                Object columnValue = ReflectUtils.getFieldValue(condition, fieldName);
                if (columnValue == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(LikeRight.class).value();

                // 未设置列名,则将驼峰格式的属性名转下划线作为列名
                if (StringUtils.isEmpty(columnName)) {
                    columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
                }
                conditionWrapper.likeRight(columnName, columnValue);

                continue;
            }

            // 属性有@BetweenStart注解
            if (conditionField.isAnnotationPresent(BetweenStart.class)) {
                String fieldName = conditionField.getName();

                Object betweenStart = ReflectUtils.getFieldValue(condition, fieldName);
                if (betweenStart == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(BetweenStart.class).value();

                if (betweenMap.get(columnName) != null) {
                    Between between = betweenMap.get(columnName);
                    if (between.getBetweenEnd() != null) {
                        conditionWrapper.between(columnName, betweenStart, between.getBetweenEnd());
                        betweenMap.remove(columnName);
                    } else {
                        between.setBetweenStart(betweenStart);
                    }
                } else {
                    Between between = new Between();
                    between.setBetweenStart(betweenStart);
                    betweenMap.put(columnName, between);
                }

                continue;
            }

            // 属性有@BetweenEnd注解
            if (conditionField.isAnnotationPresent(BetweenEnd.class)) {
                String fieldName = conditionField.getName();

                Object betweenEnd = ReflectUtils.getFieldValue(condition, fieldName);
                if (betweenEnd == null) {
                    continue;
                }

                String columnName = conditionField.getDeclaredAnnotation(BetweenEnd.class).value();

                if (betweenMap.get(columnName) != null) {
                    Between between = betweenMap.get(columnName);
                    if (between.getBetweenStart() != null) {
                        conditionWrapper.between(columnName, between.getBetweenStart(), betweenEnd);
                        betweenMap.remove(columnName);
                    } else {
                        between.setBetweenEnd(betweenEnd);
                    }
                } else {
                    Between between = new Between();
                    between.setBetweenEnd(betweenEnd);
                    betweenMap.put(columnName, between);
                }

                continue;
            }
        }

        return conditionWrapper;
    }

    /**
     * <p>首先构造一个含有排序条件的QueryWrapper对象,然后根据{@link C}类中的属性上的注解添加查询条件.</p>
     * <p><b>注意:</b>C类中继承超类的属性上的注解不会进行判断</p>
     *
     * @param queryParam
     * @param <T>        Bean的类型
     * @param <C>        QueryParam的condition属性的类型
     * @return
     */
    public static <T, C> QueryWrapper<T> getWrapper(QueryParam<C> queryParam) {
        QueryWrapper<T> conditionWrapper = getConditionWrapper(queryParam.getCondition());

        return addSort(conditionWrapper, queryParam);
    }

    /**
     * 给QueryWrapper对象添加排序条件
     *
     * @param wrapper
     * @param queryParam
     * @return
     */
    private static <T, C> QueryWrapper<T> addSort(QueryWrapper<T> wrapper, QueryParam<C> queryParam) {
        List<Sort> sorts = queryParam.getSorts();

        // 添加排序条件
        if (!CollectionUtils.isEmpty(sorts)) {
            sorts.forEach(sort -> {
                if (StringUtils.isNotBlank(sort.getSortColumn()) && StringUtils.isNotBlank(sort.getSortType())) {
                    String sortColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort.getSortColumn());

                    // 添加升序列
                    if (SqlKeyword.ASC.getSqlSegment().equals(sort.getSortType())) {
                        wrapper.orderByAsc(sortColumn);
                    }

                    // 添加降序列
                    if (SqlKeyword.DESC.getSqlSegment().equals(sort.getSortType())) {
                        wrapper.orderByDesc(sortColumn);
                    }
                }
            });
        }

        return wrapper;
    }

    /**
     * 构造一个只含有排序条件的QueryWrapper对象
     *
     * @param queryParam
     * @return
     */
    public static <T, C> QueryWrapper<T> getSortWrapper(QueryParam<C> queryParam) {
        return addSort(new QueryWrapper<>(), queryParam);
    }

    private static final class Between {
        private Object betweenStart;
        private Object betweenEnd;

        public Object getBetweenStart() {
            return betweenStart;
        }

        public void setBetweenStart(Object betweenStart) {
            this.betweenStart = betweenStart;
        }

        public Object getBetweenEnd() {
            return betweenEnd;
        }

        public void setBetweenEnd(Object betweenEnd) {
            this.betweenEnd = betweenEnd;
        }
    }
}