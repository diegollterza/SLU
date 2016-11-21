package slu.controller;

import java.util.HashSet;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import slu.db.HibernateUtil;
import slu.model.Contato;
import slu.model.Usuario;
import slu.view.LoginForm;
import slu.view.StartScreen;
import slu.view.UserRegisterForm;

public class MainController {

    private StartScreen mView1;
    private Usuario usuarioAtual;

    public MainController(StartScreen view) {
        mView1 = view;
        mView1.setMainController(this);
    }

    public void showLoginForm() {
        new LoginForm(this);
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public void showUserRegisterForm() {

    }

    public void logar(String login, String senha) throws Exception {
        if (login == null || login.length() < 5 || senha == null || senha.length() < 5) {
            throw new Exception("Senha ou nome de usuario inválido");
        }
        Session sessao = HibernateUtil.getSessao();
        Usuario usuario = new Usuario();
        Iterator i = sessao.createQuery("from Usuario where login = '" + login + "' AND senha = '" + senha + "'").list().iterator();
        if (!i.hasNext()) {
            throw new Exception("Usuario inexistente");
        }
        usuarioAtual = (Usuario) i.next();
    }

    public void deslogar() {
        usuarioAtual = null;
    }

    public void cadastrarNovoUsuario(String login, String nome, String senha,
            String cep, String endereco, Integer numero, String complemento, String bairro, String cidade, String uf, String telefone, String email) throws Exception {
        if (nome.length() < 5 || senha.length() < 5) {
            throw new Exception("Senha ou nome de usuario inválido.");
        }
        try {
            Session sessao = HibernateUtil.getSessao();
            Usuario usuario = new Usuario((int) (System.currentTimeMillis() / 1000), login, nome, senha);
            Contato contato = new Contato((int) (System.currentTimeMillis() / 1000), cep, endereco, numero, complemento, bairro, cidade, uf, telefone, email, new HashSet(0), new HashSet(0));
            usuario.setContato(contato);
            sessao.save(contato);
            sessao.save(usuario);
            Transaction tr = sessao.beginTransaction();
            tr.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao gravar no banco. Verifique os dados inseridos.");
        }
    }

    public void alterarUsuario(String nome, String senha,
            String cep, String endereco, Integer numero, String complemento, String bairro, String cidade, String uf, String telefone, String email) throws Exception {

        Session sessao = HibernateUtil.getSessao();
        try {
            Contato contato = usuarioAtual.getContato();
            contato.setBairro(bairro);
            contato.setCep(cep);
            contato.setCidade(cidade);
            contato.setComplemento(complemento);
            contato.setEmail(email);
            contato.setEndereco(endereco);
            contato.setNumero(numero);
            contato.setTelefone(telefone);
            contato.setUf(uf);
            usuarioAtual.setNome(nome);
            usuarioAtual.setSenha(senha);
            sessao.update(contato);
            sessao.update(usuarioAtual);
            Transaction tr = sessao.beginTransaction();
            tr.commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            //sessao.close();
        }
    }

    public void excluirUsuario() throws Exception {
        try {
            Session sessao = HibernateUtil.getSessao();
            sessao.delete(usuarioAtual);
            Transaction tr = sessao.beginTransaction();
            tr.commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void showCadastrarNovoUsuario() {
        new UserRegisterForm(this);
    }

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        //</editor-fold>

        StartScreen screen = new StartScreen();
        MainController controller = new MainController(screen);
        screen.setMainController(controller);
    }

}
