package lambdas;

@FunctionalInterface
public interface CarroPredicate {

	 boolean test(Carro carro); 
	 
	 // (paramentros) -> <expressao> = codigo, algoritmo
    // assinatura do metodo ser� responsavel pela assinatura da lambida
}