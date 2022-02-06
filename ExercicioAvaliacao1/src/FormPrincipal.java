import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPrincipal {
    private JPanel JPanelPrincipal;
    private JButton jogadoresButton;
    private JButton clubesButton;

    public FormPrincipal() {
        jogadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new FormJogadores().setVisible(true);

            }
        });
        clubesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new FormClubes().setVisible(true);
            }
        });
    }

    public void setVisible(boolean b)
    {
        JFrame frame=new JFrame("Gestao dos Jogadores");
        frame.setContentPane(new FormPrincipal().JPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
