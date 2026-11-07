package model;

public class ItemPedido {

    // Constantes que substituem os números mágicos do código original
    public static final double DESCONTO_KIT = 0.15;        // 15% de desconto para kits
    public static final double DESCONTO_ATACADO = 0.08;    // 8% de desconto para compras em quantidade
    public static final int QUANTIDADE_ATACADO = 10;       // a partir de 10 unidades vale o desconto de atacado

    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private boolean kit;

    public ItemPedido(String descricao, double valorUnitario, int quantidade, boolean kit) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.kit = kit;
    }

    public double calcularValorBruto() {
        return valorUnitario * quantidade;
    }

    // A regra de desconto aparece uma única vez, aqui.
    public double calcularDesconto() {
        double bruto = calcularValorBruto();
        if (kit) {
            return bruto * DESCONTO_KIT;
        } else if (quantidade >= QUANTIDADE_ATACADO) {
            return bruto * DESCONTO_ATACADO;
        }
        return 0.0;
    }

    public double calcularValorLiquido() {
        return calcularValorBruto() - calcularDesconto();
    }

    public void exibirLinha() {
        System.out.printf("%-20s %3d un | bruto R$ %7.2f | desc R$ %6.2f | R$ %7.2f%n",
                descricao, quantidade, calcularValorBruto(), calcularDesconto(), calcularValorLiquido());
    }
}
