/*

  Aula de hoje: manipular Strings
  >> Atribuindo valores
  >> Sobrescrevendo valores nas variáveis
  >> Concatenando Strings
  >> metodo equauls()
  >> metodo contains()

*/

public class manipulaString {
  public static void main(String[] args) {

    // Variáveis
    
    String tarefa = "";
    String codigo = "";
    String descricao = "";
    String inicio = "0";
    String fim = "0";

    // Entrada 1

    codigo = "001";
    descricao = "Estudar Java";
    inicio = "10";
    fim = "11";    
    
    tarefa = tarefa + codigo + " - " + descricao + " - " + inicio + " - " + fim + "\n";
    
    // Entrada 2

    codigo = "002";
    descricao = "Fazer compras";
    inicio = "11";
    fim = "12";    
    
    tarefa = tarefa + codigo + " - " + descricao + " - " + inicio + " - " + fim + "\n";


    // Entrada 3

    codigo = "003";
    descricao = "Limpar a casa";
    inicio = "12";
    fim = "13";    

    tarefa = tarefa + codigo + " - " + descricao + " - " + inicio + " - " + fim + "\n";


    // Saída 

    System.out.println(tarefa);

  }}
