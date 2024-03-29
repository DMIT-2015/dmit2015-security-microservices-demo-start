package dmit2015.listener;

import dmit2015.entity.CallerUser;
import dmit2015.repository.CallerUserRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.logging.Logger;

@WebListener
public class ApplicationStartupListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(ApplicationStartupListener.class.getName());

    @Inject
    CallerUserRepository callerUserRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (callerUserRepository.list().size() == 0) {
            logger.info("Creating default accounts for application");
            CallerUser user01 = new CallerUser();
            user01.setUsername("user01@dmit2015.ca");
            callerUserRepository.add(user01, "Password2015", new String[]{"USER"});
            CallerUser admin01 = new CallerUser();
            admin01.setUsername("admin01@dmit2015.ca");
            callerUserRepository.add(admin01, "Password2015", new String[]{"ADMIN"});
        } else {
            logger.info("Application has user accounts");
        }
    }
}