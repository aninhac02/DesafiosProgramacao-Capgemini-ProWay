
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class anuncio {
   private String name;
   private String client;
   private String startDate;
   private String endDate;
   private double investmentPerDay;
   private int id;


   public anuncio(String name, String client, String startDate, String endDate, double investmentPerDay) {
    this.name = name;
    this.client = client;
    this.startDate = startDate;
    this.endDate = endDate;
    this.investmentPerDay = investmentPerDay;
   
    }

    public anuncio() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getInvestmentPerDay() {
        return investmentPerDay;
    }

    public void setInvestmentPerDay(double investmentPerDay) {
        this.investmentPerDay = investmentPerDay;
    }


    
    public double totalInvested(String endDate, String startDate) throws ParseException{
        double totalAmountInvested;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //transformando as strings de data recebidas so usuario:
        Date endDateX = sdf.parse(endDate); 
        Date startDateX = sdf.parse(startDate);

        long diffMil = Math.abs(endDateX.getTime() - startDateX.getTime()); //fazendo a subtração dos milisegundos
        long days = TimeUnit.DAYS.convert(diffMil, TimeUnit.MILLISECONDS); //transformando a diferença em milisegundos em dias

        totalAmountInvested = days * investmentPerDay;
    
        return totalAmountInvested;
        
        /*
          esse método contém um erro, logo, todos os outros não estão funcionado corretamente, pois cada
          método depende do resultado do método anterior
        */
    }
    
    public int maxViews(double totalAmountInvested){
    
        double originalsViews = totalAmountInvested * 30;
        double clicks =  originalsViews * 0.12;
        double shares = clicks * 0.15;
        double anotherViews = shares * 40 * 3;
        double totalViews = originalsViews + anotherViews;

        int maxAmountViews = (int)totalViews;

        return maxAmountViews;
    }
    
    public int maxClicks(int maxAmountViews){
            

        double clicks =  maxAmountViews * 0.12;
    
            
        int maxAmountClicks = (int)clicks;
        return maxAmountClicks;
    }
    
    public int maxShares(int maxAmountClicks){
    
        double shares = maxAmountClicks * 0.15;

        int maxAmountShares = (int)shares;
        return maxAmountShares;
    }
    
    int getId() {
        return id;
    }
    
    
    
 


    public static void main(String[] args) throws ParseException {
        anuncio newAnuncio = new anuncio();
  
        Scanner in = new Scanner(System.in);

        System.out.println("Esse é um sistema de cadastro de anúncios.");
        System.out.println("Para cadastrar seu anúncio, será necessário inserir alguns dados.");
        System.out.println("Nome do anuncio:");
        newAnuncio.setName(in.next());
        System.out.println("Nome do cliente:");
        newAnuncio.setClient(in.next());
        System.out.println("Data de início: (inserir no formato: dd/MM/yyyy)");
        newAnuncio.setStartDate(in.next());
        System.out.println("Data de término: (inserir no formato: dd/MM/yyyy)");
        newAnuncio.setEndDate(in.next());
        System.out.println("Investimento ($RS) por dia:");
        newAnuncio.setInvestmentPerDay(in.nextDouble());
        
        /*
            * não consegui usar o anuncioDAO para inserir os dados no bd
            * em um cenário onde esses dados fossem armazenados corretamente, 
             um método genReport()  leria os dados do anúcio solitado
            * esse método também chamaria as métodos:
                - totalInvested() -> para calcular o total investido, a partir
                da quantidade de dias que o anúncio ficou ativo;
                - maxViews() -> para calcular quantas visualizações esse anúncio
                obteve, a partir do total investido;
                - maxClicks() -> para calcular quantos cliques esse anúncio
                obteve, a partir da quantidade de visualizações;
                - maxShares() -> para calcular a quantidade de compartilhamentos que
                esse anúncio obteve, a partir da quantidade de cliques;
            * após realizar esses cálculos, genReport() escreveria os resulatdos em 
            um arquivo txt ou pdf
       
        
        */
    }
}


   
