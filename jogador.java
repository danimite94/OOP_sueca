package Avaliacao5;

import java.util.Random;
import java.util.Scanner;

public class jogador
{

	Random rand = new Random();
	Scanner scan = new Scanner(System.in);

	funcoes funcao = new funcoes();

	private int[] mao;

	public int[] getMao()
	{
		return mao;
	}

	public void setMao(int[] mao)
	{
		this.mao = mao;
	}

	private int c_mao;

	public int getC_mao()
	{
		return c_mao;
	}

	public void setC_mao(int c_mao)
	{
		this.c_mao = c_mao;
	}

	private int card_primeiro = 0;

	jogador()
	{
		mao = new int[10];

		this.c_mao = 0;

	}

	public int getCard_primeiro()
	{
		return card_primeiro;
	}

	public void setCard_primeiro(int card_primeiro)
	{
		this.card_primeiro = card_primeiro;
	}

	private int naipe_trunfo;
	private int elemento;

	private int max;

	private int pontos_1;

	private int pontos_verdadeiros;

	public int getPontos_verdadeiros()
	{
		return pontos_verdadeiros;
	}

	public void setPontos_verdadeiros(int pontos_verdadeiros)
	{
		this.pontos_verdadeiros = pontos_verdadeiros;
	}

	public int getPontos_1()
	{
		return pontos_1;
	}

	public void setPontos_1(int pontos_1)
	{
		this.pontos_1 = pontos_1;
	}

	private int ind_carta;

	public int getInd_carta()
	{
		return ind_carta;
	}

	public void setInd_carta(int ind_carta)
	{
		this.ind_carta = ind_carta;
	}

	carta carta = new carta(ind_carta);

	private boolean teste;
	private int card_utilizador;

	public boolean check(int[] array, int valor)
	{
		for (int j = 0; j < array.length; j++)
		{
			if (array[j] / 10 == valor / 10)
				return true;
		}
		return false;

	}

	public boolean check_integer(int valor_1, int valor_2)
	{
		if (valor_1 == valor_2)
			return true;
		else
			return false;
	}

	private int trunfo = funcao.def_trunfo();

	public void utilizador(int tipo, int[] mao, int card_primeiro)
	{

		teste = false;
		naipe_trunfo = trunfo / 10; // permite criar variavel com numero correspondente a trunfo
		// jogada do utilizador
		System.out.println("Possui as cartas: ");
		for (int j = 0; j < mao.length; j++)
		{
			elemento = mao[j];
			carta.exibir_cartas(elemento);
			System.out.print(carta.imagem());
			System.out.println(" -----> carta " + j);
		}
		// escolha da carta
		if (tipo == 0)
		{
			while (!teste)
			{
				System.out.println("Introduza o numero (válido) correpondente à carta que pretende:");
				if (scan.hasNextInt())
				{

					ind_carta = scan.nextInt();
					card_utilizador = mao[ind_carta];
					carta.exibir_cartas(card_utilizador);
					setCard_primeiro(card_utilizador);
					teste = true;

					if (ind_carta > mao.length || ind_carta < 0)
					{
						System.out.println("valores nao aceites!! ");
						teste = false;
					}

				}
				else
				{
					System.out.println("nao introduziu valor numerico");
				}
			}

		}

		else if (tipo == 1)
		{
			while (!teste)
			{
				System.out.println("Introduza o numero (válido) correpondente à carta que pretende:");
				if (scan.hasNextInt())
				{

					ind_carta = scan.nextInt();
					card_utilizador = mao[ind_carta];
					carta.exibir_cartas(card_utilizador);

					teste = true;
					if (ind_carta > mao.length || ind_carta < 0)
					{
						System.out.println("valores nao aceites!! ");
						teste = false;
					}
					else if (check(mao, card_primeiro) && (!check_integer(card_utilizador / 10, card_primeiro / 10)))
					{// evita que utilizador nao assista.
						System.out
								.println("Possui na sua mao carta(s) do mesmo naipe das já jogadas. Terá de a(s) jogar. NADA DE BATOTA!");
						teste = false;
					}
				}
				else
				{
					System.out.println("nao introduziu valor numerico");
					teste = false;
					scan.next();
				}
			}
		}

		System.out.print("Você jogou ");
		carta.exibir_cartas(card_utilizador);
		System.out.println(carta.imagem());

		if (check_integer(card_utilizador / 10, naipe_trunfo))
		{
			pontos_1 = (39 - card_utilizador) + 12 + carta.getP(); // soma de 12 permite diferenciar de cartas
																	// "nao trunfo". valor "39-card_auto" permite
																	// diferenciar entre cartas com zero pontos
			setPontos_1(pontos_1);

			setPontos_verdadeiros(carta.getP());

		} // soma de cartas.getP() é para diferenciar qual o maior trunfo, caso sejam jogados mais que um
		else
		{
			pontos_1 = carta.getP();
			setPontos_1(pontos_1);

			setPontos_verdadeiros(carta.getP());
		}

		// renovaçao das cartas que o utilizador possui apos a sua jogada
		int tamanho = mao.length;
		int[] mao_2 = new int[tamanho - 1];

		for (int sai = 0; sai < mao_2.length; sai++)
		{

			if (sai >= ind_carta)
			{
				mao_2[sai] = mao[sai + 1];
			}

			else
			{
				mao_2[sai] = mao[sai];
			}
		}
		mao = mao_2;

		setMao(mao);

	}

