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

import com.google.inject.Inject;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;

import com.google.inject.Singleton;

import conf.OfyService;
import dao.SetupDao;

@Singleton
@FilterWith(AppEngineFilter.class)
public class ApplicationController {
    
    @Inject
    SetupDao setupDao;
    
    public ApplicationController() {

    }
    
    /**
     * Method to put initial data in the db...
     * @return
     */
    public Result setupFirst() {
        
        setupDao.setupFirst();
        
        return Results.ok().renderRaw("ok");
        
    }
    
        /**
     * Method to put initial data in the db...
     * @return
     */
    public Result setupSecond() {
        
        setupDao.setupSecond();
        
        return Results.ok().renderRaw("ok");
        
    }
    
    
   /**
     * Method to put initial data in the db...
     * @return
     */
    public Result clean() {
        
        setupDao.clean();
        
        return Results.ok().renderRaw("ok");
        
    }
}
