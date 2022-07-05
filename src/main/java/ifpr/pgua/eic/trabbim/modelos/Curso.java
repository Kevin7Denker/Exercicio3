package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import ifpr.pgua.eic.trabbim.repositorios.Escola;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
public class Curso implements Serializable{
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;
    private Escola escola;


    public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
     
    public boolean matricula(Aluno aluno){   
      
      Aluno alu;
      
       alu = alunos.stream().filter(a -> a.getCpf().equals(aluno.getCpf())).findAny().orElseGet(()->null);
                
       if( alu == null){
    
         alunos.add(aluno);  
         
       }         
       return false;
    }

    public boolean desmatricula(String cpf){
        
        Aluno aluno;
      
        aluno = alunos.stream().filter(a -> a.getCpf().equals(cpf)).findAny().orElseGet(()->null);
        
        if(aluno==null){
           
            String msg; 

            msg="Erro, O aluno nao esta cadastrado no nosso banco de dados";

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
               
            return false;
       
        } else{
            
          alunos.remove(aluno);   
             
        }
 
        return true;     
          
    }

    public int getCodigo() {
        return codigo;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String toString(){
        return nome;
    }
    
    public String paraTexto(){
      return nome+"; "+codigo+"; "+professor+"\n"+"\n";
    }
}
