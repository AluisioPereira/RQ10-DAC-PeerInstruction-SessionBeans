
package br.edu.ifpb.pessoa.core.fachada;

import br.edu.ifpb.pessoa.core.entidades.Pessoa;
import br.edu.ifpb.pessoa.core.persistencia.Pessoas;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class PessoaFachada {

    private Pessoas pessoas;
/**
 * Construtor da classe
 */
    public PessoaFachada() {
        this.pessoas = new Pessoas();
    }
/**
 * Metodo para salvar pessoa
 * @param pessoa
 * @return 
 */
    public boolean salvar(Pessoa pessoa) {
        return pessoas.salvar(pessoa);
    }
/**
 * metodo para listar todas as pessoas
 * @return 
 */
public List<Pessoa> listarTodos() {
        return pessoas.listarTodos();
    }

}
