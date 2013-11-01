package models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class PresentationPage {
    
    @Id
    public Long id;
    
    public Long page;
    
    public String title;
    
    public String content;
    
    public PresentationPage() {}
    
    public PresentationPage(String title, String content) {
    	this.title = title;
        this.content = content;
    }
 
}