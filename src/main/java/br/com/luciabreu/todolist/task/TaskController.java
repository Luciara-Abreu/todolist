package br.com.luciabreu.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luciabreu.todolist.user.UserModel;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody TaskModel taskModel){
    var task = this.taskRepository.findByTitle(taskModel.getTitle());

    if (task != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task Já cadastrada");
    }

    task = this.taskRepository.save(taskModel); 
    return ResponseEntity.status(HttpStatus.CREATED).body(task);    
  }
}
