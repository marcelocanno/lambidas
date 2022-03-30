package lambdas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;


public class CarroTest {
	
	// apresenta erro em tempo de compilação nullPinterException linha 10, linha 31
		// todos apresentam erros
		private static List<Carro> filtrarCarroPorCor(List<Carro> carros,String cor){
			List<Carro> result = new ArrayList<>();
			for(Carro carro : carros) {
				if(carro.getCor().equals(cor))
					result.add(carro);
			}
			return result;
		}
		/*
		private static List<Carro> filtrarCarroVerde(List<Carro> carros){
			List<Carro> result = new ArrayList<>();
			for(Carro carro : carros) {
				if(carro.getCor().equals("verde"))
				result.add(carro);
			}
			return result;
		}
	    */
		private static List<Carro> filtrarCarrosDezAnosFabricados(List<Carro> carros){
			List<Carro> result = new ArrayList<>();
			for(Carro carro : carros) {
				if(carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10))
					result.add(carro);
			}
			return result;
		}
		public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate){
			List<Carro> result = new ArrayList<>();
			for(Carro carro : carros) {
				if(carroPredicate.test(carro))
					result.add(carro);
			}
			return result;
		}
		
		public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate){
			List<T> result = new ArrayList<>();
			for(T e : list) {
				if(predicate.test(e)) {
					result.add(e);
				}
			}
			return result;
		}
		
		
		public static void main(String[] args) {

			List<Carro> carros = asList(new Carro("verde", 2011), new Carro("vermelho", 1995), new Carro("preto", 2017));
			//System.out.println(filtrarCarroVerde(carros));
			//System.out.println(filtrarCarroPorCor(carros, "verde"));
			//System.out.println(filtrarCarrosDezAnosFabricados(carros));
			//System.out.println(filtrarCarros(carros, new CarroCorVerdePredicate()));
			//System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentePredicate()));
			//System.out.println(filtrarCarros(carros, (Carro carro) -> carro.getcor().equals("verde")));
			
			
			System.out.println(filtrarCarros(carros, new CarroPredicate(){
				@Override
				public boolean test(Carro carro) {
					return carro.getCor().equals("verde");
				}
			}));	
		}
		private static List<Carro> asList(Carro carro, Carro carro2, Carro carro3) {
			return null;
		}
	}