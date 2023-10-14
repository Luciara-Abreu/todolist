package br.com.luciabreu.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
  Object findByUserName = null;

  UserModel findByUserName(String userName);

}
