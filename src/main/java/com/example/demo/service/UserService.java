package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.data.User;
@Service
public class UserService {
	private final UserRepository repository;
	public UserService(UserRepository repository) {
		this.repository=repository;
	}
    public List<User>getAllUsers(){
    	List<User> users=new ArrayList<>();
//    	users.add(new User("Fallou","Ndiaye"));
//    	users.add(new User("Aphsatou","Dia"));
//    	users.add(new User("Mody","Cissoko"));
//    	users.add(new User("Ndeye Fatou","deme"));
    	return users;
    	
    }
    public List<User>findAllUsers(){
    	List<User>userstotal=new ArrayList<>();
    	Iterable <User>liste=repository.findAll();
     	liste.forEach(x->userstotal.add(x));
   	return userstotal;
    }
    public User findUserById(Long id) {
    	return repository.findById(id).orElse(null);
    	
    }
    public Collection<User> findUserByLastName(String lastName) {
    	return repository.findByLastName(lastName);
    	
    }
    public void addUser(User user) {
    	repository.save(user);
    }
    public void deleteUserById(Long id) {
    	repository.deleteById(id);
    }
    public void updateUser(User user) {
    	Optional<User>older=repository.findById(user.getId());
    	if(null!=older) {
    		repository.save(user);
    	}
    	
    }
}
