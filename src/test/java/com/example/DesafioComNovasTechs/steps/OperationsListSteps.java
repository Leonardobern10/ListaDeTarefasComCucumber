package com.example.DesafioComNovasTechs.steps;


import com.example.DesafioComNovasTechs.exceptions.DescriptionStatusInvalidException;
import com.example.DesafioComNovasTechs.exceptions.StatusInvalidException;
import com.example.DesafioComNovasTechs.exceptions.StringInvalidException;
import com.example.DesafioComNovasTechs.model.ListaTarefa;
import com.example.DesafioComNovasTechs.model.StatusTarefa;
import com.example.DesafioComNovasTechs.service.ListaService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OperationsListSteps {
    private final ListaService service = new ListaService();

    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private ListaTarefa listaTarefa;

    @Given("que eu tenho uma lista criada")
    public void queEuTenhoUmaListCriada () {
        listaTarefa = new ListaTarefa();
    }

    // % - Inicio feature
    // ? - Features: Adicionar tarefa
    @And("eu informo um titulo {string}")
    public void euInformoUmTituloTituloRecebido (String tituloRecebido) {
        titulo = tituloRecebido;
    }

    @And("eu envio uma string {string} para descricao")
    public void euEnvioUmaStringDescricaoRecebidaParaDescricao (String descricaoRecebido) {
        descricao = descricaoRecebido;
    }

    @And("eu defino um status {string}")
    public void euDefinoUmStatusStatusRecebido (String statusRecebido) {
        status = StatusTarefa.fromDescription(statusRecebido);
    }

    @When("eu chamo o metodo criar tarefa")
    public void euChamoOMetodoCriarTarefa () {
        service.adicionarTarefa(titulo, descricao, status);
    }

    @Then("uma nova tarefa e adicionada na lista")
    public void umaNovaTarefaEAdicionadaNaLista () {
        Assertions.assertEquals(1, service.getSize());
    }

    @And("o titulo da tarefa e {string}")
    public void oTituloDaTarefaETituloRecebido (String tituloEsperado) {
        Assertions.assertEquals(tituloEsperado, service.getTarefa(1).getTitulo());
    }

    @And("a descricao da tarefa e {string}")
    public void aDescricaoDaTarefaEDescricaoRecebida (String descricaoEsperada) {
        Assertions.assertEquals(descricaoEsperada, service.getTarefa(1).getDescricao());
    }

    @And("o status da tarefa e {string}")
    public void oStatusDaTarefaEStatusRecebido (String statusEsperado) {
        Assertions.assertEquals(
                StatusTarefa.fromDescription(statusEsperado),
                service.getTarefa(1).getStatusTarefa()
        );
    }

    // ? - Feature: Adicionar tarefa com titulo invalido
    @When("eu informo um titulo invalido {string}")
    public void eu_informo_um_titulo_invalido(String tituloInvalidoRecebido) {
        titulo = tituloInvalidoRecebido;
    }

    // ? - Feature: Adicionar tarefa com descricao invalida
    @When("e uma descricao invalida {string}")
    public void e_uma_descricao_invalida(String descricaoRecebida) {
        descricao = descricaoRecebida;
    }

    // ? - Feature: Adicionar tarefa com status invalido
    @And("ao inserir um status {string} recebo um erro de status invalido")
    public void aoInserirUmStatusStatusRecebidoReceboUmErro (String statusRecebido) {
        Assertions.assertThrows(DescriptionStatusInvalidException.class,
                () -> service.adicionarTarefa(
                        titulo, descricao, StatusTarefa.fromDescription(statusRecebido)));
    }

    @And("e status invalido {string}")
    public void eStatusInvalidoStatusRecebido (String statusRecebido) {
        status = StatusTarefa.fromDescription(statusRecebido);
    }

    @And("e uma descricao {string}")
    public void eUmaDescricaoString (String descricaoRecebida) {
        descricao = descricaoRecebida;
    }

    @And("e status {string}")
    public void eStatusString (String statusRecebido) {
        status = StatusTarefa.fromDescription(statusRecebido);
    }

    @Then("eu recebo um erro do tipo titulo invalido")
    public void euReceboUmErroDoTipoTituloInvalido () {
       Assertions.assertThrows(StringInvalidException.class,
               () -> service.adicionarTarefa(titulo, descricao, status));
    }

    @Then("eu recebo um erro do tipo descricao invalida")
    public void euReceboUmErroDoTipoDescricaoInvalida () {
        Assertions.assertThrows(StringInvalidException.class,
                () -> service.adicionarTarefa(titulo, descricao, status));
    }

    @Then("eu recebo um erro um erro do tipo status invalido")
    public void euReceboUmErroUmErroDoTipoStatusInvalido () {
        Assertions.assertThrows(StatusInvalidException.class,
                () -> service.adicionarTarefa(titulo, descricao, status));
    }


    @And("ao inserir um status {string} recebo um erro de status inexistente")
    public void aoInserirUmStatusStatusRecebidoReceboUmErroDeStatusInexistente (String statusRecebido) {
        Assertions.assertThrows(
                StatusInvalidException.class,
                () -> service.adicionarTarefa(titulo, descricao,
                        StatusTarefa.fromDescription(statusRecebido))
        );
    }

    @And("nenhuma tarefa e adicionada")
    public void nenhumaTarefaEAdicionada () {
        Assertions.assertEquals(0, service.getSize());
    }
    // % - Fim feature

    // ? - Feature: Atualizar a lista && Remover tarefa
    @And("tem uma tarefa com titulo {string}")
    public void temUmaTarefaComTituloTituloRecebido (String tituloRecebido) {
        titulo = tituloRecebido;
    }

    @And("tem uma tarefa com descricao {string}")
    public void temUmaTarefaComDescricaoDescricaoRecebida (String descricaoRecebida) {
        descricao = descricaoRecebida;
    }

    @And("tem uma tarefa com status {string}")
    public void temUmaTarefaComStatusStatusRecebido (String statusRecebido) {
        status = StatusTarefa.fromDescription(statusRecebido);
    }

    @And("a tarefa esta cadastrada na lista")
    public void aTarefaEstaCadastradaNaLista () {
        service.adicionarTarefa(titulo, descricao, status);
    }

    // ? - Atualizar tarefa pelo Id e passando um novo status
    @When("eu quero atualizar o status de uma tarefa passando seu ID {int} e status {string}")
    public void euQueroAtualizarOStatusDeUmaTarefaPassandoSeuIDIdEsperadoEStatusStatusAtualizado (
            int id, String statusRecebido) {
        service.changeStatusTarefa(StatusTarefa.fromDescription(statusRecebido), id);
    }

    @Then("seu status passa a ser {string}")
    public void seuStatusPassaASerStatusAtualizado (String statusEsperado) {
        Assertions.assertEquals(
                StatusTarefa.fromDescription(statusEsperado),
                service.getTarefa(1).getStatusTarefa()
        );
    }

    // ? - Feature: Remover tarefa pelo Id
    @When("eu quero remover uma tarefa passando seu ID {int}")
    public void euQueroRemoverUmaTarefaPassandoSeuIDIdRemocao (int idParaRemover) {
        service.removerTarefa(idParaRemover);
    }

    @Then("a tarefa e removida da lista")
    public void aTarefaERemovidaDaLista () {
        Assertions.assertEquals(0, service.getSize());
    }

}
