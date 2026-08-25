/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Lucas
 */
public class Veiculo {
    private int idveiculo;
    private String modelo;
    private String marca;
    private String placa;
    private int ano;
    private Pessoa pessoa;
    
    
    public Veiculo(){
        
    }
     public Veiculo(int idveiculo, String modelo, String marca, String placa, int ano, Pessoa pessoa) {
        this.idveiculo = idveiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.pessoa = pessoa;
        
    }
     public Veiculo( String modelo, String marca, String placa, int ano, Pessoa pessoa) {
       
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.pessoa = pessoa;
        
    }
     
    
     
     public int getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}

    

   
