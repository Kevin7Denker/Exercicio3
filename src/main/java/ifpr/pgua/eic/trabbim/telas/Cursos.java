package ifpr.pgua.eic.trabbim.telas;


import ifpr.pgua.eic.trabbim.modelos.Professor;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

public class Cursos{

   @FXML
   private TextField tfNome;

   @FXML
   private TextField tfDescricao;

   @FXML
   private TextField tfCargaHorario;

   @FXML
   private ComboBox<Professor> tfProfessor;
   
   @FXML
   private TextField tfCodigo; 
    

   private Escola escola;    

   public Cursos(Escola escola){
      this.escola = escola;
   }
   
   public void initialize(){
    tfProfessor.getItems().clear();
    tfProfessor.getItems().addAll(escola.listarProfessores());


   }


   @FXML
   private void adicionar(ActionEvent evt){
      
     String nome = tfNome.getText();  
     String descricao = tfDescricao.getText();
     int codigo = Integer.valueOf(tfCodigo.getText());  
     int cargaHoraria = Integer.valueOf(tfCargaHorario.getText());
     Professor professor = tfProfessor.getSelectionModel().getSelectedItem();

     boolean cur = escola.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor);
      
     String msg = "O Aluno "+nome+" foi cadastrado com sucesso";

     Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
     alert.showAndWait();
      
   }
 
   @FXML
   private void limpar(ActionEvent Event){
    tfNome.setText("");  
    tfDescricao.setText("");
    tfCodigo.setText("");  
    tfCargaHorario.setText("");
    tfProfessor.getSelectionModel().clearSelection();
   }

}