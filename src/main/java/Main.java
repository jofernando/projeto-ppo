
import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosClienteDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;
import com.github.jofernando.projeto.tcc.model2.RevendedorModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando
 */
public class Main {

    public static void main(String[] args) {
        // Persistence.createEntityManagerFactory("UnidadeDePersistencia");

        // Cliente cliTeste = new Cliente("Junio", "email", "telefone", "endereco", "cpf");
        BancoDeDadosClienteDAO persiste = new BancoDeDadosClienteDAO();

        //   persiste.inserir(cliTeste);
        RevendedorModel model = new RevendedorModel(1);
        Revendedor revendedor = new Revendedor();
        revendedor.setPassword("12345");
        revendedor.setUsername("jrjr");
        model.inserir(revendedor);

    }

}
