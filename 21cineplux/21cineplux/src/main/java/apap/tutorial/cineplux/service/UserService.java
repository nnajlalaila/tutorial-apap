package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    void deleteUser(UserModel user);
    UserModel getUserById(String idUser);
    String changePassword(UserModel user, String pass);
    UserModel getUserByUsername(String username);
}
