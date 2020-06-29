package cn.edu.suda.bookmanagement.util;

import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/11/16.
 */
public class BeanUtil {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BeanUtil.class);

    private static Mapper instance;

    public static synchronized Mapper getInstance() {
        if(instance == null) {
            instance = new DozerBeanMapper();
        }

        return instance;
    }

    public static void copyProperties(Object destObj, Object srcObj) throws Exception{
        if( srcObj instanceof Map){
            try{
                BeanUtils.copyProperties(destObj, srcObj);
            }catch(Exception e){
                log.error("Src Obj:{}, dest Obj:{}", StringUtil.toJsonString(srcObj), StringUtil.toJsonString(destObj), e);
            }
        }else {
            copy(srcObj, destObj);
        }
    }

    public static <T> T convert(Object src, Class<T> toClass) {
        try {
            T obj = toClass.newInstance();
            copy(src, obj);
            return obj;
        }catch(Exception e){
            log.error("Fail to instance {}", toClass, e);
        }

        return null;
    }

    public static void copy(Object src, Object target) throws Exception{

        if(src == null || target == null){
            return;
        }

        try{
            getInstance().map(src, target);
        }catch(Exception e){
            log.error("Src Obj:{}, dest Obj:{}", StringUtil.toJsonString(src), StringUtil.toJsonString(target), e);
            throw new RuntimeException("Copy object error!", e);
        }
    }

    public static <S, T> List<T> convertList(List<S> sourceList, Class<S> sourceClass, Class<T> targetClass) throws Exception{
        List<T> datas = new ArrayList<>();
        if (sourceList != null && !sourceList.isEmpty()) {
            T tmpBean;
            for (S entity : sourceList) {
                tmpBean = newInstance(targetClass);
                BeanUtil.copy(entity, tmpBean);
                datas.add(tmpBean);
            }
        }
        return datas;
    }

    private static <T> T newInstance(Class<T> targetClass) {
        T tmpBean =null;
        try {
            tmpBean = targetClass.newInstance();
        } catch (Exception ex) {
            log.error("targetClass.newInstance() error:", ex);
        }
        return tmpBean;
    }

    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法

                    Method readMethod = property.getReadMethod();

                    if (readMethod != null) {
                        Object value = readMethod.invoke(obj);
                        if (value instanceof Date) {
                            value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value);
                        }
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    /**
     * list排序
     *
     * @param list
     * @param sortBy
     * @param order
     * @param <T>
     * @return
     */
    public static <T> void sortList(List<T> list, String sortBy, String order) {
        if (StringUtils.isEmpty(sortBy) || StringUtils.isEmpty(order)) {
            return;
        }
        list.sort((T o1, T o2) -> {
            try {
                Field[] sonFileds = o1.getClass().getDeclaredFields();
                Field[] superFileds = o1.getClass().getSuperclass().getDeclaredFields();
                Field[] allFields = new Field[sonFileds.length + superFileds.length];
                System.arraycopy(sonFileds, 0, allFields, 0, sonFileds.length);
                System.arraycopy(superFileds, 0, allFields, sonFileds.length, superFileds.length);
                Field sortField = null;
                for (Field field : allFields) {
                    if (field.getName().equals(sortBy)) {
                        sortField = field;
                        sortField.setAccessible(true);
                        break;
                    }
                }
                if (sortField == null) {
                    return 0;
                }

                Object ob1 = sortField.get(o1);
                Object ob2 = sortField.get(o2);
                if (ob1 instanceof Comparable) {
                    return eleCompare((Comparable) ob1, (Comparable) ob2, order);
                } else {
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        });
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable> int eleCompare(T ob1, T ob2, String order) {
        if (order.toLowerCase().equals("asc")) {
            return ob1.compareTo(ob2);
        } else if (order.toLowerCase().equals("desc")) {
            return ob2.compareTo(ob1);
        } else {
            throw new IllegalArgumentException("order must be asc or desc");
        }
    }
}
