package com.example.DesafioComNovasTechs.model;

import java.util.HashMap;

public class ListaTarefa {
    private HashMap<Integer, Tarefa> content;

    public ListaTarefa () {
        content = new HashMap<>();
    }

    public HashMap<Integer, Tarefa> getContent () {
        return content;
    }

    public void setContent (HashMap<Integer, Tarefa> content) {
        this.content = content;
    }
}
