package conf;

import models.Article;
import models.User;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import java.util.List;
import models.PresentationPage;

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
