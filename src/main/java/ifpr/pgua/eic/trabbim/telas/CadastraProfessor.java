package ifpr.pgua.eic.trabbim.telas;



import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class CadastraProfessor{
    
    @FXML
    private TextField tfNome;
    
    @FXML
    private TextField tfCpf;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfSalario;

    private Escola escola;
    
    public CadastraProfessor(Escola escola){
        this.escola = escola;
    }
    
    public void initialize(){
     
    }

    @FXML
    private void adicionar(ActionEvent event ){
        
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        Double salario = Double.valueOf(tfSalario.getText());
        String msg;
        // apenas para poder fazer o if kk
        boolean confirm = true; 
        
        if(confirm){
          
          boolean prof = escola.cadastraProfessor(cpf, nome, email, telefone, salario);

          msg = "O Professor "+nome+" foi cadastrado com sucesso";
          limpar(null);

        } else {

          msg = "ERROR";
        }
       
        Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();
    }
    
    @FXML
     private void limpar(ActionEvent Event){

      tfCpf.clear();
      tfNome.clear();
      tfSalario.clear();
      tfEmail.clear();
      tfTelefone.clear();

    }  
}
