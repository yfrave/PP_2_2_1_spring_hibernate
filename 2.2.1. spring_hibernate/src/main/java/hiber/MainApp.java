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

        UserService userService = context.getBean(UserService.class);

        Car car = new Car("лада", 9);
        Car car1 = new Car("лада", 7);
        Car car2 = new Car("лада", 1);
        Car car3 = new Car("лада", 14);


        userService.add(new User("User2", "Lastname2", "user2@mail.ru",car));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru",car1));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru",car2));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru",car3));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        context.close();
    }
}
