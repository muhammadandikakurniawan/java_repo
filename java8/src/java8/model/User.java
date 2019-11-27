package java8.model;

import java.util.*;
import java8.Java8;

public class User {
    private String name;
    private String email;
    
    public User(String... data){
        this.name = data[0];
        this.email = data[1];
    }
    
    public void set_email(String data){
        this.email = data;
    }
    
    public String get_name(){
       return this.name;
    }
    
    public String get_email(){
       return this.email;
    }
}
