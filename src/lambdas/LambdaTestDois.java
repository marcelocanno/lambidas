package lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

import java.util.ArrayList;

public class LambdaTestDois {
	
	public static void main(String[] args) {
		forEach(asList("Marcelo", "Walter", "Gabriel", "Camila"), (String s) -> System.out.println(s));
		List<Integer> list = map(asList("Marcelo", "Walter", "Gabriel", "Camila"), (String s) -> s.length());
		List<Carro> carros = asList(new Carro("preto", 2013),new Carro("preto", 2017),new Carro("preto", 2010),new Carro("preto", 2003));
		List<String> listCores = map(carros,(Carro c) -> c.getCor() );
		System.out.println(listCores);
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		Predicate<Integer> impar = (Integer i) -> i % 2 == 1;
		System.out.println(impar.test(1000));
		System.out.println(pares.test(1000));
		Predicate <String> p = (String s) -> listCores.add(s);
		Consumer<String> b = (String s) -> listCores.add(s);
		b.accept("Amarelo");
		p.test("Amarelo");
		System.out.println(listCores);
        System.out.println(list);
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T e : list) {
			c.accept(e);
		}
	}
	
	public static <T,R> List<R> map(List<T> list, Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
}
