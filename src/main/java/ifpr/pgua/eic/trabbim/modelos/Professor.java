package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;
public class Professor extends Pessoa implements Serializable{
    
    private double salario;

    public Professor(String cpf, String nome, String email, String telefone, double salario) {
        super(cpf, nome, email, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return super.getNome();
    }

    public String paraTexto(){
        return super.getNome()+"; "+super.getEmail()+"; "+super.getCpf()+"\n"+"\n";
    }
}
