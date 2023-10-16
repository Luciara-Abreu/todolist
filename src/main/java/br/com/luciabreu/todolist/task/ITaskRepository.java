package br.com.luciabreu.todolist.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {

  TaskModel findByTitle(String title);
  Optional<TaskModel> findById(UUID id);
  List<TaskModel> findByIdUser(UUID idUser);
}
