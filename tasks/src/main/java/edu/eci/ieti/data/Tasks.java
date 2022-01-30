package edu.eci.ieti.data;

import edu.eci.ieti.dto.TaskDto;
import edu.eci.ieti.enums.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tasks {

    private String id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
    private String created;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public Tasks(TaskDto taskDto, LocalDate localDate, String id) {
        this.id=id;
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.assignedTo = taskDto.getAssignedTo();
        this.dueDate = taskDto.getDueDate();
        this.created = dateTimeFormatter.format(localDate);
    }

    public Tasks(TaskDto taskDto, String created, String id) {
        this.id=id;
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.assignedTo = taskDto.getAssignedTo();
        this.dueDate = taskDto.getDueDate();
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
