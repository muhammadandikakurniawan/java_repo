package java8;

import java.util.*;
import java8.model.*;

public class Java8 {

    public static void main(String[] args) {
//        List<User> users = new ArrayList<User>(){
//            {
//                add(new User("dika","dika@gmail.com"));
//                add(new User("dimas","dimas@gmail.com"));
//                add(new User("kamsito","kamsito@gmail.com"));
//                add(new User("wati","wati@gmail.com"));
//            }
//        };

        List<User> users = Arrays.asList(
            new User("dika","dika@gmail.com"),
            new User("dimas","dimas@gmail.com"),
            new User("kamsito","kamsito@gmail.com"),
            new User("wati","wati@gmail.com")
        );
        
        User user = users.stream().filter(el -> el.get_name().equalsIgnoreCase("dika"));
        
        System.out.println(user.get_name());
    }
    
}
