
import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosClienteDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Revendedor;

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

        Revendedor revend = new Revendedor();

        if (revend.getPassword().isEmpty()) {
            System.out.println(" Senha NULO");
            throw new NullPointerException("lll");

        } else {
            System.out.println("Não nulo");
        }

    }

}
