package com.taskmanager.Task.controller;

import com.taskmanager.Task.model.Task;
import com.taskmanager.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Lista todas as tasks.
    @GetMapping("/listagem")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //Exibe a task pelo id mandado na requisição pelo front ou via URL.
    @GetMapping("/busca/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.getTaskById(id);

        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Cria uma nova task.
    @PostMapping("/criar")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);

        return ResponseEntity.ok(createdTask);
    }

    //Atualiza uma task existente.
    @PutMapping("/atualizar")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        try{
            Task updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(updatedTask);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    //Deleta uma task.
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        try{
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    //Volta a ultima alteração.
    @PostMapping("/desatualizar")
    public ResponseEntity<Task> undoLastChange(){
        try{
            Task lastTask = taskService.undoLastChange();
            return ResponseEntity.ok(lastTask);
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().build();
        }
    }

    //Lista as notificações.
    @GetMapping("/notificacoes")
    public Queue<String> getNotifications(){
        return taskService.getNotifications();
    }

    //Lista as tarefas por categorias.
    @GetMapping("/categories")
    public Map<String, List<Task>> getTaskByCategory(){
        return taskService.getTasksByCategory();
    }
}