	private int card_auto;
	private int ind_carta_temp;
	private int pontos_auto;

	public void automatico(int tipo, int jogador, int[] mao, int card_primeiro)
	{

		int j_auto;
		trunfo = funcao.def_trunfo();
		naipe_trunfo = trunfo / 10; // permite criar variavel com numero correspondente a trunfo

		if (tipo == 0)
		{// quando jogador automatico é o primeiro
			ind_carta = rand.nextInt(mao.length);
			carta.exibir_cartas(mao[ind_carta]);

			pontos_auto = carta.getP();
			card_auto = mao[ind_carta];
			setCard_primeiro(card_auto);

		}

		else if (tipo == 1)
		{// jogador automatico joga em 2o, 3o ou 4o
			// System.out.println(card_primeiro);
			max = -1;
			for (j_auto = 0; j_auto < mao.length; j_auto++)
			{// percorre cartas de jogador

				if (mao[j_auto] / 10 == card_primeiro / 10)
				{// ve se ha alguma carta cujo naipe seja semelhante ao jogado pelo 1o jogador

					ind_carta_temp = j_auto;
					carta.exibir_cartas(mao[ind_carta_temp]);

					if ((carta.getP() + (39 - mao[ind_carta_temp])) > max)// soma de valor da carta serve para
																			// distinguir entre 6,5,4,3,2
					{
						max = carta.getP() + (39 - mao[ind_carta_temp]);
						ind_carta = ind_carta_temp;

						pontos_auto = carta.getP();
						card_auto = mao[ind_carta];
					}

				}

				else if (!check(mao, card_primeiro))
				{// caso jogue naipe diferente

					ind_carta = rand.nextInt(mao.length);
					pontos_auto = carta.getP();
					card_auto = mao[ind_carta];

				}
			}

		}

		if (check_integer(card_auto / 10, naipe_trunfo))
		{
			pontos_1 = (39 - card_auto) + 12 + pontos_auto; // soma de 12 permite diferenciar de cartas "nao trunfo".
															// valor "39-card_auto" permite diferenciar entre cartas com
															// zero pontos
			setPontos_1(pontos_1);

			setPontos_verdadeiros(pontos_auto);
		} // soma de cartas.getP() é para diferenciar qual o maior trunfo, caso sejam jogados mais que um
		else
		{
			pontos_1 = pontos_auto;
			setPontos_1(pontos_1);
			setPontos_verdadeiros(pontos_auto);

		}

		carta.exibir_cartas(card_auto);
		System.out.print(carta.imagem());
		System.out.println("Jogada por jogador " + jogador);

		int tamanho_2 = mao.length;
		int[] mao_2 = new int[tamanho_2 - 1];
		for (int jog_auto = 0; jog_auto < mao_2.length; jog_auto++)
		{

			if (jog_auto >= ind_carta)
			{
				mao_2[jog_auto] = mao[jog_auto + 1];
			}

			else
			{
				mao_2[jog_auto] = mao[jog_auto];
			}
		}
		// para teste
		mao = mao_2;
		setMao(mao);

	}

}
