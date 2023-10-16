package br.com.luciabreu.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    var task = this.taskRepository.findByTitle(taskModel.getTitle());
    System.out.println();

    var idUser = request.getAttribute("idUser");
    taskModel.setId((UUID) idUser);

    var currentDate = LocalDateTime.now();
    if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Data de inicio / data de termino deve ser maior que a data atual");
    }
    if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("A sata de inicio deve ser menor que a data de termino.");
    }

    if (task != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task Já cadastrada");
    }

    task = this.taskRepository.save(taskModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(task);
  }

  @GetMapping("/")
  public List<TaskModel> list(HttpServletRequest request) {
    var idUser = request.getAttribute("idUSer");
    var tasks = this.taskRepository.findByIdUser((UUID) idUser);
    return tasks;
  }

}
