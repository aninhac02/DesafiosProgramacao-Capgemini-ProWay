/*
  Testes unitários
 */

public class calculadoraTest {
    calculadora calculadora;
    
    public boolean testCalculateViews(){
        calculadora = new calculadora();
        int expectedResult = 4740;
        int result = calculadora.calculateViews(50);
        
        if(result == expectedResult){
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void main(String[] args){
        calculadoraTest test = new calculadoraTest();
        
        boolean result = test.testCalculateViews();
        
        System.out.println(result);
    }
    
}
