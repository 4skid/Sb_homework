package main;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import main.model.Task;
import main.model.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Типы запросов")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks/")
    @Operation(summary = "Метод возвращающий весь список дел")
    public List<Task> tasks() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        taskIterable.forEach(tasks::add);
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    @Operation(summary = "Получение дела по id")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping("/tasks/")
    @Operation(summary = "Добавление дела")
    public int add(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @PutMapping("/tasks/{id}")
    @Operation(summary = "Обновление дела по id")
    public ResponseEntity<?> put(@PathVariable int id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        updatedTask.setId(id);
        taskRepository.save(updatedTask);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/")
    @Operation(summary = "Удаление списка дел")
    public ResponseEntity<?> delete() {
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        if (taskList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(summary = "Удаление дела по id")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
