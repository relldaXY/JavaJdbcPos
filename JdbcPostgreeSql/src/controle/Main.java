package controle;

import java.util.Scanner;

import bancoDeDados.Conexao;

public class Main {

	public static void main(String[] args) {
		Conexao conn = new Conexao();
		int menuPrincipal = 999;
		int subMenu = 999;
		int mostra = 999;
		
		
		Scanner sc = new Scanner(System.in);
		
		
		do{
			System.out.println("====Menu Principal====\n\n");
			System.out.println("n = 0 -> Sair do Programa\n");
			System.out.println("n!= 0 -> Entrar no Programa\n\n");
			
			System.out.println("Digite sua escolha> ");
			menuPrincipal = Integer.parseInt(sc.nextLine());
			
			if(menuPrincipal != 0){
				
				do{
				System.out.println("====SubMenu====\n\n");
				System.out.println("0 -> Conectar-se ao banco: \n");
				System.out.println("1 -> Criar tabela: \n");
				System.out.println("2 -> Inserir na tabela: \n");
				System.out.println("3 -> Update na tabela: \n");
				System.out.println("4 -> Delete registro da tabela: \n");
				System.out.println("5 -> Selecionar da Tabela:\n");
				
				
				System.out.println("Digite sua escolha> ");
				subMenu = Integer.parseInt(sc.nextLine());
				
				if(subMenu >= 0 && subMenu <= 4){
					switch(subMenu){
                    case 0:
                    	System.out.println("Digite o banco desejado:\n");
                    	String nomeBD = sc.nextLine();
                    	System.out.println("Digite a senha do banco desejado:\n");
                    	String senhaBD = sc.nextLine();
                    	conn.conectarComBD(nomeBD, senhaBD);
                        break;
                    
                    case 1:
                    	System.out.println("Digite o banco desejado:\n");
                    	nomeBD = sc.nextLine();
                    	System.out.println("Digite a senha do banco desejado:\n");
                    	senhaBD = sc.nextLine();
                    	conn.conectarComBD(nomeBD, senhaBD);

                    	System.out.println("Digite o nome da tabela a ser criada: \n");                    	
                    	String nomeTabela = sc.nextLine();
                    	conn.criarTabela(nomeTabela);
                        break;
                    
                    case 2:
                    	System.out.println("Digite o banco desejado:\n");
                    	nomeBD = sc.nextLine();
                    	System.out.println("Digite a senha do banco desejado:\n");
                    	senhaBD = sc.nextLine();
                    	conn.conectarComBD(nomeBD, senhaBD);
                    	
                    	System.out.println("Digite o nome da tabela:\n");
                    	String nomeDaTabela = sc.nextLine();
                    	System.out.println("Digite o nome a ser inserido: ");
                    	String nome = sc.nextLine();
                    	System.out.println("Digite a idade: ");
                    	int idade = Integer.parseInt(sc.nextLine());
                    	System.out.println("Digite a cidade: \n");
                    	String cidade = sc.nextLine();
                    	System.out.println("Digite o salario: \n");
                    	Float salario = Float.parseFloat(sc.nextLine());
                    	
                    	conn.inserirNaTabela(nomeDaTabela, nome, idade, cidade, salario);
                        
        
                    	break;    
                    
                    case 3:
                    	
                        break;
                        
                    case 4:
                    	
                        break;
                                    
				}
				}
				if(subMenu == 5){
					
					do{
					System.out.println("Digite 0, 1 ou 2\n");
					System.out.println("==== Menu da Selecao ====\n\n");
					System.out.println("0 -> retornar\n");
					System.out.println("1 -> selecionar tudo\n");
					System.out.println("2 -> selecionar algo especifico\n");
					
					
					System.out.println("Digite sua escolha> ");
					mostra = Integer.parseInt(sc.nextLine());
					
					if(mostra!=0){
						switch(mostra){
						
						
	                    case 1:
	                    System.out.println("Digite o banco desejado:\n");
	                    String nomeBD = sc.nextLine();
	                    System.out.println("Digite a senha do banco desejado:\n");
	                    String senhaBD = sc.nextLine();
	                    conn.conectarComBD(nomeBD, senhaBD);
	                    
	                    System.out.println("Digite a tabela desejada: \n");
	                    String tabela = sc.nextLine();
	                    conn.selectionTable(tabela);
	                    
	                    	break;
	                    
	                    case 2:
	                        break;
						}
					}
					
					}while(mostra!=0);
				}
				
				
				}while(subMenu!=0);
			}		
		}while(menuPrincipal!=0);
	}
	
}

	



