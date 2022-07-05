package ifpr.pgua.eic.trabbim.telas;


import java.time.LocalDate;

import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CadastroAluno {
    
    @FXML
    private TextField tfNome;
    
    @FXML
    private TextField tfCpf;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfTelefone;
    
    @FXML
    private DatePicker tfDataMatricula;

    private Escola escola;

    public CadastroAluno(Escola escola){
        this.escola = escola;
    }
    
    

   
    @FXML
    private void adicionar(ActionEvent Event){
       
       String nome = tfNome.getText();
       String cpf = tfCpf.getText();
       String email = tfEmail.getText();
       String telefone = tfTelefone.getText();

       LocalDate dataMatricula = tfDataMatricula.getValue();

      
       
       String msg;
       
       boolean confirm = true;
       
      if(confirm){
        boolean alun = escola.cadastrarAluno(cpf, nome, email, telefone, dataMatricula);

        msg = "O Aluno "+nome+" foi cadastrado com sucesso";

      } else{ 
         msg = "Error";
      }

      Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();
         
    }
    
    @FXML
    private void limpar(ActionEvent Event){

      tfCpf.clear();
      tfNome.clear();
      tfDataMatricula.setValue(LocalDate.now());
      tfEmail.clear();
      tfTelefone.clear();

    }     
    
    
}


