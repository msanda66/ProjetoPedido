import java.math.BigDecimal;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Pedido extends Base{
	private String nomeCliente;
	private String nomeFilial;
	private List<ItemPedido> itens = new ArrayList<>();

	/**
	 * @author ronaldolanhellas
	 * @return {@link BigDecimal} Calcula o valor total do pedido
	 */
	public BigDecimal getValor() {
		if (itens.isEmpty()) {
			return BigDecimal.ZERO;
		} else {
			BigDecimal total = BigDecimal.ZERO;
			for (ItemPedido it : itens) {
				total = total.add(it.getValor().multiply(BigDecimal.valueOf(it.getQuantidade())));
			}

			return total;
		}
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

}
