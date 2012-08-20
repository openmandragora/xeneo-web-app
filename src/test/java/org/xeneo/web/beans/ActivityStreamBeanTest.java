/*
 * Copyright 2012 XENEO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xeneo.web.beans;

import java.util.Locale;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xeneo.core.activity.Actor;
import org.xeneo.core.activity.Object;
import org.xeneo.core.vocabulary.Actions;
import org.xeneo.core.vocabulary.ObjectTypes;

/**
 *
 * @author Stefan
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class ActivityStreamBeanTest {
    
    private static final Logger logger = LoggerFactory.getLogger(ActivityStreamBeanTest.class);
    
    @Autowired
    private ReloadableResourceBundleMessageSource ms;
    
    public ActivityStreamBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        asb = new ActivityStreamBean();
        asb.setMessages(ms);
    }
    
    @After
    public void tearDown() {
    }

    private ActivityStreamBean asb;
    
    @Test
    public void testFormat() {
    
        String message = ms.getMessage("message1", null, Locale.ENGLISH);
        message += ms.getMessage("message2", null, Locale.ENGLISH);
        message += ms.getMessage("message3", null, Locale.ENGLISH);
        
        // asb.formatActivity("http://activitystrea.ms/schema/1.0/add", new Actor("http://test.xeneo.org/test-actor","Test Actor","..."), new Object("http://somewhere.com","Object Name",ObjectTypes.bookmark.URI), new Object("http://something.com","Target Name",ObjectTypes.tag.URI));
        // asb.formatActivity(Actions.add.URI, new Actor("http://test.xeneo.org/test-actor","Test Actor","..."), new Object("http://somewhere.com","Object Name",ObjectTypes.bookmark.URI), new Object());
        
        logger.info(message);
            
    }
}
