package org.xeneo.web.beans;

import java.util.List;
import java.util.Locale;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.xeneo.core.activity.Activity;
import org.xeneo.core.activity.ActivityRepository;
import org.xeneo.core.activity.Actor;
import org.xeneo.core.activity.Object;
import org.xeneo.core.security.UserService;

/**
 *
 * @author Stefan Huber
 */
@Component("stream")
@Scope("request")
public class ActivityStreamBean {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ActivityStreamBean.class);
    @Autowired
    private ActivityRepository repository;
    @Autowired
    private UserService us;
    @Autowired
    private ReloadableResourceBundleMessageSource messages;

    public void setMessages(ReloadableResourceBundleMessageSource messages) {
        this.messages = messages;
    }

    public String formatActivity(String actionURI, Actor actor, Object object, Object target) {
        
        logger.info("Format Activity: [" + actionURI + "][" + actor.getActorName() + "][" + object.getObjectName() + "]");

        java.lang.Object[] inputs = new java.lang.Object[9];
        inputs[0] = actor.getActorURI();
        inputs[1] = actor.getActorName();
        inputs[2] = messages.getMessage(object.getObjectTypeURI(), null, "", Locale.ENGLISH);
        inputs[3] = object.getObjectURI();
        inputs[4] = object.getObjectName();

        if (target == null || target.getObjectURI() == null) {
            inputs[5] = 0;
            inputs[6] = inputs[7] = inputs[8] = null;
        } else {
            inputs[5] = 1;
            inputs[6] = messages.getMessage(target.getObjectTypeURI(), null, "", Locale.ENGLISH);
            inputs[7] = target.getObjectURI();
            inputs[8] = target.getObjectName();
        }

        String print = "";
        for (int i = 0; i < inputs.length; i++) {
            print += "["+inputs[i]+"] ";
        } logger.info(print);
        
        String output = messages.getMessage(actionURI, inputs, "", Locale.ENGLISH);

        logger.info("Formated output for Activity: " + output);
        return output;
    }

    public List<Activity> getActivityStream() {
        return repository.getActivities(us.getCurrentUserURI(), 0, 20);
    }
}
