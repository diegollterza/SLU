
import java.io.File;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import slu.db.HibernateUtil;
import slu.model.Contato;
import slu.model.Universidades;

public class Tester {

    public static void main(String args[]) throws Exception {
        int i = 0;
        //Cria a sessao do hibernate
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        //Inicia a transacao.
        Transaction tr = sessao.beginTransaction();

        try {
            //Escanear o arquivo a procura de linhas.
            Scanner scanner = new Scanner(new File("/home/tiago/Downloads/CADASTRO-DAS-IES_2011_3.csv"));
            while (scanner.hasNextLine()) {
                final String linha = scanner.nextLine();
                final String[] partes = linha.split("#");
                //Todas devem ter 39 colunas.
                if (partes.length != 39) {
                    System.out.println(linha);
                    continue;
                }

                String CO_ANO = partes[0].trim();
                String CO_IES = partes[1].trim();
                String NO_IES = partes[2].trim();
                String SG_IES = partes[3].trim();
                String NU_CNPJ = partes[4].trim();
                String REGIES = partes[5].trim();
                String REGIAOIES = partes[6].trim();
                String COUFIES = partes[7].trim();
                String NOMEUFIES = partes[8].trim();
                String SIGLA = partes[9].trim();
                String MUNICIPIOIES = partes[10].trim();
                String COMUNICIES = partes[11].trim();
                String COMUNICIES12 = partes[12].trim();
                String LOCIES = partes[13].trim();
                String LOCALIES = partes[14].trim();
                String ORG = partes[15].trim();
                String NOMEORG = partes[16].trim();
                String COREDE = partes[17].trim();
                String REDE = partes[18].trim();
                String CO_DEP = partes[19].trim();
                String DEPADM = partes[20].trim();
                String DEP5 = partes[21].trim();
                String DEPADM5 = partes[22].trim();
                String MANT = partes[23].trim();
                String MANTENEDORA = partes[24].trim();
                String NU_CEP = partes[25].trim();
                String DS_ENDERECO = partes[26].trim();
                String DS_NUMERO_ENDERECO = partes[27].trim();
                String DS_COMPLEMENTO_ENDERECO = partes[28].trim();
                String NO_BAIRRO = partes[29].trim();
                String NU_TELEFONE = partes[30].trim();
                String NU_FAX = partes[31].trim();
                String TX_EMAIL = partes[32].trim();
                String TX_PAGINA_ELETRONICA = partes[33].trim();
                String NO_PROCURADOR_INSTITUCIONAL = partes[34].trim();
                String NU_CPF_PROCURADOR = partes[35].trim();
                String NU_TELEFONE_PROCURADOR = partes[36].trim();
                String TX_EMAIL_PROCURADOR = partes[37].trim();
                String NIES = partes[38].trim();

                //if(true) continue;
                //Vamos adicionar as universidades.
                //Primeiro seu contato.
                Contato contato = new Contato();
                contato.setCep(NU_CEP);
                contato.setEndereco(DS_ENDERECO);
                try {
                    contato.setNumero(Integer.parseInt(DS_NUMERO_ENDERECO));
                } catch (Exception e) {
                    contato.setNumero(null);
                }
                contato.setComplemento(DS_COMPLEMENTO_ENDERECO);
                contato.setBairro(NO_BAIRRO);
                contato.setCidade(MUNICIPIOIES);
                contato.setUf(SIGLA.toLowerCase());
                contato.setTelefone(NU_TELEFONE);
                contato.setEmail(TX_EMAIL.split("[;,/]")[0].trim());
                contato.setId(i);

                //Depois a universidade
                Universidades uni = new Universidades();
                try {
                    uni.setId(Integer.parseInt(CO_IES));
                } catch (Exception e) {
                    System.out.println(linha);
                    continue;
                }
                uni.setContato(contato);
                uni.setNome(NO_IES);
                uni.setSigla(SG_IES);
                uni.setCnpj(NU_CNPJ);
                switch (ORG) {
                    case "1":
                        uni.setOrgAcademica("univ");
                        break;
                    case "4":
                        uni.setOrgAcademica("facul");
                        break;
                    case "2":
                        uni.setOrgAcademica("centrouniv");
                        break;
                    case "6":
                        uni.setOrgAcademica("ifect");
                        break;
                }
                switch (COREDE) {
                    case "1":
                        uni.setRede("publica");
                        break;
                    case "2":
                        uni.setRede("privada");
                }
                switch (CO_DEP) {
                    case "1":
                        uni.setCatAdmin("federal");
                        break;
                    case "2":
                        uni.setCatAdmin("estadual");
                        break;
                    case "3":
                        uni.setCatAdmin("municipal");
                        break;
                    case "4":
                        uni.setCatAdmin("privada");
                }

                uni.setMantenedora(MANTENEDORA);
                uni.setSite(TX_PAGINA_ELETRONICA);
                uni.setProcurador(NO_PROCURADOR_INSTITUCIONAL);
                uni.setCpfProcurador(NU_CPF_PROCURADOR);

                System.out.println(NO_IES);
                sessao.save(contato);
                sessao.save(uni);
                i++;
            }

            tr.commit(); //Comita as inserções.
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            sessao.close();
        }

        System.exit(0);

        /*
        //ADICIONAR USUARIO
        Contato contato = new Contato();
        contato.setCep("37503012");
        contato.setEndereco("Rua Gusmao Lobo");
        contato.setNumero(100);
        contato.setBairro("Vila Poddis");
        contato.setTelefone("999688921");
        contato.setEmail("tiago.henrique.cco@gmail.com");

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Tiago");
        usuario.setSenha("gggg");
        usuario.setContato(contato);

        sessao.save(usuario);

        Transaction tr = sessao.beginTransaction();
        tr.commit();

        sessao.close();
         */
 /*
       //ADICIONAR UNIV
       Contato contato = new Contato();
       contato.setCep("37503012");
       contato.setEndereco("Avenida BPS");
       contato.setNumero(100);
       contato.setBairro("Pinheirinho");
       contato.setTelefone("999688921");
       contato.setEmail("unifei@gmail.com");
       contato.setCidade("Itajuba");
       contato.setUf("mg");

       Universidades uni = new Universidades();
       uni.setId(1);
       uni.setCatAdmin("federal");
       uni.setContato(contato);
       uni.setCnpj("455354343");
       uni.setCpfProcurador("45433356332");
       uni.setMantenedora("BBBBBBB");
       uni.setNome("Universidade Federal de Itajubá");
       uni.setProcurador("Bosco");
       uni.setOrgAcademica("univ");
       uni.setRede("publica");
       uni.setSigla("UNIFEI");
       uni.setSite("unifei.edu.br");

       sessao.save(contato);
       sessao.save(uni);

        Transaction tr = sessao.beginTransaction();
        tr.commit();

        sessao.close();
         */
 /*
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return;
        }
        System.out.println("Opened database successfully");
         */
    }
}
