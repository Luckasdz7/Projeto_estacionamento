/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Pessoa {
    private int idpessoa;
    private String nome;
    private String cpf;
    private List<Veiculo> veiculo;

    public Pessoa(int idpessoa, String nome, String cpf, List<Veiculo> veiculo) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.veiculo = veiculo;
    }
    public Pessoa(){
        
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
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

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
    
    
}
