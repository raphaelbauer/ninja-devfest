package models;

import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class PresentationPages {
    
    @Id
    public Long id;
    
    public List<PresentationPage> presentationPages;
    
    public PresentationPages() {}
    
    public PresentationPages(List<PresentationPage> presentationPages) {
        this.presentationPages = presentationPages;
    }
 
}