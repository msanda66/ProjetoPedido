import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PedidoDataSource {

	private List<Pedido> pedidos = new ArrayList<>();

	/**
	 * Listar pedidos e itens
	 */
	public void listar() {
		if (pedidos.isEmpty()) {
			System.out.println("Não há pedidos a serem listados");
		} else {
			StringBuilder str = new StringBuilder();
			for (Pedido pedido : pedidos) {
				str.append("----------------------------------");
				str.append("\n");
				str.append("Pedido " + pedido.getCodigo() + "\n");
				str.append("Data/Hora Inclusão: " + pedido.getDataHoraInclusao() + "\n");
				str.append("Data/Hora Edição  : " + pedido.getDataHoraEdicao() + "\n");
				str.append("Cliente           : " + pedido.getNomeCliente() + "\n");
				str.append("Filial            : " + pedido.getNomeFilial() + "\n");
				str.append("Valor             :" + pedido.getValor() + "\n");
				str.append("Itens             : \n");
				str.append(montarItens(pedido));
				str.append("\n");
				str.append("----------------------------------");
				str.append("\n");
			}

			System.out.println(str.toString());
		}
	}

	private String montarItens(Pedido pedido) {
		StringBuilder str = new StringBuilder();
		for (ItemPedido it : pedido.getItens()) {
			str.append("\t" + it.toString() + "\n");
		}
		return str.toString();
	}

	/**
	 * Incluir pedidos
	 * */
	public void incluir() {
		Pedido pedido = new Pedido();
		pedido.setDataHoraInclusao(new Date());
		Scanner scanner = new Scanner(System.in);
		System.out.println("- - - - - - INCLUIR PEDIDO - - - - - -");
		System.out.println("Digite o Código         : ");
		pedido.setCodigo(scanner.nextLine());
		System.out.println("Digite o nome do cliente: ");
		pedido.setNomeCliente(scanner.nextLine());
		System.out.println("Digite o nome da Filial : ");
		pedido.setNomeFilial(scanner.nextLine());

		System.out.println(
			"Digite os itens separando por ',' (virgula) os campos (codigo,valor,quantidade,nome) e ';' os itens. "
					+ "\n Exemplo: 1111,100,1,FERRO DE PASSAR;2222,300,3,CELULAR");
		System.out.println(":");
		String itens = scanner.nextLine();
		String itensSplit[] = itens.split(";");
		for (String item : itensSplit) {
			String itemColunas[] = item.split(",");
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setCodigo(itemColunas[0]);
			itemPedido.setValor(BigDecimal.valueOf(Double.valueOf(itemColunas[1])));
			itemPedido.setQuantidade(Integer.valueOf(itemColunas[2]));
			itemPedido.setNome(itemColunas[3]);
			pedido.getItens().add(itemPedido);
		}

		pedidos.add(pedido);
		System.out.println("Pedido nº" + pedido.getCodigo() + " incluído com sucesso");
	}

	/**
	 * Editar Pedido
	 * */
	public void editar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o código do pedido a ser editado: ");
		String codigo = scanner.nextLine();
		Pedido pedidoParaEditar = new Pedido();
		pedidoParaEditar.setCodigo(codigo);
		int index = pedidos.indexOf(pedidoParaEditar);
		if (index == -1) {
			System.out.println("Pedido não encontrado");
		} else {
			pedidoParaEditar = pedidos.get(index);
			pedidoParaEditar.setDataHoraEdicao(new Date());
			System.out.println(">>>>> EDITANDO PEDIDO <<<<<");
			System.out.println("Digite o nome do cliente (Deixe vazio para não alterar): ");
			String nomeCliente = scanner.nextLine();
			if (!nomeCliente.isEmpty()) {
				pedidoParaEditar.setNomeCliente(nomeCliente);
			}

			System.out.println("Digite o nome da filial (Deixe vazio para não alterar): ");
			String nomeFilial = scanner.nextLine();
			if (!nomeFilial.isEmpty()) {
				pedidoParaEditar.setNomeFilial(nomeFilial);
			}

			System.out.println(
					"Digite os itens separando por ',' (virgula) os campos (codigo,valor,quantidade,nome) e ';' os itens. "
						+ "\n Exemplo: 1111,100,1,FERRO DE PASSAR;2222,300,3,CELULAR");
			System.out.println(":");
			String itens = scanner.nextLine();
			if (!itens.isEmpty()) {
				String itensSplit[] = itens.split(";");
				for (String item : itensSplit) {
					String itemColunas[] = item.split(",");
					ItemPedido itemPedido = new ItemPedido();
					itemPedido.setCodigo(itemColunas[0]);
					itemPedido.setValor(BigDecimal.valueOf(Double.valueOf(itemColunas[1])));
					itemPedido.setQuantidade(Integer.valueOf(itemColunas[2]));
					itemPedido.setNome(itemColunas[3]);
					pedidoParaEditar.getItens().add(itemPedido);
				}
			}
		}
	}

	/**
	 * Excluir pedido
	 * */
	public void excluir() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o código do pedido a ser excluído: ");
		String codigo = scanner.nextLine();
		Pedido pedidoParaRemover = new Pedido();
		pedidoParaRemover.setCodigo(codigo);
		int index = pedidos.indexOf(pedidoParaRemover);
		if (index == -1) {
			System.out.println("Pedido não encontrado");
		} else {
			pedidos.remove(index);
			System.out.println("Pedido excluído com sucesso");
		}
	}

}
