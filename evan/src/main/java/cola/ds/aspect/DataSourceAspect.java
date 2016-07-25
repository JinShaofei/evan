package cola.ds.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import cola.annotation.DataSource;
import cola.ds.holder.DynamicDataSourceHolder;

/**
 * aop
 * 
 * @author shaofeijin
 *
 */
public class DataSourceAspect {

    /**
     * 数据源动态配置类
     */
    public void before(JoinPoint point) {

        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            DataSource ds = method.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.putDataSource(ds.value());
        }
    }

}