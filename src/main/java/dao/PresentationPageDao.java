package dao;

import java.util.List;

import models.Article;
import models.ArticleDto;
import models.User;

import com.googlecode.objectify.Objectify;

import conf.OfyService;
import models.PresentationPage;
import models.PresentationPages;

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
    
    
    public void putPresentationPage(PresentationPage presentationPage) {
        
        Objectify ofy = OfyService.ofy();
        
        // first we have to get the number of presentationPages
        List<PresentationPage> presentationPages 
                = ofy.load().type(PresentationPage.class).order("page").list();
        
        // the next page gets saved with page++
        presentationPage.page = presentationPages.size() + 1L;
        
        // now save the stuff
        ofy.save().entity(presentationPage).now();
        
    }

}
