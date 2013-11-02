package models;

import org.hibernate.validator.constraints.Length;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class PresentationPage {
    
    @Id
    public Long id;
    
    @Length(min=1)
    public String title;
    
    public String content;
    
    public long page;
    
    public PresentationPage() {}
    
    public PresentationPage(String title, String content) {
    	this.title = title;
        this.content = content;

    }
 
}