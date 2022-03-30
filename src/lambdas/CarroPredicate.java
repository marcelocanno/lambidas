package lambdas;

@FunctionalInterface
public interface CarroPredicate {

	 boolean test(Carro carro); 
	 
	 // (paramentros) -> <expressao> = codigo, algoritmo
    // assinatura do metodo será responsavel pela assinatura da lambida
}