import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class FormClubes {
    private JPanel JPanelClube;
    private JTextField textFieldDesignação;
    private JButton buttonAtribuirJogadores;
    private JTextArea textAreaDadosJogadores;
    private JTextField textFieldNJogadores;
    private JTextField textFieldSalarioTotal;
    private JButton buttonGuardar;
    public FormClubes() {


        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Jogador a:FormJogadores.clube)
                {
                    if (textFieldDesignação.getText() != "" && textAreaDadosJogadores.getText() != "")
                    {
                        Clube cl = new Clube();
                        cl.setDesignação(textFieldDesignação.getText());
                        cl.setJogadores(FormJogadores.clube);
                        textFieldNJogadores.setText(String.valueOf(FormJogadores.clube.size()));
                        textFieldSalarioTotal.setText(String.valueOf(cl.SalarioAnualTotal()));

                        JOptionPane.showMessageDialog(null, "Jogador guardado com sucesso");
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Dados incompletos! Introduza a designação e atribua os jogadores, por favor!");
                    }
                }
            }
        });

        buttonAtribuirJogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Jogador a:FormJogadores.clube)
                    textAreaDadosJogadores.append(a.toString()+"\n");
            }
        });
    }

    public void setVisible(boolean b)
    {
        JFrame frame = new JFrame("Gestão de Clubes");
        frame.setContentPane(new FormClubes().JPanelClube);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
