package dao;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;


import com.googlecode.objectify.Objectify;

import static conf.OfyService.ofy;
import models.PresentationPage;

@Singleton
public class SetupDao {
    
    @Inject
    PresentationPageDao presentationPageDao;
    
    public void setupFirst() {

    	clean();
    	
    	List<PresentationPage> allPagesToPut = Lists.newArrayList();
        
        PresentationPage presentationPageFrontPage = new PresentationPage(
        		"Ninja",
                "<h1 class='text-center'>Ninja<br/><br/>the very best web application framework<br/> for the App Engine</h1>" +
                "<br/><br/>" +
                "<h3 class='text-center'>http://www.ninjaframework.org" +
                "<br/>" +
                "@ninjaframework</h3>"
        );
        
        allPagesToPut.add(presentationPageFrontPage);
        
        PresentationPage presentationPageOverview = new PresentationPage(
        		"Overview",
                "<ul>" +
                "<li>What is the App Engine...</li>" +
                "<li>Why will you need Ninja?</li>" +
                "<li>Anatomy of a Ninja application</li>" +
                "<li>Persistence with App Engine and Ninja</li>" +
                "<li>Designing a nice Json Api</li>" +
                "</ul>" 
        );
        allPagesToPut.add(presentationPageOverview);
        
        PresentationPage presentationPageWhatIsTheAppEngine = new PresentationPage(
        		"What is the AppEngine?",
                "<ul>" +
                "<li>A servlet engine in the cloud</li>" +
                "<li>A servlet engine that scales on demand</li>" +
                "<li>A NoSQL datastore in the cloud</li>" +
                "<li>And much more: Email service, Channels, Caching Api, etc pp</li>" +
                "<li>In essence: It saves you from having your own IT Services department. Your deployment architecture just works and scales.</li>" +
                "</ul>" 
        );
        allPagesToPut.add(presentationPageWhatIsTheAppEngine);
        
        PresentationPage presentationPageTheProblem1 = new PresentationPage(
        		"The problem",
                "<img class='img-center img-responsive' src='/assets/img/hey_app_engine_is_great_but_what_about_the_devlopers.jpg'>"
        );
        
        allPagesToPut.add(presentationPageTheProblem1);
        
        
        
        PresentationPage presentationPageTheProblem2 = new PresentationPage(
        		"The problem",
                "<ul>" +
                "<li>No simple setup and build</li>" +
                "<li>No automated hot reload</li>" +
                "<li>No nice restful routes, Html, Json, Xml</li>" +
                "<li>No integrated Html, Json, Xml support</li>" +
                "<li>No authorization / authentication</li>" +
                "<li>No simple and fast testing</li>" +
                "<li>No IoC support</li>" +
                "<li>...</li>" +
                "</ul>" 
        );
        allPagesToPut.add(presentationPageTheProblem2);
        
        PresentationPage presentationPageTheProblemPicardProblem = new PresentationPage(
        		"The problem",
                "<img class='img-center img-responsive' src='/assets/img/setting_up_everything_myself_thats_hard_work.jpg'>"
        );
        
        allPagesToPut.add(presentationPageTheProblemPicardProblem);


        putAllPages(allPagesToPut);

    }
    
    public void setupSecond() {
    	
    	List<PresentationPage> allPagesToPut = Lists.newArrayList();
    	
    	
    	
        PresentationPage presentationPageTheProblemPicardSolution = new PresentationPage(
        		"The problem",
                "<img class='img-center img-responsive' src='/assets/img/no_bug_just_kidding.jpg'>"
        );
        
        allPagesToPut.add(presentationPageTheProblemPicardSolution);
        
        
        PresentationPage presentationPageTheProblem2 = new PresentationPage(
        		"Layout of a Ninja application",
                "<ul>" +
                "<li>Routes</li>" +
                "<li>Controller</li>" +
                "<li>Views</li>" +
                "</ul>" 
        );
        allPagesToPut.add(presentationPageTheProblem2);
        
        PresentationPage presentationPageDemoTime = new PresentationPage(
        		"Demo Time",
                "<h1 class='text-center'>Demo time!</h1>"
        );
        allPagesToPut.add(presentationPageDemoTime);
        
        
        PresentationPage presentationPageTheProblemNinjaAndAppEngineMakesMeSmile = new PresentationPage(
        		"The problem",
                "<img class='img-center img-responsive' src='/assets/img/ninja_appengine_that_makes_me_smile.jpg'>"
        );
        
        allPagesToPut.add(presentationPageTheProblemNinjaAndAppEngineMakesMeSmile);
        
        
        
        PresentationPage presentationPageTwoMoreThings1= new PresentationPage(
        		"One more thing #1",
                "<ul>" +
                "<li>mvn archetype to start full featured Ninja appengine project</li>" +
                "<li>http://www.ninjaframework.org</li>" + 
                "<li>https://github.com/ninjaframework/ninja-appengine</li>" +
                "<li>https://github.com/raphaelbauer/ninja-devfest</li>" +
                "</ul>" 
        );
        allPagesToPut.add(presentationPageTwoMoreThings1);
        
        PresentationPage presentationPageTwoMoreThings2= new PresentationPage(
        		"One more thing #2",
                "<ul>" +
                "<li>Ninja is NOT restricted to the App Engine</li>" +
                "<li>Runs on servlet containers / applications servers</li>" +
                "<li>Runs as self executing fat jar</li>" +
                "<li>Works with Google Cloud SQL, Heroku...</li>" + 
                
                "</ul>"
        		
        );
        allPagesToPut.add(presentationPageTwoMoreThings2);
        
        
        PresentationPage presentationPageTwoMoreThings3 = new PresentationPage(
        		"One more thing #3",
                		"<p class='text-center'>stateless scaleable architecture, client side sessions, " +
                        "authorization, authentication, caching support, validation support and error reporting, " +
                        "form parsing, objectify persistence, guice-persist based jpa, database migrations, " +
                        "configuration management for test, dev, excellent i18n support, extendability via modules, " +
                        "static assets service, startup actions, filters, webjars support etag support, friendly community, " +
                        "objectify’s excellent api, doctests, mocked tests</p>"
        );
        allPagesToPut.add(presentationPageTwoMoreThings3);
        
        
        
        
        PresentationPage presentationPageThanks = new PresentationPage(
        		"Thanks!*",
                "<ul>" +
                "<li>Thanks for your attention!</li>" +
                "<li>Thanks for all contributors to Ninja!</li>" +
                "<li>Thanks to the organizers of the DevFest and Google :)</li>" +
                "<li>http://www.ninjaframework.org</li>" +
                "</ul>" + 
                "<h5 class='pager_middle'>*ps idea stolen from Martin Görner</h5>"
        );
        allPagesToPut.add(presentationPageThanks);
        
        
	
        	
        
        putAllPages(allPagesToPut);
    }
    
    public void clean() {

        Objectify ofy = ofy();
        
        List<PresentationPage> presentationPages 
                = ofy.load().type(PresentationPage.class).list();
        
        ofy.delete().entities(presentationPages).now();
       
    }
    
    private void putAllPages(List<PresentationPage> allPagesToPut) {

    		presentationPageDao.putPresentationPages(allPagesToPut);
    	
    }

}
