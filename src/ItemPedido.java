import java.math.BigDecimal;

public class ItemPedido extends Base {
	private BigDecimal valor;
	private Integer quantidade;
	private String nome;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Item [valor=" + valor + ", quantidade=" + quantidade + ", nome=" + nome + "]";
	}


}
