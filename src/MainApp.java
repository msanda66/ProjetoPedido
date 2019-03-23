import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PedidoDataSource pedidoDS = new PedidoDataSource();
		int opcao = -1;
		do {
			System.out.println("\n\n");
			System.out.println(montarMenu());
			System.out.print("Escolha a opção desejada: ");
			opcao = Integer.valueOf(scanner.next());
			chamaMetodoPorOpcao(opcao, pedidoDS);
		} while (opcao != 5);
	}

	private static void chamaMetodoPorOpcao(int opcao, PedidoDataSource pedidoDS) {
		switch (opcao) {
		case 1:
			pedidoDS.listar();
			break;
		case 2:
			pedidoDS.incluir();
			break;
		case 3:
			pedidoDS.editar();
			break;
		case 4:
			pedidoDS.excluir();
			break;
		case 5:
			System.out.println("Encerrando programa...");
			break;
		default:
			System.out.println("Opção inválida");
		}
	}

	private static String montarMenu() {
		StringBuilder str = new StringBuilder();
		str.append("-------- PEDIDOS --------");
		str.append("\n");
		str.append("1. Listar");
		str.append("\n");
		str.append("2. Adicionar");
		str.append("\n");
		str.append("3. Editar");
		str.append("\n");
		str.append("4. Excluir");
		str.append("\n");
		str.append("5. Sair");

		return str.toString();
	}
	
}
