package lambdas;


public class LambdaTest  {
		// anonima
		// function
		// passada
		// concisa
		// (Carro carro) -> carro.getCor().equals("verde"); -> lambida
		// (String s) -> s.length
		// (int a, int b) -> (System.out.println(a+b);
	
	public static void main(String[] args) {	
		CarroPredicate carropredicate = new CarroPredicate() {		
			@Override
			public boolean test(Carro carro) {
				return carro.getCor().equals("verde");
			}
		};
		
		CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
		
		System.out.println(carroPredicate2.test(new Carro("verde", 2012)));
		System.out.println(carropredicate.test(new Carro("verde", 2012)));
		
		// treinando lambda
		
		Runnable runnable = () -> System.out.println("Dentro do run");
		new Thread(runnable).start();
	}
}