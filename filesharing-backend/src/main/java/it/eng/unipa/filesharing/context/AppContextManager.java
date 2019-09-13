package it.eng.unipa.filesharing.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AppContextManager implements ApplicationContextAware{
    private static ApplicationContext _appCtx;

    @Override
    public void setApplicationContext(ApplicationContext ctx){
         _appCtx = ctx;
    }

    public static ApplicationContext getAppContext(){
        return _appCtx;
    } 
}