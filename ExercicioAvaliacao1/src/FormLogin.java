import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormLogin {
    private JPanel panelLogin;
    private JTextField usernameTextField;
    private JButton cancelarButton;
    private JButton entrarButton;
    private JPasswordField passwordField;

    public FormLogin() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUser=usernameTextField.getText();
                String txtPass=String.valueOf(passwordField.getPassword());
                try
                {
                    Connection con=Conexao.CreateConnection();
                    String sql="Select nome, cc, nomeUtilizador, palavraPasse FROM funcionariosclube";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ResultSet resSet=ps.executeQuery();
                    boolean b =false;
                    while (resSet.next())
                    {
                        String nome=resSet.getString("nome");
                        String cc=resSet.getString("cc");
                        String nomeUtilizador=resSet.getString("nomeUtilizador");
                        String palavraPasse=resSet.getString("palavraPasse");
                        System.out.printf("%s - %s -%s",nome , cc, nomeUtilizador, palavraPasse);
                        //JOptionPane.showMessageDialog(null,nome+":"+user+"."+pass);
                        if(txtUser.equals(nomeUtilizador) &&txtPass.equals(palavraPasse))
                        {
                            new FormPrincipal().setVisible(true);
                            b=true;
                        }
                    }
                    if(!b)
                    {
                        JOptionPane.showMessageDialog(null,"Erro! Login incorreto! Password/Username errados");

                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Erro" +ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Gestao dos Jogadores");
        frame.setContentPane(new FormLogin().panelLogin);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


