package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> removerTarefas = new ArrayList<>();
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                removerTarefas.add(tarefa);
            }
        }
        this.tarefas.removeAll(removerTarefas);
    }

    public int obterNumeroTotalTarefas() {
        return this.tarefas.size();
    }

    public void obterDescricoesTares() {
        System.out.println(this.tarefas);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Estudar Java");
        System.out.println("Total de elementos na lista " + listaTarefa.obterNumeroTotalTarefas());
        listaTarefa.obterDescricoesTares();
        listaTarefa.removerTarefa("Estudar Java");
        System.out.println("Total de elementos na lista " + listaTarefa.obterNumeroTotalTarefas());
    }
}
