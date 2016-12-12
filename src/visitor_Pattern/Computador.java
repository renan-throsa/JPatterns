package visitor_Pattern;

public class Computador implements Computador_Componente {
	Computador_Componente[] parts;
	private int valor = 0;
	private String componente;
	private String detalhe;
	
	public Computador(int valor,String componente,String detalhe)
	{
		this.valor = valor;
		this.detalhe = detalhe;
		this.componente = componente;
		parts = new Computador_Componente[] {
				new Monitor(300,"Monitor","Samsung"),
				new Memoria(100,"Memoria","Kingston"),
				new Cpu(200,"Processador","Amd"),
				new Gpu(100,"Gpu","Amd"),
				new Gmemoria(100,"Gmemoria","Amd"),
				new Teclado(20,"Teclado","Maxprint")};
	}
	

	   public int getValor() {
		for (Computador_Componente pc : parts)
		{
			this.valor+= pc.getValor();
		}
		return this.valor;
	}



	public String getComponente() {
		return componente;
	}


	public String getDetalhe() {
		return detalhe;
	}


	   @Override
	   public void accept(ComputerPartVisitor computerPartVisitor) {
	      for (int i = 0; i < parts.length; i++) {
	         parts[i].accept(computerPartVisitor);
	      }
	      computerPartVisitor.visit(this);
	   }
}
