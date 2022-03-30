package lambdas;

import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTestTres {
	
	public static void main(String[] args) {
		
		// meta reference ::
		
		//forEach(asList("Marcelo", "Camila", "Gabriel", "Rafael"), (String s) -> System.out.println(s));
		forEach(asList("Marcelo", "Camila", "Gabriel", "Rafael"), System.out :: println);
		
		List<Carro> carros = asList(new Carro("Vermelho", 1999), new Carro("Azul", 2005),new Carro("Preto",1985));
				         // substituir por lambda
		//Collections.sort(carros, new Comparator<Carro>(){
		//	@Override
		//	public int compare(Carro c1, Carro c2) {
		//		return c1.getCor().compareTo(c2.getCor());
		//	}
		//});
		Collections.sort(carros, (c1,c2) -> c1.getCor().compareTo(c2.getCor()));
		Collections.sort(carros,(c1,c2) -> c1.getCor().compareTo(c2.getCor()));
		System.out.println(carros);
		
		System.out.println("_______________________________________________________"+"\n");
		
		// Reference to a static method
		Collections.sort(carros, ComparadorCarro :: comparePorCor);
		System.out.println(carros);
		// Reference to an instance method of a particular object
		ComparadorCarro comparadorCarro = new ComparadorCarro();
		Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro :: new;
		//Collections.sort(carros, comparadorCarroSupplier.get():: comparePorAno);
		Collections.sort(carros, ComparadorCarro :: comparePorAno);
		System.out.println(carros);
		// Reference to an instance method of an arbitrary object of a particular type
		List<String> nomes = asList("Marcelo","Camila","Gabriel","Rafael");
		//nomes.sort((s1,s2) -> s1.compareTo(s2));
		nomes.sort((s1,s2) -> s2.compareTo(s1));		
		//nomes.sort(String::compareTo);
		System.out.println(nomes);
		Function<String, Integer> strinToInteger = (String s) -> Integer.parseInt(s);
		Function<String,Integer> stringToInteger2 = Integer :: parseInt;
		BiPredicate<List<String>, String> contains = (Lista,elemento) -> Lista.contains(elemento);
		BiPredicate<List<String>,String> contains2 = List::contains;
		System.out.println(stringToInteger2.apply("10"));
		System.out.println(contains2.test(nomes, "Marcelo"));
		// Relerence to a constructor
		BiFunction<String,Integer,Carro> carroBiFunction = (s,i) -> new Carro(s,i);
		BiFunction<String, Integer, Carro> carroBiFunction2 = Carro :: new;
		System.out.println(carroBiFunction.apply("Rosa", 1994));
		
	}
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T e : list) {
			c.accept(e);
		}
	}
	
	public static <T,R> List<R> map(List<T> list, Function<T,R> f){
		List<R> result = new ArrayList<>();
		for( T e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
	

}
