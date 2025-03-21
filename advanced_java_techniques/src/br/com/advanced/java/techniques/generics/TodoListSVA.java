package br.com.advanced.java.techniques.generics;

import java.util.ArrayList;
import java.util.List;

public class TodoListSVA {
    List<String> todoList = new ArrayList<>();

//    // Método para adicionar uma tarefa;
//    public void adicionarTarefas(String tarefa) {
//        todoList.add(tarefa);
//    }

//    // Método para adicionar duas tarefa;
//    public void adicionarTarefas(String tarefa1, String tarefa2) {
//        todoList.add(tarefa1);
//        todoList.add(tarefa2);
//    }

//    // Método para adicionar tarefas uma lista;
//    public void adicionarTarefas(String[] tarefas) {
//        for (String tarefa : tarefas) {
//            todoList.add(tarefa);
//        }
//    }

    /*
        A melhor forma de implementar métodos que aceita qualquer quantidade de variáveis de entrada.
        Elimina a escrita de sobrecargas de métodos.
        É mais elegante.
    */
    public void adicionarTarefas(String... tarefas) {
        for (String tarefa : tarefas) {
            todoList.add(tarefa);
        }
    }

    public class TodoListSemVarArgs {
        public static void main(String[] args) {
            TodoListSVA todoListSVA = new TodoListSVA();

            // Podemos passar a quantidade de variáveis de entrada que quisermos.
            todoListSVA.adicionarTarefas("Tarefa 1");
            todoListSVA.adicionarTarefas("Tarefa 1", "Tarefa 2");
            todoListSVA.adicionarTarefas("Tarefa 1", "Tarefa 2", "Tarefa 3");
        }
    }
}
