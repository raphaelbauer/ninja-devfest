/**
 * Copyright (C) 2012 the original author or authors.
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
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import ninja.params.PathParam;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dao.PresentationPageDao;

@Singleton
@FilterWith(AppEngineFilter.class)
public class PresentationController {

    @Inject
    PresentationPageDao presentationPageDao;
    
    public PresentationController() {

    }

    public Result getPage(@PathParam("page") Long page) {

        PresentationPage presentationPage  
                = presentationPageDao.getPresentationPage(page);
        

    	return Results
            .html()
            .render("title", presentationPage.title)
            .render("content", presentationPage.content)
            .render("previousPage", page - 1)
            .render("nextPage", page + 1);
        

    }

}