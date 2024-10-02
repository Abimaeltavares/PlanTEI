data class Produto(
    val nome: String,
    val tipo: String,
    val cultura: String,
    val dataPlantio: String,
    val previsaoColheita: String,
    var quantidadeEstoque: Double = 0.0 // Adicionada a quantidade em estoque
)

data class Producao(
    val produto: Produto,
    val quantidade: Double, // em kg
    val dataColheita: String
)

val produtos = mutableListOf<Produto>()
val producoes = mutableListOf<Producao>()

fun main() {
    while (true) {
        println("Bem-vindo ao PlanTEI!")
        println("1. Cadastrar Produto")
        println("2. Listar Produtos")
        println("3. Registrar Produção")
        println("4. Listar Produção por Produto")
        println("5. Registrar Saída de Estoque")
        println("6. Listar Estoque por Produto")
        println("7. Gerar Relatórios")
        println("8. Sair")

        print("Escolha uma opção: ")
        val opcao = readLine()

        when (opcao) {
            "1" -> cadastrarProduto()
            "2" -> listarProdutos()
            "3" -> registrarProducao()
            "4" -> listarProducaoPorProduto()
            "5" -> registrarSaidaEstoque()
            "6" -> listarEstoquePorProduto()
            "7" -> gerarRelatorios()
            "8" -> {
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
        println(" - Nome: ${produto.nome}, Tipo: ${produto.tipo}, Cultura: ${produto.cultura}, Data de Plantio: ${produto.dataPlantio}, Previsão de Colheita: ${produto.previsaoColheita}, Estoque: ${produto.quantidadeEstoque} kg")
    }
}

fun registrarProducao() {
    if (produtos.isEmpty()) {
        println("Nenhum produto cadastrado. Cadastre um produto primeiro.")
        return
    }

    println("Selecione o produto para registrar a produção:")
    listarProdutos()
    print("Digite o nome do produto: ")
    val nomeProduto = readLine() ?: ""
    val produto = produtos.find { it.nome.equals(nomeProduto, ignoreCase = true) }

    if (produto == null) {
        println("Produto não encontrado.")
        return
    }

    print("Digite a quantidade colhida em kg: ")
    val quantidade = readLine()?.toDoubleOrNull() ?: 0.0
    print("Digite a data da colheita (dd/mm/aaaa): ")
    val dataColheita = readLine() ?: ""

    val producao = Producao(produto, quantidade, dataColheita)
    producoes.add(producao)
    produto.quantidadeEstoque += quantidade // Atualiza a quantidade em estoque
    println("Produção registrada com sucesso para o produto '${produto.nome}'.")
}

fun registrarSaidaEstoque() {
    if (produtos.isEmpty()) {
        println("Nenhum produto cadastrado. Cadastre um produto primeiro.")
        return
    }

    println("Selecione o produto para registrar a saída de estoque:")
    listarProdutos()
    print("Digite o nome do produto: ")
    val nomeProduto = readLine() ?: ""
    val produto = produtos.find { it.nome.equals(nomeProduto, ignoreCase = true) }

    if (produto == null) {
        println("Produto não encontrado.")
        return
    }

    print("Digite a quantidade a ser retirada em kg: ")
    val quantidadeSaida = readLine()?.toDoubleOrNull() ?: 0.0

    if (quantidadeSaida > produto.quantidadeEstoque) {
        println("Quantidade solicitada maior que a disponível em estoque.")
        return
    }

    produto.quantidadeEstoque -= quantidadeSaida // Atualiza a quantidade em estoque
    println("Saída de estoque registrada com sucesso para o produto '${produto.nome}'.")
}

fun listarEstoquePorProduto() {
    if (produtos.isEmpty()) {
        println("Nenhum produto cadastrado.")
        return
    }

    println("Estoque por Produto:")
    produtos.forEach { produto ->
        println(" - Nome: ${produto.nome}, Estoque: ${produto.quantidadeEstoque} kg")
    }
}

fun listarProducaoPorProduto() {
    if (producoes.isEmpty()) {
        println("Nenhuma produção registrada.")
        return
    }

    println("Produção registrada por produto:")
    producoes.groupBy { it.produto.nome }.forEach { (nomeProduto, producoes) ->
        println("Produto: $nomeProduto")
        producoes.forEach { producao ->
            println(" - Data: ${producao.dataColheita}, Quantidade: ${producao.quantidade} kg")
        }
    }
}

fun controleEstoque() {
    println("Funcionalidade de controle de estoque ainda não implementada.")
}

fun gerarRelatorios() {
    println("Funcionalidade de gerar relatórios ainda não implementada.")
}