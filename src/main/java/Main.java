
import com.github.jofernando.projeto.tcc.model.dao.impl.BancoDeDadosClienteDAO;
import com.github.jofernando.projeto.tcc.model.entidades.Cliente;

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
        Cliente novoCli = persiste.buscar(1);
        System.out.println("CPF: " + persiste.buscar(1).getCpf());
        novoCli.setCpf("095");
        persiste.alterar(novoCli);
        System.out.println("CPF: " + persiste.buscar(1).getCpf());

    }

}
