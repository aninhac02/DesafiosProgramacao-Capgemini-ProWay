import java.util.Scanner;

public class calculadora {
    private double investedValue;

    public calculadora(double investedValue) {
        this.investedValue = investedValue;
    }

    public calculadora() {
    }

    public double getInvestedValue() {
        return investedValue;
    }

    public void setInvestedValue(double investedValue) {
        this.investedValue = investedValue;
    }

    public int calculateViews(double investedValue){
        
        double originalsViews = investedValue * 30; //calcula as visualizações do anúncio original (primeiro postado)
        double clicks =  originalsViews * 0.12; //calcula a quantidade de cliques que esse anúncio recebe
        double shares = clicks * 0.15; //calcula a quantidade de compartilhamentos 
        double anotherViews = shares * 40 * 3; // anotherViews são as visualizações após os compartilhamentos
        double totalViews = originalsViews + anotherViews; // total de visualizações
        
        int total = (int)totalViews;
        return total;


    }

    public static void main(String[] args) {
        calculadora newCalculadora = new calculadora();
        Scanner in = new Scanner(System.in);

        
        System.out.println("Essa é uma calculadora de alcance de anúncio.");
        System.out.println("Para saber quantas pessoas, aproximadamente, verão seu anúncio, insira o valor em reais que deseja investir: ");
        int value = in.nextInt();
    

        System.out.println(newCalculadora.calculateViews(value));
    }

    
    
}
