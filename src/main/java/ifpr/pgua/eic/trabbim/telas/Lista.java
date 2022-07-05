package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.repositorios.Escola;

import javafx.fxml.FXML;

import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.modelos.Professor;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class Lista {

    private Escola escola;
    
    public Lista(Escola escola){
        this.escola = escola; 
    }

    @FXML
    private Label alunos;

    @FXML
    private Label professor;

    @FXML
    private ListView<Aluno> listarAluno;
    
    @FXML
    private ListView<Professor> listarProfessor;

    @FXML
    private ListView<Curso> listarCursos;

    public void initialize(){
        listarAluno.getItems().addAll(escola.listarAlunos());
        listarProfessor.getItems().addAll(escola.listarProfessores());
        listarCursos.getItems().addAll(escola.listarCursos());          

    }      

}
