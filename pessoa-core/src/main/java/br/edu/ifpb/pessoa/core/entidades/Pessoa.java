
package br.edu.ifpb.pessoa.core.entidades;

/**
 *
 * @author Aluísio
 */
public class Pessoa {
    private int id;
    private String nome;
/**
 * Construtor
 * @param nome 
 */
    public Pessoa(String nome) {
       this.nome= nome;
    }
/**
 * Construtor padrão
 */
    public Pessoa() {
    }
    
/**
 * Retorna o id de pessoa
 * @return 
 */
    public int getId() {
        return id;
    }
/**
 * altera o id de pessoa
 * @param id 
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * retorna o nome de pessoa
 * @return 
 */
    public String getNome() {
        return nome;
    }
/**
 * altera o nome de pessoa
 * @param nome 
 */
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
 * imprimi a pessoa
 * @return 
 */
    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + '}';
    }   
}
