package service;
public interface UserService<T> {
    void add(T t);
    int findIndexByUsername(String username);
    void edit(String username, T t);
    void delete(String username);
    void displayUserInformationByUsername(String username);
}
