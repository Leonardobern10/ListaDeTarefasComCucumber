package com.example.DesafioComNovasTechs.model;

public class Tarefa {
    private String titulo;
    private String descricao;
    private StatusTarefa statusTarefa;

    public Tarefa (String titulo, String descricao, StatusTarefa statusTarefa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.statusTarefa = statusTarefa;
    }

    public Tarefa () {};

    public String getTitulo () {
        return titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatusTarefa () {
        return statusTarefa;
    }

    public void setStatusTarefa (StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    @Override
    public String toString () {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", statusTarefa=" + statusTarefa +
                '}';
    }
}
