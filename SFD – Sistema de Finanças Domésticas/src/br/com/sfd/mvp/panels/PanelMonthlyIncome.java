package br.com.sfd.mvp.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.sfd.mvp.entities.Conta;
import br.com.sfd.mvp.entities.RendaMensal;

public class PanelMonthlyIncome extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldIdRendaMensal;
    private JTextField textFieldValorRendaMensal;
    private JTextField textFieldDescricaoRendamensal;

    private JPanel paneInserir;
    private JPanel paneDeletar;
    private JPanel paneAlterar;
    private JPanel paneVer;
    private RendaMensal rendaMensal;

    public PanelMonthlyIncome() {
        setBackground(new Color(17, 65, 82));
        setBounds(1, 1, 780, 464);
        setLayout(null);

        JPanel paneinformacoes = new JPanel();
        paneinformacoes.setLayout(null);
        paneinformacoes.setBackground(new Color(17, 65, 82));
        paneinformacoes.setBounds(10, 64, 760, 76);
        add(paneinformacoes);

        JLabel lblRendaMensal = new JLabel("ID Renda Mensal: ");
        lblRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        lblRendaMensal.setBounds(10, 16, 151, 14);
        paneinformacoes.add(lblRendaMensal);

        textFieldIdRendaMensal = new JTextField();
        textFieldIdRendaMensal.setColumns(10);
        textFieldIdRendaMensal.setBounds(171, 11, 98, 20);
        paneinformacoes.add(textFieldIdRendaMensal);

        textFieldValorRendaMensal = new JTextField();
        textFieldValorRendaMensal.setColumns(10);
        textFieldValorRendaMensal.setBounds(171, 42, 98, 20);
        paneinformacoes.add(textFieldValorRendaMensal);

        JLabel lblValorRendaMensal = new JLabel("Valor Renda Mensal:");
        lblValorRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblValorRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        lblValorRendaMensal.setBounds(10, 47, 151, 14);
        paneinformacoes.add(lblValorRendaMensal);

        textFieldDescricaoRendamensal = new JTextField();
        textFieldDescricaoRendamensal.setText("\r\n");
        textFieldDescricaoRendamensal.setHorizontalAlignment(SwingConstants.LEFT);
        textFieldDescricaoRendamensal.setColumns(10);
        textFieldDescricaoRendamensal.setBounds(461, 11, 263, 20);
        paneinformacoes.add(textFieldDescricaoRendamensal);

        JLabel lblDescricaoRendamensal = new JLabel("Descricao Renda Mensal: ");
        lblDescricaoRendamensal.setForeground(Color.LIGHT_GRAY);
        lblDescricaoRendamensal.setFont(new Font("Impact", Font.PLAIN, 15));
        lblDescricaoRendamensal.setBounds(279, 16, 172, 14);
        paneinformacoes.add(lblDescricaoRendamensal);

        JPanel paneMenuHome = new JPanel();
        paneMenuHome.setLayout(null);
        paneMenuHome.setBackground(new Color(17, 65, 82));
        paneMenuHome.setBounds(10, 11, 760, 42);
        add(paneMenuHome);

        JPanel paneInserir = new JPanel();
        paneInserir.addMouseListener(new PanelButtonMouseAdapter(paneInserir) {
            @Override
            public void mouseClicked(MouseEvent e) {
                inserirRendaMensal();
            }
        });
        paneInserir.setToolTipText("");
        paneInserir.setBackground(new Color(17, 65, 82));
        paneInserir.setBounds(10, 5, 151, 30);
        paneMenuHome.add(paneInserir);

        JLabel lblInserirRendaMensal = new JLabel("Inserir ");
        lblInserirRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblInserirRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        paneInserir.add(lblInserirRendaMensal);

        JPanel paneDeletar = new JPanel();
        paneDeletar.addMouseListener(new PanelButtonMouseAdapter(paneDeletar) {
            @Override
            public void mouseClicked(MouseEvent e) {
                deletarRendaMensal();
            }
        });
        paneDeletar.setToolTipText("");
        paneDeletar.setBackground(new Color(17, 65, 82));
        new Color(17, 65, 82);
        paneDeletar.setBounds(171, 5, 151, 30);
        paneMenuHome.add(paneDeletar);

        JLabel lblDeletarRendaMensal = new JLabel("Deletar");
        lblDeletarRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblDeletarRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        paneDeletar.add(lblDeletarRendaMensal);

        JPanel paneAlterar = new JPanel();
        paneAlterar.setToolTipText("");
        paneAlterar.addMouseListener(new PanelButtonMouseAdapter(paneAlterar) {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterarRendaMensal();
            }
        });
        paneAlterar.setBackground(new Color(17, 65, 82));
        paneAlterar.setBounds(332, 5, 151, 30);
        paneMenuHome.add(paneAlterar);

        JLabel lblAlterarRendaMensal = new JLabel("Alterar ");
        lblAlterarRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblAlterarRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        paneAlterar.add(lblAlterarRendaMensal);

        JPanel paneVer = new JPanel();
        paneVer.setToolTipText("");
        paneVer.addMouseListener(new PanelButtonMouseAdapter(paneVer) {
            @Override
            public void mouseClicked(MouseEvent e) {
                verRendaMensal();
            }
        });
        paneVer.setBackground(new Color(17, 65, 82));
        paneVer.setBounds(493, 5, 151, 30);
        paneMenuHome.add(paneVer);

        JLabel lblVerRendaMensal = new JLabel("Ver");
        lblVerRendaMensal.setForeground(Color.LIGHT_GRAY);
        lblVerRendaMensal.setFont(new Font("Impact", Font.PLAIN, 15));
        paneVer.add(lblVerRendaMensal);

        JPanel panelContent = new JPanel();
        panelContent.setLayout(null);
        panelContent.setBounds(10, 151, 760, 302);
        add(panelContent);
        setVisible(true);
    }

    public void menuClicked(JPanel panel) {
        if (panel == paneInserir) {
            inserirRendaMensal();
        } else if (panel == paneDeletar) {
            deletarRendaMensal();
        } else if (panel == paneAlterar) {
            alterarRendaMensal();
        } else if (panel == paneVer) {
            verRendaMensal();
        }
    }

    private void inserirRendaMensal() {
        int idRendaMensal = Integer.parseInt(textFieldIdRendaMensal.getText());
        float valorRendaMensal = Float.parseFloat(textFieldValorRendaMensal.getText());
        Date dataRendaMensal = new Date();
        String descricaoRendaMensal = textFieldDescricaoRendamensal.getText();
		

        // Criar um novo objeto RendaMensal com os valores fornecidos
        RendaMensal novaRendaMensal = new RendaMensal(idRendaMensal, valorRendaMensal, dataRendaMensal,
                descricaoRendaMensal);

        // Chamar o método para inserir a renda mensal
        RendaMensal.inserirRendaMensal(novaRendaMensal);
        JOptionPane.showMessageDialog(this, "Renda mensal inserida com sucesso.", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deletarRendaMensal() {
        int idRendaMensal = Integer.parseInt(textFieldIdRendaMensal.getText());

        // Chamar o método para deletar a renda mensal pelo ID
        RendaMensal.deletarRendaMensal(idRendaMensal);
        JOptionPane.showMessageDialog(this, "Renda mensal deletada com sucesso.", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
    }

    private void alterarRendaMensal() {
        int idRendaMensal = Integer.parseInt(textFieldIdRendaMensal.getText());
        float valorRendaMensal = Float.parseFloat(textFieldValorRendaMensal.getText());
        Date dataRendaMensal = new Date();
        String descricaoRendaMensal = textFieldDescricaoRendamensal.getText();

        // Criar um novo objeto RendaMensal com os valores atualizados
        RendaMensal rendaAtualizada = new RendaMensal(idRendaMensal, valorRendaMensal, dataRendaMensal,
                descricaoRendaMensal);

        // Chamar o método para alterar a renda mensal
        RendaMensal.alterarRendaMensal(rendaAtualizada);
        JOptionPane.showMessageDialog(this, "Renda mensal alterada com sucesso.", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verRendaMensal() {
        int idRendaMensal = Integer.parseInt(textFieldIdRendaMensal.getText());

        // Chamar o método para buscar a renda mensal pelo ID
        RendaMensal rendaMensalEncontrada = RendaMensal.buscarRendaMensalPorId(idRendaMensal);

        // Preencher os campos de texto com os dados da renda mensal encontrada
        if (rendaMensalEncontrada != null) {
            textFieldValorRendaMensal.setText(Float.toString(rendaMensalEncontrada.getValor()));

            textFieldDescricaoRendamensal.setText(rendaMensalEncontrada.getDescricao());
        } else {
            textFieldValorRendaMensal.setText("");
            textFieldDescricaoRendamensal.setText("");
        }
    }

	
	

    private class PanelButtonMouseAdapter extends MouseAdapter {

        JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		

        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(112, 128, 144));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(17, 65, 82));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(60, 179, 113));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(17, 65, 82));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }
    }
}
