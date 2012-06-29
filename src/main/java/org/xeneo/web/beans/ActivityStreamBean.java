
package org.xeneo.web.beans;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xeneo.core.activity.Activity;
import org.xeneo.core.activity.ActivityStream;

/**
 *
 * @author Stefan Huber
 */

@Component("stream")
@Scope("request")
public class ActivityStreamBean {
    
    @Autowired
    private ActivityStream as;  
    
    public List<Activity> getActivityStream() {
        return as.getActivities("http://blub", "http://blab", 50);
    }    
    
    public String getTestString() {
        return "Hello World";
    }
}
