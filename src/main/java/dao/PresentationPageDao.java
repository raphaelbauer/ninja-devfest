package dao;

import java.util.List;

import models.PresentationPage;
import models.PresentationPages;

import com.google.inject.Singleton;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

import conf.OfyService;

@Singleton
public class PresentationPageDao {
    
    public PresentationPages getAllPresentationPages() {
        
        Objectify ofy = OfyService.ofy();
        
        PresentationPages presentationPages = new PresentationPages();
        presentationPages.presentationPages = ofy.load().type(PresentationPage.class).list();
        
        return presentationPages;
        
    }
    
    
    public PresentationPage getPresentationPage(Long page) {
        
        Objectify ofy = OfyService.ofy();
        
        PresentationPage presentationPage 
                = ofy.load().type(PresentationPage.class).filter("page", page).first().now();

        return presentationPage;
        
    }
    
    
    public void putPresentationPage(final PresentationPage presentationPage) {
        
    	final Objectify ofy = OfyService.ofy();
    	
                // first we have to get the number of presentationPages
                List<Key<PresentationPage>> presentationPages 
                        = ofy.load().type(PresentationPage.class).keys().list();
                
                // the next page gets saved with page++
                presentationPage.page = presentationPages.size() + 1L;
                
                // now save the stuff
                ofy.save().entity(presentationPage).now();

        
    }
    
    
    public void putPresentationPages(List<PresentationPage> presentationPages) {
        
        final Objectify ofy = OfyService.ofy();
        
                // first we have to get the number of presentationPages
                int presentationPagesCounter 
                        = ofy.load().type(PresentationPage.class).keys().list().size();
                
                for (PresentationPage presentationPage : presentationPages) {

                	presentationPage.page = presentationPagesCounter++;
                	ofy.save().entity(presentationPage).now();
                	
                }

    }

}
