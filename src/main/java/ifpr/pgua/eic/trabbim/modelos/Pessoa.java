package ifpr.pgua.eic.trabbim.modelos;

public class Pessoa {
    
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    
    public Pessoa(String cpf, String nome, String email, String telefone) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
   
}
