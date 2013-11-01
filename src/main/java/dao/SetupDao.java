package dao;

import com.google.appengine.repackaged.com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.List;


import com.googlecode.objectify.Objectify;

import static conf.OfyService.ofy;
import models.PresentationPage;

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
        
        
        PresentationPage presentationPageTheProblemNinjaAndAppEngineMakesMeSmile = new PresentationPage(
        		"The problem",
                "<img class='img-center img-responsive' src='/assets/ninja_appengine_that_makes_me_smile'>"
        );
        
        allPagesToPut.add(presentationPageTheProblemNinjaAndAppEngineMakesMeSmile);
        
        
        
        putAllPages(allPagesToPut);
    }
    
    public void clean() {

        Objectify ofy = ofy();
        
        List<PresentationPage> presentationPages 
                = ofy.load().type(PresentationPage.class).list();
        
        ofy.delete().entities(presentationPages).now();
       
    }
    
    private void putAllPages(List<PresentationPage> allPagesToPut) {
    	
    	
    	for(PresentationPage presentationPage : allPagesToPut) {
    		presentationPageDao.putPresentationPage(presentationPage);
    	}
    	
    	
    }

}
