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
import models.PresentationPages;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import ninja.params.PathParam;
import ninja.validation.JSR303Validation;
import ninja.validation.Validation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.googlecode.objectify.Objectify;

import conf.OfyService;
import dao.PresentationPageDao;

@Singleton
@FilterWith(AppEngineFilter.class)
public class ApiController {
	
	@Inject
	PresentationPageDao presentationPageDao;
	
	public Result getPageJson(@PathParam("page") Long page) {
		
		PresentationPage presentationPage = presentationPageDao.getPresentationPage(page);
		
		return Results.json().render(presentationPage);
		
		
	}
	
	public Result getPagesJson() {
		
		PresentationPages presentationPages = presentationPageDao.getAllPresentationPages();
		
		return Results.json().render(presentationPages);
		
		
	}
	
	public Result putPageJson(
			@PathParam("page") Long page, 
			@JSR303Validation PresentationPage presentationPage,
			Validation validation) {
		
		if (validation.hasViolations()) {
			
			return Results.badRequest().render(new String("Error."));
			
		} else {
			
			Objectify ofy = OfyService.ofy();
			
			ofy.save().entity(presentationPage).now();
			
			return Results.json().render(presentationPage);
			
		}
		
	}
	
	public Result getPageXml(@PathParam("page") Long page) {
		
		PresentationPage presentationPage = presentationPageDao.getPresentationPage(page);
		
		return Results.xml().render(presentationPage);
		
	}
    
    
}
