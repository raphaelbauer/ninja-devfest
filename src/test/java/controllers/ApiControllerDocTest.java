/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.PresentationPage;
import models.PresentationPages;
import ninja.NinjaApiDocTest;

import org.junit.Test;

import de.devbliss.apitester.ApiResponse;

public class ApiControllerDocTest extends NinjaApiDocTest {
    
	
	String GET_SETUP_PAGES = "/admin/setup_first";
	
	String GET_PAGES_URL = "/api/pages.json";
	 
    String GET_PAGE_URL = "/api/page/{page}.json";
    String PUT_PAGE_URL = "/api/page/{page}.json";

    @Test
    public void testJsonApi() throws Exception {
    	
    	makeGetRequestSilent(buildUri(GET_SETUP_PAGES));

        
        sayNextSection("Retrieving all presentation pages (Json)");
        
        say("Retrieving all presentation pages is a GET request to " + GET_PAGES_URL);
        
        ApiResponse apiResponse = makeGetRequest(
        		buildUri(
        				GET_PAGES_URL.replace("{page}", "1")));

        PresentationPages presentationPages = apiResponse.payloadJsonAs(PresentationPages.class);

        assertEqualsAndSay(
        		7, presentationPages.presentationPages.size(), "We got back 7 pages - as expected");
        
        // page 1
        say("Retrieving all presentation pages is a GET request to " + GET_PAGES_URL);
        apiResponse = makeGetRequest(
        		buildUri(
        				GET_PAGE_URL.replace("{page}", "0")));

        PresentationPage presentationPage = apiResponse.payloadJsonAs(PresentationPage.class);

        assertEqualsAndSay("Ninja", presentationPage.title, "Contains correct title");
        
        
        // testing pushing
        apiResponse = makePutRequest(
        		buildUri(
        				PUT_PAGE_URL.replace("{page}", "0")), presentationPage);
        
        assertEqualsAndSay(presentationPage.title, presentationPage.title, "We get back stuff...");


        
        say("The title must at least have one character, otherwise putting does not work.");
        presentationPage.title = "";
        
        apiResponse = makePutRequest(
        		buildUri(
        				PUT_PAGE_URL.replace("{page}", "0")), presentationPage);
        assertEqualsAndSay(400, apiResponse.httpStatus, "Violation of the model results in a status code 400");
        
        

    }


    @Override
    protected String getFileName() {
        return this.getClass().getSimpleName();
    }

}
