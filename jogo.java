package Avaliacao5;

import java.util.Random;
import java.util.Scanner;

public class jogo
{

	Random rand = new Random();

	private int card;
	private int jogada;// contador para numero de jogadas (ate cada um jogar as 10 cartas)

	carta cartas = new carta(card);// criacao das varias cartas
	funcoes funcao = new funcoes();

	private int[] c1 = funcao.getC_1();
	private int[] c2 = funcao.getC_2();
	private int[] c3 = funcao.getC_3();
	private int[] c4 = funcao.getC_4();

	jogador j1 = new jogador();
	jogador j2 = new jogador();
	jogador j3 = new jogador();
	jogador j4 = new jogador();

	private int card_primeiro;

	private int pontos1;// pontos equipa 1 durante jogo
	private int pontos2;// pontos equipa 2 durante jogo

	private int partida_1;// partidas ganhas pela equipa 1
	private int partida_2;// partidas ganhas pela equipa 2

	public int getPartida_1()
	{
		return partida_1;
	}

	public void setPartida_1(int partida_1)
	{
		this.partida_1 = partida_1;
	}

	public int getPartida_2()
	{
		return partida_2;
	}

	public void setPartida_2(int partida_2)
	{
		this.partida_2 = partida_2;
	}

	public jogo()
	{
		this.card = card;
	}

	// definiçao de pontos para cada jogador para fazer somatorio da vazada
	private int pontos_j1;
	private int pontos_j2;
	private int pontos_j3;
	private int pontos_j4;

	public void ordem_do_jogo()
	{

		if (j1.getPontos_1() > j2.getPontos_1() && j1.getPontos_1() > j3.getPontos_1()
				&& j1.getPontos_1() > j4.getPontos_1())
		{
			j1.utilizador(0, c1, card_primeiro);
			card_primeiro = j1.getCard_primeiro();
			c1 = j1.getMao();

			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();

			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();

			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
		}

		else if (j3.getPontos_1() > j2.getPontos_1() && j3.getPontos_1() > j1.getPontos_1()
				&& j3.getPontos_1() > j4.getPontos_1())
		{
			j3.automatico(0, 2, c3, card_primeiro);
			card_primeiro = j3.getCard_primeiro();
			c3 = j3.getMao();

			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();
		}

		else if (j2.getPontos_1() > j3.getPontos_1() && j2.getPontos_1() > j1.getPontos_1()
				&& j2.getPontos_1() > j4.getPontos_1())
		{
			j2.automatico(0, 1, c2, card_primeiro);
			card_primeiro = j2.getCard_primeiro();
			c2 = j2.getMao();

			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();
			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
		}

		else if (j4.getPontos_1() > j2.getPontos_1() && j4.getPontos_1() > j1.getPontos_1()
				&& j4.getPontos_1() > j3.getPontos_1())
		{
			j4.automatico(0, 3, c4, card_primeiro);
			card_primeiro = j4.getCard_primeiro();
			c4 = j4.getMao();
			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();
			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();
		}

	}

	public void primeira_jogada()
	{

		if (funcao.getJb() == 0)
		{

			j1.utilizador(0, c1, card_primeiro);
			card_primeiro = j1.getCard_primeiro();
			c1 = j1.getMao();

			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();

			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();

			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
		}

		if (funcao.getJb() == 1)
		{
			j2.automatico(0, 1, c2, card_primeiro);
			card_primeiro = j2.getCard_primeiro();
			c2 = j2.getMao();

			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();
			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
		}

		if (funcao.getJb() == 2)
		{
			j3.automatico(0, 2, c3, card_primeiro);
			card_primeiro = j3.getCard_primeiro();
			c3 = j3.getMao();

			j4.automatico(1, 3, c4, card_primeiro);
			c4 = j4.getMao();
			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();
		}

		if (funcao.getJb() == 3)
		{
			funcao.def_trunfo();
			j4.automatico(0, 3, c4, card_primeiro);
			card_primeiro = j4.getCard_primeiro();
			c4 = j4.getMao();

			j1.utilizador(1, c1, card_primeiro);
			c1 = j1.getMao();
			j2.automatico(1, 1, c2, card_primeiro);
			c2 = j2.getMao();
			j3.automatico(1, 2, c3, card_primeiro);
			c3 = j3.getMao();
		}
	}

	String iguais = "=============================================================== \n";

	public void desenrolar_do_jogo()
	{
		pontos1 = 0;
		pontos2 = 0;
		funcao.primeiro_baralhador();
		funcao.baralha();
		funcao.primeira_funcao();
		funcao.def_trunfo();
		primeira_jogada();

		pontos_j1 = j1.getPontos_1();

		pontos_j2 = j2.getPontos_1();

		pontos_j3 = j3.getPontos_1();

		pontos_j4 = j4.getPontos_1();
		int intermedio = 0;
		if ((pontos_j1 > pontos_j2 && pontos_j1 > pontos_j3 && pontos_j1 > pontos_j4))
		{
			intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
					+ j4.getPontos_verdadeiros();
			pontos1 = pontos1 + intermedio;
			System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 0. \n " + intermedio
					+ " Pontos a atribuir ao jogador 0 e ao jogador 2! \n" + iguais);
		}

