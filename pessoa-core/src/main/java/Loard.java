
import br.edu.ifpb.pessoa.core.entidades.Pessoa;
import br.edu.ifpb.pessoa.core.persistencia.Pessoas;

/**
 *
 * @author Aluísio
 */
public class Loard {
    public static void main(String[] args) {
        Pessoa p =new Pessoa("Paulo");
        Pessoas pAdd = new Pessoas();
        boolean f = pAdd.salvar(p);
        System.err.println("Processo: "+f);
    }
}
