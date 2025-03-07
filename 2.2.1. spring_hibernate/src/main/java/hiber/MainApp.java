package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class,Car.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru",new Car("lada",
              2101)));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru",new Car("lada",
              2106)));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru",new Car("lada",
              2107)));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru",new Car("lada",
              2110)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " +user.getCar());
         System.out.println();
      }
      System.out.println(
              userService.getUsersByCar("Lada",2110).toString());
      System.out.println(
              userService.getUsersByCar("Lada",2106).toString());
      System.out.println(
              userService.getUsersByCar("Lada",2107).toString());
      System.out.println(
              userService.getUsersByCar("Lada",2101).toString());
      context.close();
   }
}
