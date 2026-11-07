package app;

import model.ItemPedido;

/*
 * Respostas do exercício:
 *
 * a) Qual bloco está repetido?
 *    O bloco inteiro de cada item (4 vezes): declarar as variáveis, calcular o bruto,
 *    aplicar a regra de desconto com if / else if / else, calcular o líquido e imprimir
 *    a linha com printf. Só mudavam os dados (descrição, valor, quantidade e kit).
 *
 * b) Quais variáveis estão numeradas?
 *    descricao1..4, valor1..4, qtd1..4, kit1..4, bruto1..4, abatimento1..4 e liquido1..4
 *    (todas viram atributos/métodos de ItemPedido ou valores locais de um laço).
 *
 * c) Quais números mágicos existem e o que significam?
 *    0.15   -> 15% de desconto para kit (DESCONTO_KIT)
 *    0.08   -> 8% de desconto para quantidade grande (DESCONTO_ATACADO)
 *    10     -> quantidade mínima para o desconto de 8% (QUANTIDADE_ATACADO)
 *    150.0  -> valor dos itens a partir do qual o frete é grátis (FRETE_GRATIS_A_PARTIR_DE)
 *    12.90  -> valor do frete quando não é grátis (VALOR_FRETE)
 *    0.0    -> sem desconto / frete grátis (zero, mantido como valor literal)
 */
public class Papelaria {

    private static final double FRETE_GRATIS_A_PARTIR_DE = 150.0;
    private static final double VALOR_FRETE = 12.90;

    public static void main(String[] args) {
        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        ItemPedido[] itens = {
            new ItemPedido("Caderno 10 materias", 24.90, 1, false),
            new ItemPedido("Lapis grafite", 1.50, 12, false),
            new ItemPedido("Kit escolar basico", 84.00, 1, true),
            new ItemPedido("Caneta azul", 2.80, 10, false)
        };

        double soma = 0.0;
        for (ItemPedido item : itens) {
            item.exibirLinha();
            soma += item.calcularValorLiquido();
        }

        double frete = calcularFrete(soma);
        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }

    public static double calcularFrete(double valorItens) {
        if (valorItens >= FRETE_GRATIS_A_PARTIR_DE) {
            return 0.0;
        }
        return VALOR_FRETE;
    }
}
