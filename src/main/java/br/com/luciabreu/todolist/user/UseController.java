package br.com.luciabreu.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UseController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/")
  public UserModel create(@RequestBody UserModel userModel){
    System.out.println(userModel.getName());

    var userCreated = this.userRepository.save(userModel);
    return userCreated;
  }


}
