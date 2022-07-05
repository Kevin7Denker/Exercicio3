package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.App;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Home {
    
    private Escola escola;
    
    @FXML
    private StackPane painelCentral;
    
    @FXML
    private BorderPane root;

    @FXML
    private ToggleButton btTema;

    private String tema = "light";


    public Home(Escola escola){
        this.escola = escola;
    }

    @FXML
     private void loadCadastroAluno(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/CadastroAluno.fxml", (o) -> new CadastroAluno(escola)));
    }

    @FXML
     private void loadCadastraProfessor(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/CadastraProfessor.fxml", (o) -> new CadastraProfessor(escola)));
    }

    @FXML
     private void loadListas(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/listas.fxml", (o) -> new Lista(escola)));
    }
     
    @FXML
     private void loadCursos(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/Cursos.fxml", (o) -> new Cursos(escola)));
    }
    
    @FXML
    private void loadMatricula(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/Teste.fxml", (o) -> new Matricula(escola)));

    }

    @FXML
    private void mudaTema(){
        if(tema.equals("light")){
            tema = "dark";
            btTema.setText("Light Mode");
            root.getStylesheets().remove(App.class.getResource("css/estilo.css").toExternalForm());
            root.getStylesheets().add(App.class.getResource("css/estilo_dark.css").toExternalForm());
            
        }else{
            tema = "light";
            btTema.setText("Dark Mode");
            root.getStylesheets().add(App.class.getResource("css/estilo.css").toExternalForm());
            root.getStylesheets().remove(App.class.getResource("css/estilo_dark.css").toExternalForm());
        
        }
    }

   
} 

  
