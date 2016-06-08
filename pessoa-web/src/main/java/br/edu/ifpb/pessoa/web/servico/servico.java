
package br.edu.ifpb.pessoa.web.servico;

import br.edu.ifpb.pessoa.core.entidades.Pessoa;
import br.edu.ifpb.pessoa.core.fachada.PessoaFachada;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Aluísio
 */
@Named
@RequestScoped
public class servico {

    private Pessoa pessoa = new Pessoa();
/**
 * Construtor padrão
 */
    public servico() {
    }
/**
 * método retorna uma pessoa
 * @return 
 */
    public Pessoa getPessoa() {
        return pessoa;
    }
/**
 * método que altera uma pessoa
 * @param pessoa 
 */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
/**
 * método que retorna uma lista de pessoas
 * @return 
 */
    public List<Pessoa> lista() {
        PessoaFachada fachada = new PessoaFachada();
        return fachada.listarTodos();

    }
/**
 * Método para salvar pessoa
 * @return 
 */
    public String salvar() {
        PessoaFachada fachada = new PessoaFachada();
        boolean resultado = fachada.salvar(pessoa);
        if (resultado) {
            return "home";
        }
        return "erro";
    }

}
