package br.com.luciabreu.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  // Criar tarefa para usuário logado
  @PostMapping("/")
  public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    var task = this.taskRepository.findByTitle(taskModel.getTitle());

    var idUser = request.getAttribute("idUser");
    taskModel.setIdUser((UUID) idUser);

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

  // Listar todas as tasks do usuário logado
  @GetMapping("/")
  public List<TaskModel> list(HttpServletRequest request) {
    var thisIdUser = request.getAttribute("idUser");
    var tasks = this.taskRepository.findByIdUser((UUID) thisIdUser);
    return tasks;
  }

  // Atualizar uma task passando o Id da task
  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@RequestBody TaskModel taskModel, @PathVariable UUID id,
      HttpServletRequest request) {
    var optionalTask = this.taskRepository.findById(id);

    if (optionalTask.isPresent()) {
      var idUser = request.getAttribute("idUser");
      taskModel.setIdUser((UUID) idUser);
      taskModel.setId(id);

      TaskModel updatedTask = this.taskRepository.save(taskModel);
      return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
  }

}
