package Avaliacao5;

import java.util.Random;

public class funcoes
{
	Random rand = new Random();

	public int[] getC_1()
	{
		return c_1;
	}

	public void setC_1(int[] c_1)
	{
		this.c_1 = c_1;
	}

	public int[] getC_2()
	{
		return c_2;
	}

	public void setC_2(int[] c_2)
	{
		this.c_2 = c_2;
	}

	public int[] getC_3()
	{
		return c_3;
	}

	public void setC_3(int[] c_3)
	{
		this.c_3 = c_3;
	}

	public int[] getC_4()
	{
		return c_4;
	}

	public void setC_4(int[] c_4)
	{
		this.c_4 = c_4;
	}

	private int[] c_1;
	private int[] c_2;
	private int[] c_3;
	private int[] c_4;

	private int c1;
	private int c2;
	private int c3;
	private int c4;

	private int[] cartas;

	funcoes()
	{

		cartas = new int[40];

		c1 = 0;
		c2 = 0;
		c3 = 0;
		c4 = 0;

		c_1 = new int[10];
		c_2 = new int[10];
		c_3 = new int[10];
		c_4 = new int[10];

	}

	// funcoes de cada jogador
	private int jb;

	public int getJb()
	{
		return jb;
	}

	public void setJb(int jb)
	{
		this.jb = jb;
	}

	public void primeira_funcao()
	{

		if ((jb) == 3)
		{
			corta(1);
			distribui(2);

		}
		else if ((jb) == 2)
		{
			corta(0);
			distribui(1);

		}
		else if (jb == 1)
		{
			corta(3);
			distribui(0);

		}
		else
		{
			corta(2);
			distribui(3);

		}

	}

	public void rotacao()
	{// rotacao para proximo jogo
		if ((jb) == 3)
		{
			jb = 0;

		}
		else if ((jb) == 2)
		{
			jb = 3;

		}
		else if (jb == 1)
		{
			jb = 2;

		}
		else
		{
			jb = 1;

		}

	}

	public void primeiro_baralhador()
	{
		jb = rand.nextInt(4);
	}

	public void baralha()
	{// define jogador que baralha
		// quem baralha, joga 1a carta:

		System.out.println("É o jogador " + jb + " que irá baralhar");
		int[] elementos_ja_existentes = new int[40];

		for (int j = 0; j < cartas.length; j++)
		{
			elementos_ja_existentes[j] = -1;
		}
		for (int j = 0; j < cartas.length; j++)
		{
			int k = rand.nextInt(40);

			if (elementos_ja_existentes[k] == -1)
			{
				elementos_ja_existentes[k] = j;
				cartas[k] = elementos_ja_existentes[k];
			}
			else if (elementos_ja_existentes[k] != -1)
			{
				j--;
			}
		}
	}

	private int c;

	public int getC()
	{
		return c;
	}

	public void setC(int c)
	{
		this.c = c;
	}

	public void corta(int c)
	{// define jogador que corta
		System.out.println("É o jogador " + c + " que irá cortar.");
		int calhas = rand.nextInt(40);
		int[] cartas_2 = new int[40];
		for (int j = 0; j < calhas; j++)
		{
			cartas_2[cartas.length - calhas + j] = cartas[j];
		}
		for (int j = calhas; j < cartas.length; j++)
		{
			cartas_2[j - calhas] = cartas[j];

		}
		cartas = cartas_2;

	}

	private int dt;

	public int getDt()
	{
		return dt;
	}

	public void setDt(int dt)
	{
		this.dt = dt;
	}

	private int card;
	private int j;

	public void distribui(int dt)
	{// define jogador que distribui e executa sua funcao
		System.out.println("É o jogador " + dt + " que irá distribuir.");
		setDt(dt);
		for (card = 0; card < 10; card++)
		{
			c_1[c1] = cartas[card];
			c1++;
		}

		for (card = 10; card < 20; card++)
		{
			c_2[c2] = cartas[card];
			c2++;
		}

		for (card = 20; card < 30; card++)
		{
			c_3[c3] = cartas[card];
			c3++;
		}
		for (card = 30; card < 40; card++)
		{
			c_4[c4] = cartas[card];
			c4++;
		}
	}

	public int def_trunfo()
	{
		int trf = 0;
		if (dt == 1)
		{
			trf = c_2[9];

		}
		else if (dt == 2)
		{
			trf = c_3[9];

		}
		else if (dt == 3)
		{
			trf = c_4[9];

		}
		else if (dt == 0)
		{
			trf = c_1[9];

		}
		return trf;

	}

}
