package ru.iemz.adwords;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 * класс - держатель спрингового контекста
 */
public class SpringContextStaticHolder {


    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringContextStaticHolder.class);

    private static final String CONTEXT_FILENAME = "/applicationContext.xml";
    private static final ApplicationContext CONTEXT;


    static {
        ApplicationContext tmp = null;
        try{
             tmp = new ClassPathXmlApplicationContext(CONTEXT_FILENAME);
        } catch (Exception e){
            LOGGER.error("Unable to initialize spring context with name: {}. Reason: {}",
                    CONTEXT_FILENAME,
                    e.getMessage());
            System.exit(1);
        }
        CONTEXT = tmp;
    }

    public static ApplicationContext getContext(){
        return CONTEXT;
    }

}
