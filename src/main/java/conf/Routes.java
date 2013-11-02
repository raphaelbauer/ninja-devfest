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

package conf;

import com.google.inject.Inject;

import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import ninja.utils.NinjaProperties;
import controllers.ApiController;
import controllers.ApplicationController;
import controllers.PresentationController;

public class Routes implements ApplicationRoutes {
    
    @Inject
    NinjaProperties ninjaProperties;

    /**
     * Using a (almost) nice DSL we can configure the router.
     * 
     * The second argument NinjaModuleDemoRouter contains all routes of a
     * submodule. By simply injecting it we activate the routes.
     * 
     * @param router
     *            The default router of this application
     */
    @Override
    public void init(Router router) {  
        
        // puts test data into db:
        //if (!ninjaProperties.isProd()) {
            router.GET().route("/admin/setup_first").with(ApplicationController.class, "setupFirst");
            router.GET().route("/admin/setup_second").with(ApplicationController.class, "setupSecond");
            router.GET().route("/admin/clean").with(ApplicationController.class, "clean");
        //}
        
        ///////////////////////////////////////////////////////////////////////
        // Login / Logout
        ///////////////////////////////////////////////////////////////////////
        //router.GET().route("/login").with(LoginLogoutController.class, "login");
        //router.POST().route("/login").with(LoginLogoutController.class, "loginPost");
        //router.GET().route("/logout").with(LoginLogoutController.class, "logout");
        
        ///////////////////////////////////////////////////////////////////////
        // Create new article
        ///////////////////////////////////////////////////////////////////////
        //router.GET().route("/article/new").with(ArticleController.class, "articleNew");
        //router.POST().route("/article/new").with(ArticleController.class, "articleNewPost");
        
        
        router.GET().route("/page/{page}").with(PresentationController.class, "getPage");

        ///////////////////////////////////////////////////////////////////////
        // Api for management of software
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/api/page/{page}.json").with(ApiController.class, "getPageJson");
        router.GET().route("/api/page/{page}.xml").with(ApiController.class, "getPageXml");
        
        router.GET().route("/api/pages.json").with(ApiController.class, "getPagesJson");
        //router.GET().route("/api/pages.xml").with(ApiController.class, "getPagesXml");
        router.PUT().route("/api/page/{page}.json").with(ApiController.class, "putPageJson");
        //router.POST().route("/api/page.xml").with(ApiController.class, "postPageXml");
 
        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/.*").with(AssetsController.class, "serve");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
