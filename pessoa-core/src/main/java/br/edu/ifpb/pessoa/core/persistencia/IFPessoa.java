
package br.edu.ifpb.pessoa.core.persistencia;

import br.edu.ifpb.pessoa.core.entidades.Pessoa;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public interface IFPessoa {

    boolean salvar(Pessoa pessoa);
/**
 * listar todas as pessoas
 * @return 
 */
    List<Pessoa> listarTodos();

}
