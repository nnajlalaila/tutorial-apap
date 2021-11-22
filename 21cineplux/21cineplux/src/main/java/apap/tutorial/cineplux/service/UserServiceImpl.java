package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() {
        List<UserModel> allUser = userDB.findAll();
        return allUser;
    }

    @Override
    public void deleteUser(UserModel user){
        userDB.delete(user);
    }

    @Override
    public UserModel getUserById(String idUser){
        UserModel user = userDB.findById(idUser);
        return user;
    }

    @Override
    public UserModel getUserByUsername(String username){
        UserModel user = userDB.findByUsername(username);
        return user;
    }

    @Override
    public String changePassword(UserModel user, String pass) {
        //https://stackoverflow.com/questions/32788353/regex-with-all-special-symbols
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[a-zA-Z].*";
        String symRegex = ".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*";

        if (pass.length() >= 8){
            if(pass.matches(numRegex) && pass.matches(alphaRegex) && pass.matches(symRegex)) {
                String password = encrypt(pass);
                user.setPassword(password);
                userDB.save(user);
                return "Password berhasil diubah!";
            }
        }
        return "Password tidak sesuai ketentuan, mohon ulangi";
    }


}
