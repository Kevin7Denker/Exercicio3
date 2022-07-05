package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;


public class Matricula {
    
   @FXML
   private ComboBox<Curso> tfCursos;

   @FXML
   private ComboBox<Aluno> tfAluno;
    
   private Escola escola;

   public void initialize(){
      
    tfCursos.getItems().clear();
    tfCursos.getItems().addAll(escola.listarCursos());

    tfAluno.getItems().clear();
    tfAluno.getItems().addAll(escola.listarAlunos());
   
   }
   
   public Matricula(Escola escola){
       this.escola = escola;
   }

   @FXML
   private void matricular(ActionEvent evt){
    Curso curso = tfCursos.getSelectionModel().getSelectedItem();    
    Aluno aluno = tfAluno.getSelectionModel().getSelectedItem();
    
     if(escola.matricularAluno(aluno, curso)){
        
        String  msg ="O Aluno"+aluno.getNome()+"foi matriculado com sucesso"; 

        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();
    
    } else{
        String msg="Error ao matricular, porfavor tente novamente";

        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();
     }

   }
   
   @FXML
   private void desmatricula(ActionEvent evt){
    Curso curso = tfCursos.getSelectionModel().getSelectedItem();    
    Aluno aluno = tfAluno.getSelectionModel().getSelectedItem();
    
     if(escola.desmatricular(aluno, curso)){
       
        String  msg ="O Aluno"+aluno.getNome()+"foi desmatriculado com sucesso"; 

        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();

     } else {
        
        String msg="Error ao desmatricular, porfavor tente novamente";

        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();

     }
   }
    
   @FXML
   private void limpar(ActionEvent evt){
    tfCursos.getSelectionModel().clearSelection();
    tfAluno.getSelectionModel().clearSelection();
   
   } 

}
