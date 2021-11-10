package service;

import java.io.IOException;

public interface UserService<T> {
    void add(T t);
    int findIndexByUsername(String username);
    void edit(String username, T t) throws IOException;
    void delete(String username);
    void displayUserInformationByUsername(String username);
}
