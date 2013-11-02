package conf;

import models.PageCounter;
import models.PresentationPage;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Best practise for Objectify to register your entities.
 * 
 * @author ra
 * 
 */
public class OfyService {
    
    static {

        ObjectifyService.register(PresentationPage.class);
 

    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

    
    
}
