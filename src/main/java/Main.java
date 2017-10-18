
import com.github.jofernando.projeto.tcc.model.EmpresaModel;

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
        EmpresaModel model = new EmpresaModel(EmpresaModel.BANCODADOS);

        // model.inserir(new Empresa("Teste", "123", "Razão Teste", "empresa", "senha"));
    }

}
