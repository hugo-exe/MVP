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

import br.com.sfd.mvp.entities.LancamentosGastos;

public class PanelSpendingBids extends JPanel {
	private static final long serialVersionUID = 1L;
    private JTextField textFieldIdLacamentosG;
    private JTextField textFieldValorLacamentosg;
    private JTextField textFieldQuantidadeLacamentosG;

    private JPanel paneInserir;
    private JPanel paneDeletar;
    private JPanel paneAlterar;
    private JPanel paneVer;
    private LancamentosGastos lancamentosGastos;
    private JTextField texteFieldDescricaoLancamentos;
    
	public PanelSpendingBids() {
		setBackground(new Color(17, 65, 82));
		setBounds(1, 1, 780, 464);
		setLayout(null);
		
		lancamentosGastos = new LancamentosGastos();

		
		JPanel paneinformacoes = new JPanel();
		paneinformacoes.setLayout(null);
		paneinformacoes.setBackground(new Color(17, 65, 82));
		paneinformacoes.setBounds(10, 64, 760, 76);
		add(paneinformacoes);
		
		JLabel lblIdLacamentosG = new JLabel("ID LacamentosG: ");
		lblIdLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblIdLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		lblIdLacamentosG.setBounds(10, 16, 151, 14);
		paneinformacoes.add(lblIdLacamentosG);
		
		textFieldIdLacamentosG = new JTextField();
		textFieldIdLacamentosG.setColumns(10);
		textFieldIdLacamentosG.setBounds(171, 11, 98, 20);
		paneinformacoes.add(textFieldIdLacamentosG);
		
		textFieldValorLacamentosg = new JTextField();
		textFieldValorLacamentosg.setColumns(10);
		textFieldValorLacamentosg.setBounds(171, 42, 98, 20);
		paneinformacoes.add(textFieldValorLacamentosg);
		
		JLabel lblValorLacamentosg = new JLabel("Valor LacamentosG:");
		lblValorLacamentosg.setForeground(Color.LIGHT_GRAY);
		lblValorLacamentosg.setFont(new Font("Impact", Font.PLAIN, 15));
		lblValorLacamentosg.setBounds(10, 47, 151, 14);
		paneinformacoes.add(lblValorLacamentosg);
		
		textFieldQuantidadeLacamentosG = new JTextField();
		textFieldQuantidadeLacamentosG.setText("\r\n");
		textFieldQuantidadeLacamentosG.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQuantidadeLacamentosG.setColumns(10);
		textFieldQuantidadeLacamentosG.setBounds(461, 11, 263, 20);
		paneinformacoes.add(textFieldQuantidadeLacamentosG);
		
		JLabel lblQuantidadeLacamentosG = new JLabel("Quantidade LacamentosG: ");
		lblQuantidadeLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblQuantidadeLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		lblQuantidadeLacamentosG.setBounds(279, 16, 172, 14);
		paneinformacoes.add(lblQuantidadeLacamentosG);
		
		JLabel lblDescricaoLacamentosG = new JLabel("Descricao LacamentosG: ");
		lblDescricaoLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblDescricaoLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		lblDescricaoLacamentosG.setBounds(279, 45, 172, 14);
		paneinformacoes.add(lblDescricaoLacamentosG);
		
		texteFieldDescricaoLancamentos = new JTextField();
		texteFieldDescricaoLancamentos.setText("\r\n");
		texteFieldDescricaoLancamentos.setHorizontalAlignment(SwingConstants.LEFT);
		texteFieldDescricaoLancamentos.setColumns(10);
		texteFieldDescricaoLancamentos.setBounds(461, 42, 263, 20);
		paneinformacoes.add(texteFieldDescricaoLancamentos);
		
		JPanel paneMenuHome = new JPanel();
		paneMenuHome.setLayout(null);
		paneMenuHome.setBackground(new Color(17, 65, 82));
		paneMenuHome.setBounds(10, 11, 760, 42);
		add(paneMenuHome);
		
		JPanel paneInserir = new JPanel();
		paneInserir.addMouseListener(new PanelButtonMouseAdapter(paneInserir) {
			@Override
			public void mouseClicked(MouseEvent e) {
				inserirLacamentosG();
			}
		});
		paneInserir.setToolTipText("");
		paneInserir.setBackground(new Color(17, 65, 82));
		paneInserir.setBounds(10, 5, 151, 30);
		paneMenuHome.add(paneInserir);
		
		JLabel lblInserirLacamentosG = new JLabel("Inserir ");
		lblInserirLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblInserirLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		paneInserir.add(lblInserirLacamentosG);
		
		JPanel paneDeletar = new JPanel();
		paneDeletar.setToolTipText("");
		paneDeletar.addMouseListener(new PanelButtonMouseAdapter(paneDeletar) {
			@Override
			public void mouseClicked(MouseEvent e) {
				deletarLacamentosG();
			}
		});
		paneDeletar.setBackground(new Color(17, 65, 82));
		paneDeletar.setBounds(171, 5, 151, 30);
		paneMenuHome.add(paneDeletar);
		
		JLabel lblDeletarLacamentosG = new JLabel("Deletar");
		lblDeletarLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblDeletarLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		paneDeletar.add(lblDeletarLacamentosG);
		
		JPanel paneAlterar = new JPanel();
		paneAlterar.setToolTipText("");
		paneAlterar.addMouseListener(new PanelButtonMouseAdapter(paneAlterar) {
			@Override
			public void mouseClicked(MouseEvent e) {
				alterarLacamentosG();
			}
		});
		paneAlterar.setBackground(new Color(17, 65, 82));
		paneAlterar.setBounds(332, 5, 151, 30);
		paneMenuHome.add(paneAlterar);
		
		JLabel lblAlterarLacamentosG = new JLabel("Alterar ");
		lblAlterarLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblAlterarLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		paneAlterar.add(lblAlterarLacamentosG);
		
		JPanel paneVer = new JPanel();
		paneVer.setToolTipText("");
		paneVer.addMouseListener(new PanelButtonMouseAdapter(paneVer) {
			@Override
			public void mouseClicked(MouseEvent e) {
				verLacamentosG();
			}
		});
		paneVer.setBackground(new Color(17, 65, 82));
		paneVer.setBounds(493, 5, 151, 30);
		paneMenuHome.add(paneVer);
		
		JLabel lblVerLacamentosG = new JLabel("Ver");
		lblVerLacamentosG.setForeground(Color.LIGHT_GRAY);
		lblVerLacamentosG.setFont(new Font("Impact", Font.PLAIN, 15));
		paneVer.add(lblVerLacamentosG);
		
		JPanel paneContent = new JPanel();
		paneContent.setLayout(null);
		paneContent.setBounds(10, 151, 760, 302);
		add(paneContent);
		setVisible(true);
	}
	
