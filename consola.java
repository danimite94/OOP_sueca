package Avaliacao5;

public class consola
{
	public static void main(String[] args)
	{

		jogo sueca = new jogo();
		funcoes funcoes = new funcoes();


		System.out.println("===========================RELATÓRIO DO JOGO===========================");
		
		 funcoes.primeiro_baralhador(); 
		 while(sueca.getPartida_1()<4 || sueca.getPartida_2()<4){
		 
			 sueca.desenrolar_do_jogo();
			 sueca.pontuacao();
			 funcoes.rotacao();
		 
		 }
		 
	}

}
