package br.com.sfd.mvp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LancamentosGastos implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idLancamentosGerais;
    private float valorGasto;
    private Date dataGasto;
	private int quantidadePorConsumo;
	private String descricao;
	private List<LancamentosGastos> lancamentos = new ArrayList<>();

	public LancamentosGastos() {
		
    }
	
    public LancamentosGastos(int idLancamentosGerais, float valorGasto, Date dataGasto, int quantidadePorConsumo,String descricao) {
        this.idLancamentosGerais = idLancamentosGerais;
        this.valorGasto = valorGasto;
        this.dataGasto = dataGasto;
        this.quantidadePorConsumo = quantidadePorConsumo;
    }

    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdLancamentosGerais() {
        return idLancamentosGerais;
    }

    public int getQuantidadePorConsumo() {
		return quantidadePorConsumo;
	}

	public List<LancamentosGastos> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<LancamentosGastos> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void setIdLancamentosGerais(int idLancamentosGerais) {
        this.idLancamentosGerais = idLancamentosGerais;
    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Date getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(Date dataGasto) {
        this.dataGasto = dataGasto;
    }

    public  int quantidadePorConsumo() {
        return quantidadePorConsumo;
    }

    public void setQuantidadePorConsumo(int novaQuantidade) {
        this.quantidadePorConsumo = novaQuantidade;
    }

    public void adicionarLancamento( int id,float valor, Date data, int quantidade, String descricao) {
    	LancamentosGastos lancamento = new LancamentosGastos(id, valor, data, quantidade,descricao);
    	lancamentos.add(lancamento);
    }
    
    public  LancamentosGastos buscarLancamentoPorId(int id, List<LancamentosGastos> lancamentos) {
        for (LancamentosGastos lancamento : lancamentos) {
            if (lancamento.getIdLancamentosGerais() == id) {
                return lancamento;
            }
        }
        return null;
    }
    public void atualizarLancamento(int id, float novoValor, Date novaData, int novaQuantidade,String novaDescricao) {
        LancamentosGastos lancamento = buscarLancamentoPorId(id, lancamentos);
        if (lancamento != null) {
            lancamento.setValorGasto(novoValor);
            lancamento.setDataGasto(novaData);
            lancamento.setQuantidadePorConsumo(novaQuantidade);
            lancamento.setDescricao(novaDescricao);
        }
    }
    public  void excluirLancamento(int id) {
        LancamentosGastos lancamento = buscarLancamentoPorId(id, lancamentos);
        if (lancamento != null) {
        	lancamentos.remove(lancamento);
        	System.out.println("Removeu");
        }
    }
}