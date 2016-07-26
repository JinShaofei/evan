package cola.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author shaofeijin
 *
 */
public class ApplicationContextHolder {

    private static ApplicationContext context;

    public static ApplicationContext getContainer() {

        if (context == null) {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return context;
    }

    public static <T> T getBeanByClazz(Class<T> clazz) {
        return getContainer().getBean(clazz);
    }

}
