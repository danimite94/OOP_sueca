package Avaliacao5;

public class carta
{

	private String[] cartas;
	private String[] naipes;
	private int[] pontos;

	private String[] cartasfinal;
	private String[] naipesfinal;
	private int[] pontosfinal;

	private int carta;
	private int naipe;
	private int valor;

	private int c = 0;// numero da carta escolhida/requisitada porada por utilizador (de 1 a 40)

	private String v;
	private String n;
	private int p;

	public String getV()
	{
		return v;
	}

	public void setV(String v)
	{
		this.v = v;
	}

	public String getN()
	{
		return n;
	}

	public void setN(String n)
	{
		this.n = n;
	}

	public int getP()
	{
		return p;
	}

	public void setP(int p)
	{
		this.p = p;
	}

	public int getC()
	{
		return c;
	}

	public void setC(int c)
	{
		this.c = c;
	}

	private int i;
	private String[] naipes_iniciais;

	carta(int c)
	{

		this.c = c;
		this.p = p;
		this.n = n;

		naipes = new String[] { "O", "E", "P", "C" };
		cartas = new String[] { "A", "R", "V", "D", "7", "6", "5", "4", "3", "2" };
		pontos = new int[] { 11, 4, 3, 2, 10, 0, 0, 0, 0, 0 };

		cartasfinal = new String[40];
		naipesfinal = new String[40];
		pontosfinal = new int[40];

	}

	public void exibir_cartas(int value)
	{
		i = 0;
		for (naipe = 0; naipe < naipes.length; naipe++)
		{
			valor = 0;

			for (carta = 0; carta < cartas.length; carta++)
			{
				cartasfinal[i] = cartas[carta];
				naipesfinal[i] = naipes[naipe];
				pontosfinal[i] = pontos[valor];
				if (value == i)
				{
					setP(pontos[valor]);
					setN(naipes[naipe]);
					setV(cartas[carta]);
				}
				i++;
				valor++;
			}
		}
	}

	public String imagem()
	{
		String elemento = "|---|\n|" + this.v + "  |\n|" + this.n + " " + this.n + "|\n|  " + this.v + "|\n|---|";
		return elemento;

	}

}
