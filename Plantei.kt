data class Produto(
    val nome: String,
    val tipo: String,
    val cultura: String,
    val dataPlantio: String,
    val previsaoColheita: String
)

val produtos = mutableListOf<Produto>()

fun main() {
    while (true) {
        println("Bem-vindo ao PlanTEI!")
        println("1. Cadastrar Produto")
        println("2. Listar Produtos")
        println("3. Acompanhar Produção")
        println("4. Controle de Estoque")
        println("5. Gerar Relatórios")
        println("6. Sair")

        print("Escolha uma opção: ")
        val opcao = readLine()

        when (opcao) {
            "1" -> cadastrarProduto()
            "2" -> listarProdutos()
            "3" -> acompanharProducao()
            "4" -> controleEstoque()
            "5" -> gerarRelatorios()
            "6" -> {
                println("Saindo do sistema. Até logo!")
                return
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun cadastrarProduto() {
    print("Digite o nome do produto: ")
    val nome = readLine() ?: ""
    print("Digite o tipo (fruta, verdura, legume): ")
    val tipo = readLine() ?: ""
    print("Digite a cultura (hortaliça, frutífera, folhagem, aromáticas, medicinais, outros): ")
    val cultura = readLine() ?: ""
    print("Digite a data de plantio (dd/mm/aaaa): ")
    val dataPlantio = readLine() ?: ""
    print("Digite a previsão de colheita (dd/mm/aaaa): ")
    val previsaoColheita = readLine() ?: ""

    val produto = Produto(nome, tipo, cultura, dataPlantio, previsaoColheita)
    produtos.add(produto)
    println("Produto '$nome' cadastrado com sucesso!")
}

fun listarProdutos() {
    if (produtos.isEmpty()) {
        println("Nenhum produto cadastrado.")
        return
    }

    println("Lista de Produtos:")
    produtos.forEach { produto ->
        println(" - Nome: ${produto.nome}, Tipo: ${produto.tipo}, Cultura: ${produto.cultura}, Data de Plantio: ${produto.dataPlantio}, Previsão de Colheita: ${produto.previsaoColheita}")
    }
}

fun acompanharProducao() {
    println("Funcionalidade de acompanhar produção ainda não implementada.")
}

fun controleEstoque() {
    println("Funcionalidade de controle de estoque ainda não implementada.")
}

fun gerarRelatorios() {
    println("Funcionalidade de gerar relatórios ainda não implementada.")
}