		else if (pontos_j3 > pontos_j2 && pontos_j3 > pontos_j1 && pontos_j3 > pontos_j4)
		{
			intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
					+ j4.getPontos_verdadeiros();
			pontos1 = pontos1 + intermedio;
			System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 2. \n " + intermedio
					+ " Pontos a atribuir ao jogador 0 e ao jogador 2! \n" + iguais);
		}

		else if (pontos_j2 > pontos_j1 && pontos_j2 > pontos_j3 && pontos_j2 > pontos_j4)
		{

			intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
					+ j4.getPontos_verdadeiros();
			pontos2 = pontos2 + intermedio;
			System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 1. \n " + intermedio
					+ " Pontos a atribuir ao jogador 1 e ao jogador 3! \n" + iguais);
		}
		else if (pontos_j4 > pontos_j2 && pontos_j4 > pontos_j1 && pontos_j4 > pontos_j3)
		{

			intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
					+ j4.getPontos_verdadeiros();
			pontos2 = pontos2 + intermedio;
			System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 3. \n " + intermedio
					+ " Pontos a atribuir ao jogador 1 e ao jogador 3! \n" + iguais);
		}
		jogada = 1;
		while (jogada <= 10)
		{
			intermedio = 0;
			ordem_do_jogo();

			pontos_j1 = j1.getPontos_1();
			pontos_j2 = j2.getPontos_1();
			pontos_j3 = j3.getPontos_1();
			pontos_j4 = j4.getPontos_1();
			if ((pontos_j1 > pontos_j2 && pontos_j1 > pontos_j3 && pontos_j1 > pontos_j4))
			{
				intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
						+ j4.getPontos_verdadeiros();
				pontos1 = pontos1 + intermedio;
				System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 0. \n " + intermedio
						+ " Pontos a atribuir ao jogador 0 e ao jogador 2! \n" + iguais);
			}

			else if (pontos_j3 > pontos_j2 && pontos_j3 > pontos_j1 && pontos_j3 > pontos_j4)
			{
				intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
						+ j4.getPontos_verdadeiros();
				pontos1 = pontos1 + intermedio;
				System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 2. \n " + intermedio
						+ " Pontos a atribuir ao jogador 0 e ao jogador 2! \n" + iguais);
			}

			else if (pontos_j2 > pontos_j1 && pontos_j2 > pontos_j3 && pontos_j2 > pontos_j4)
			{

				intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
						+ j4.getPontos_verdadeiros();
				pontos2 = pontos2 + intermedio;
				System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 1. \n " + intermedio
						+ " Pontos a atribuir ao jogador 1 e ao jogador 3! \n" + iguais);
			}
			else if (pontos_j4 > pontos_j2 && pontos_j4 > pontos_j1 && pontos_j4 > pontos_j3)
			{

				intermedio = j1.getPontos_verdadeiros() + j2.getPontos_verdadeiros() + j3.getPontos_verdadeiros()
						+ j4.getPontos_verdadeiros();
				pontos2 = pontos2 + intermedio;
				System.out.println(iguais + "A vaza " + jogada + " foi ganha pelo jogador 3. \n " + intermedio
						+ " Pontos a atribuir ao jogador 1 e ao jogador 3! \n" + iguais);
			}
			jogada++;

		}

	}

	public String pontuacao()
	{// pontuaçao ao longo do jogo
		String txt = " ";
		if (pontos1 >= 60 && pontos1 < 90)
		{
			partida_1++;
			if (partida_1 == 4)
			{
				txt = "Parabéns, você e o seu parceiro ganharam o jogo!!!";
			}
			else
			{
				txt = "Você e o seu parceiro ganharam esta partida. \n Possuem agora " + partida_1 + " vitória(s)";
			}
		}

		else if (pontos1 >= 90 && pontos1 < 120)
		{
			partida_1 = partida_1 + 2;
			if (partida_1 >= 4)
			{
				txt = "Parabéns, você e o seu parceiro ganharam o jogo!!!";
			}
			else
			{
				txt = "Você e o seu parceiro ganharam 2 partidas. \n Possuem agora " + partida_1 + " vitória(s)";
			}
		}

		else if (pontos1 == 120)
		{
			partida_1 = partida_1 + 4;
			txt = "Parabéns, você e o seu parceiro ganharam o jogo!!!";
		}

		else if (pontos2 >= 60)
		{
			partida_2++;
			if (partida_2 == 4)
			{
				txt = "Os seus rivais ganharam o jogo! \n Tente outra vez!! :(";
			}
			else
			{
				txt = "Os seus rivais ganharam a partida \n Estes possuem agora " + partida_2 + " vitória(s)";
			}
		}

		else if (pontos2 >= 90)
		{
			partida_2 = partida_2 + 2;
			if (partida_2 >= 4)
			{
				txt = "Os seus rivais ganharam o jogo! \n Tente outra vez!! :(";
			}
			else
			{
				txt = "Os seus rivais ganharam 2 partida \n Estes possuem agora " + partida_2 + " vitória(s)";
			}
		}

		else if (pontos2 == 120)
		{
			partida_2 = partida_2 + 4;
			txt = "Os seus rivais ganharam o jogo! \n Tente outra vez!! :(";
		}
		return (iguais + "\n" + txt + "\n" + iguais);
	}
}
