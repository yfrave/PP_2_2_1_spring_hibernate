package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user, Car car);
    void add(User user);
    List<User> listUsers();

    List<User> getListCar(String model, int series);
}