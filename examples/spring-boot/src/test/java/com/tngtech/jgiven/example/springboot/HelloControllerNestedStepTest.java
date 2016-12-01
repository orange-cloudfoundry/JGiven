package com.tngtech.jgiven.example.springboot;

import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.JGivenConfiguration;
import com.tngtech.jgiven.integration.spring.SimpleSpringScenarioTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = { MockServletContext.class, HelloTestContext.class } )
@WebAppConfiguration
@JGivenConfiguration( HelloJGivenConfiguration.class )
public class HelloControllerNestedStepTest extends SimpleSpringScenarioTest<HelloStage> {

    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void nested_test() throws Exception {
        when().get( "/" );
        then().I_should_get_home_page();
    }

}