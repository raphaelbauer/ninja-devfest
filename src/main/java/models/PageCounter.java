package models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class PageCounter {
    
    @Id
    public Long id;
    
    //inefficient way to implement counter in GAE...
    public Long counter;
    
    public PageCounter() {}
 
}