/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xeneo.web.beans;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.xeneo.core.plugin.*;
import org.xeneo.core.security.UserService;

/**
 * @author Stefan Huber
 */
@Component("apm")
@Scope("session")
public class ActivityPluginManagementBean {

    private static Logger logger = LoggerFactory.getLogger(ActivityPluginManagementBean.class);
    
    @Autowired
    private PluginConfigurator pcm;
    
    @Autowired
    private UserService us;
    
    private List<PluginConfiguration> plugs;

    public List<PluginConfiguration> getPlugins() {        
        
        plugs = pcm.listAvailablePlugins(us.getCurrentUserURI(),new PluginType[]{PluginType.ACTIVITY_PLUGIN});
        
        logger.info(plugs.size() + " Plugins available! ");
        for (PluginConfiguration pc : plugs) {            
            logger.info("Plugin with title " + pc.getTitle() + " was retrieved...");
            logger.info("Plugin class is: " + pc.getPluginClass());
        }             
        
        return plugs;
    }
    
    public void setPlugins(List<PluginConfiguration> pcs) {
        plugs = pcs;
    }    
 
    public String configurePlugin() {

        logger.info("plugin Configuration called!");       
        
        // TODO: find a better solution, than updating all plugins, just find the id of the changed one somehow and update it...
        for (PluginConfiguration pc : plugs) {
            pcm.configurePlugin(pc);
            logger.info("Plugin with title " + pc.getTitle() + " is configured as follows: ");
            logger.info("Plugin Class: " +pc.getPluginClass());
            for (PluginProperty p : pc.getProperties()) {
                logger.info(p.getName() + ": " + p.getValue());
            }
        }       
        
        return "/plugin-management.jsf";
    }
}
