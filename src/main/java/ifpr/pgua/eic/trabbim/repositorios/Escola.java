package ifpr.pgua.eic.trabbim.repositorios;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;


import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.modelos.Professor;
import javafx.scene.Cursor;


public class Escola {
    
    private String nome;

    private String telefone;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;
    private Boolean acaju;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        professores  = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos  = new ArrayList<>();

        
    }

    public boolean cadastrarAluno ( String cpf, String nome, String email, String telefone, LocalDate dataMatricula ){
        Aluno a = new Aluno(cpf, nome, email, telefone, dataMatricula);

        if(buscarAlunoCpf(cpf)==null){
             alunos.add(a);

           return true;
        
        } else {
           
           return false;
        } 
 
        
    }
    
    public boolean cadastraProfessor ( String cpf, String nome, String email, String telefone, double salario ){       
        if(buscarProfessorCpf(cpf)==null){
             
            Professor p = new Professor(cpf, nome, email, telefone, salario); 
            professores.add(p);

           return true;

        } else {
           
           return false; 
        }
        
    }
    
    public boolean cadastrarCurso ( int codigo, String nome, String descricao, int cargaHoraria, Professor professor ){
        Curso c = new Curso(codigo, nome, descricao, cargaHoraria, professor);

        if(buscarCurso(nome)==null){
             cursos.add(c);
           
          return true; 
        } else {
          
          return false;
        }
    }
    
    

    public boolean matricularAluno (Aluno aluno, Curso curso){  
        
      if(curso.matricula(aluno)){
      
        return true;
      
      } else{ 
    
        return false;
      
      }


    }
    
    public boolean desmatricular ( Aluno aluno, Curso curso ){
    
        if(curso.desmatricula(aluno.getCpf())){
          
            return true;
        
        } else {
            
            return false;
        }
       
    }
    
    public ArrayList<Aluno> listarAlunos(){
        return alunos;


    }
    
    public ArrayList<Professor> listarProfessores (){
        return professores;
    }
    
    public ArrayList<Curso> listarCursos(){
        return cursos;
    }
    
    public ArrayList<Aluno> listarAlunosMatriculados ( Curso curso ){
        
        return alunos;
    }
    

    // -> Buscas ( Ainda nao testado ) 

    public Aluno buscarAlunoCpf ( String cpf ){
        return alunos.stream().filter(a -> a.getCpf().equals(cpf)).findAny().orElseGet(()->null);
    }
    
    public Professor buscarProfessorCpf ( String cpf ){
        return professores.stream().filter(a -> a.getCpf().equals(cpf)).findAny().orElseGet(()->null);
    }
    
    public Curso buscarCurso ( String nome ){
        return cursos.stream().filter(a -> a.getNome().equals(nome)).findAny().orElseGet(()->null);
        
    }


    
    public void salvaProfessor() throws IOException{

        File arq = new File("ARQUIVO_PROFESSOR");
        FileWriter aa = new  FileWriter (arq);
        BufferedWriter bb = new  BufferedWriter(aa);
        
        for(Professor p:professores){
            bb.write(p.paraTexto());
        }
       
        bb.close();
        aa.close();
    }

    public void salvaCurso() throws IOException{

        File arq = new File("ARQUIVO_CURSO");
        FileWriter aa = new FileWriter(arq);
        BufferedWriter bb = new BufferedWriter(aa);
   
        for(Curso c: cursos){
            bb.write(c.paraTexto());
        } 
        
        
        bb.close();
        aa.close();
    }
    
    public void salvaAluno() throws IOException{

        File arq = new File("ARQUIVO_ALUNO");
        FileWriter aa = new FileWriter(arq);
        BufferedWriter bb = new BufferedWriter(aa);

        for(Aluno a :alunos){
            bb.write(a.paraTexto());
        } 

        bb.close();
        aa.close();
    }
    
    public void leProfessor() throws IOException ,ClassNotFoundException{

        File arq = new File("ARQUIVO_PROFESSOR");
        FileInputStream aa = new FileInputStream(arq);
        ObjectInputStream bb = new ObjectInputStream(aa);

        professores = (ArrayList) bb.readObject();

        bb.close();
        aa.close();
    } 
    public void leAluno() throws IOException ,ClassNotFoundException{

        File arq = new File("ARQUIVO_ALUNO");
        FileInputStream aa = new FileInputStream(arq);
        ObjectInputStream bb = new ObjectInputStream(aa);

        alunos = (ArrayList) bb.readObject();

        bb.close();
        aa.close();
    }   
    public void leCurso() throws IOException ,ClassNotFoundException{

        File arq = new File("ARQUIVO_CURSO");
        FileInputStream aa = new FileInputStream(arq);
        ObjectInputStream bb = new ObjectInputStream(aa);

        cursos = (ArrayList) bb.readObject();

        bb.close();
        aa.close();
    }     
    
}