	public void menuClicked(JPanel panel) {
	       if (panel == paneInserir) {
	            inserirLacamentosG();
	        } else if (panel == paneDeletar) {
	            deletarLacamentosG();
	        } else if (panel == paneAlterar) {
	            alterarLacamentosG();
	        } else if (panel == paneVer) {
	            verLacamentosG();
	        }
	}
	
	private void inserirLacamentosG() {
		int idLancamentos = Integer.parseInt(textFieldIdLacamentosG.getText());
		float valorLacamentos = Float.parseFloat(textFieldValorLacamentosg.getText());
		Date dataLancamentos = new Date();
		int quantidadeLacamentosG = Integer.parseInt(textFieldQuantidadeLacamentosG.getText().trim());
		String descricao = texteFieldDescricaoLancamentos.getText();
		
		LancamentosGastos lancamentos = new LancamentosGastos(idLancamentos, valorLacamentos, dataLancamentos, quantidadeLacamentosG, descricao);
		lancamentos.adicionarLancamento(idLancamentos, valorLacamentos, dataLancamentos, quantidadeLacamentosG, descricao);
		
		salvarLancamento(lancamentos); // Salvar o lançamento
		
		JOptionPane.showMessageDialog(this, "Inserção concluída com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
		textFieldIdLacamentosG.setText("");
		textFieldValorLacamentosg.setText("");
		textFieldQuantidadeLacamentosG.setText("");
		texteFieldDescricaoLancamentos.setText("");
	}
	
	private void salvarLancamento(LancamentosGastos lancamentos) {
		String arquivo = "lancamentos.txt";
	
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
			writer.write("ID: " + lancamentos.getIdLancamentosGerais());
			writer.newLine();
			writer.write("Valor: " + lancamentos.getValorGasto());
			writer.newLine();
			writer.write("Quantidade: " + lancamentos.getQuantidadePorConsumo());
			writer.newLine();
			writer.write("Data: " + lancamentos.getDataGasto());
			writer.newLine();
			writer.newLine();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Erro ao salvar lançamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	


	private void deletarLacamentosG() {
	    int idLancamentosG = Integer.parseInt(textFieldIdLacamentosG.getText());
	    lancamentosGastos.excluirLancamento(idLancamentosG);
	    JOptionPane.showMessageDialog(this, "Lançamento excluído com sucesso!", "Confirmação",
	            JOptionPane.INFORMATION_MESSAGE);
	    textFieldIdLacamentosG.setText("");
	}

	private void alterarLacamentosG() {
	    int idLancamentosG = Integer.parseInt(textFieldIdLacamentosG.getText());
	    float novoValor = Float.parseFloat(textFieldValorLacamentosg.getText());
	    Date novaData = new Date();
	    int novaQuantidade = Integer.parseInt(textFieldQuantidadeLacamentosG.getText());
	    String novaDescricao = texteFieldDescricaoLancamentos.getText();
	    lancamentosGastos.atualizarLancamento(idLancamentosG, novoValor, novaData, novaQuantidade, novaDescricao);
	    JOptionPane.showMessageDialog(this, "Lançamento atualizado com sucesso!", "Confirmação",
	            JOptionPane.INFORMATION_MESSAGE);
	    textFieldIdLacamentosG.setText("");
	    textFieldValorLacamentosg.setText("");
	    textFieldQuantidadeLacamentosG.setText("");
	    texteFieldDescricaoLancamentos.setText("");
	}

	private void verLacamentosG() {
	    for (LancamentosGastos lancamento : lancamentosGastos.getLancamentos()) {
	        System.out.println("ID: " + lancamento.getIdLancamentosGerais());
	        System.out.println("Valor: " + lancamento.getValorGasto());
	        System.out.println("Data: " + lancamento.getDataGasto());
	        System.out.println("Quantidade: " + lancamento.getQuantidadePorConsumo());
	        System.out.println("Descrição: " + lancamento.getDescricao());
	        System.out.println();
	    }
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
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
