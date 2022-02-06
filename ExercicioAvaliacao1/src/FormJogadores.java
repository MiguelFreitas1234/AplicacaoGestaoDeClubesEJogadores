import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class FormJogadores {
    private JTabbedPane TabbedPane1;
    private JTextField textFieldAltPesquisa;
    private JButton altPesquisarButton;
    private JTextField textFieldAltNome;
    private JTextField textFieldAltIdade;
    private JTextField textFieldAltPeso;
    private JButton altAlterarButton;
    private JTextField textFieldAltAltura;
    private JTextField textFieldAltNCamisola;
    private JFormattedTextField textFieldAltMorada;
    private JTextField textFieldAltPosição;
    private JTextField textFieldAltRemuneração;
    private JTextArea textAreaConsultar;
    private JButton encontrarJogadorButton;
    private JTextField textFieldEliNome;
    private JTextField textFieldEliSalario;
    private JTextField textFieldEliPosição;
    private JButton dadosParaApagarJogadorButton;
    private JTextArea textAreaDadosParaApagar;
    private JTextField textFieldEliIdade;
    private JTextField textFieldNomeJogadorAApagar;
    private JPanel JPanelJogador;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldPosicao;
    private JTextField textFieldMorada;
    private JTextField textFieldAltura;
    private JTextArea textAreaSalarioAnual;
    private JTextField textFieldNCamisola;
    private JTextField textFieldRemuneracao;
    private JButton guardarJogadorButton;
    private JTextArea textAreaIMC;
    private JTextField textFieldPeso;
    private JButton novoJogadorButton;

    public static ArrayList<Jogador> clube = new ArrayList<Jogador>();
    public static Jogador jgd;

    public void setVisible(boolean b)
    {
        JFrame frame = new JFrame("Gestao de Jogadores");
        frame.setContentPane(new FormJogadores().JPanelJogador);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FormJogadores() {
        guardarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((textFieldNome.getText() != "") && (textFieldIdade.getText() != "")) {
                    jgd = new Jogador();

                    jgd.Nome=textFieldNome.getText();
                    jgd.Idade=Integer.parseInt(textFieldIdade.getText());
                    jgd.Morada=textFieldMorada.getText();
                    jgd.Peso=Double.parseDouble(textFieldPeso.getText());
                    jgd.Altura=Double.parseDouble(textFieldAltura.getText());
                    jgd.NCamisola=Integer.parseInt(textFieldNCamisola.getText());
                    jgd.Posição=textFieldPosicao.getText();
                    jgd.Remuneração=Double.parseDouble(textFieldRemuneracao.getText());
                    textAreaSalarioAnual.setText(String.valueOf(jgd.SalarioAnual()));
                    textAreaIMC.setText(String.valueOf(jgd.MassaCorporal()));

                    clube.add(jgd);

                    JOptionPane.showMessageDialog(null, "Jogador guardado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Dados incompletos: Introduza o nome e a idade por favor!");
                }
            }
        });

        novoJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaSalarioAnual.setText("");
                textAreaIMC.setText("");
                textFieldRemuneracao.setText("");
                textFieldAltura.setText("");
                textFieldPeso.setText("");
                textFieldIdade.setText("");
                textFieldNome.setText("");
                textFieldPosicao.setText("");
                textFieldNCamisola.setText("");
                textFieldMorada.setText("");
            }
        });

        TabbedPane1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textAreaConsultar.setText("");
                for(Jogador jgd:clube)
                    textAreaConsultar.append(jgd.toString()+"\n");
            }
        });

        altAlterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jgd.setNome(textFieldAltNome.getText());
                    jgd.setMorada(textFieldAltMorada.getText());
                    jgd.setIdade(Integer.parseInt(textFieldAltIdade.getText()));
                    jgd.setPeso(Double.parseDouble(textFieldAltPeso.getText()));
                    jgd.setAltura(Double.parseDouble(textFieldAltAltura.getText()));
                    jgd.setNCamisola(Integer.parseInt(textFieldAltNCamisola.getText()));
                    jgd.setPosição(textFieldAltPosição.getText());
                    jgd.setRenumeração(Double.parseDouble(textFieldAltRemuneração.getText()));

                    JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Erro :"+ex.getMessage() );
                }
            }
        });

        altPesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldAltPesquisa.getText();
                for(Jogador jgd: clube){
                    if(jgd.getNome().equals((nome))){
                        textFieldAltNome.setText(jgd.getNome());
                        textFieldAltMorada.setText(jgd.Morada);
                        textFieldAltIdade.setText(String.valueOf(jgd.Idade));
                        textFieldAltPeso.setText(String.valueOf(jgd.Peso));
                        textFieldAltAltura.setText(String.valueOf(jgd.Altura));
                        textFieldAltNCamisola.setText(String.valueOf(jgd.NCamisola));
                        textFieldAltPosição.setText(jgd.Posição);
                        textFieldAltRemuneração.setText(String.valueOf(jgd.Remuneração));
                    }
                }
            }
        });
        encontrarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNomeJogadorAApagar.getText();
                for (Jogador jgd : clube) {
                    if (jgd.getNome().equals(nome)) {
                        textFieldEliNome.setText(jgd.getNome());
                        textFieldEliIdade.setText(String.valueOf(jgd.Idade));
                        textFieldEliSalario.setText(String.valueOf(jgd.Remuneração));
                        textFieldEliPosição.setText(jgd.getPosição());

                        int res=JOptionPane.showConfirmDialog(null,"Tem a certeza que quer elimininar estes dados?");
                        if(res==0)
                        {
                            clube.remove(jgd);
                            JOptionPane.showMessageDialog(null,"Jogador/Jogadores removidos com sucesso");
                        }
                    }
                }
            }
        });
        dadosParaApagarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaDadosParaApagar.setText("");
                for(Jogador a:clube)
                    textAreaDadosParaApagar.append(a.toString()+"\n");
            }
        });
    }
}
