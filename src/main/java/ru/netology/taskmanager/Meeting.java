package ru.netology.taskmanager;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project; // заполнение своих полей
        this.start = start; // заполнение своих полей
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        return query != null && !query.isEmpty() &&
                (topic != null && topic.contains(query)
                        || project != null && project.contains(query));
    }
}
