package br.edu.ifsp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ReflectionTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		Pessoa person = new Pessoa();
		person.setId(1);
		person.setNome("Gabriel");
		person.setAlcoolotra(true);
		person.setIdade(16);
		
		//Instanciar classe construtor sem parametros
		Class<?> cl = Class.forName("br.edu.ifsp.reflection.Teste");
		Constructor<?> cons = cl.getConstructor();
		Object o = cons.newInstance();
		
		//Instanciar classe construtor com parametros
		Class<?> c2 = Class.forName("br.edu.ifsp.reflection.Teste");
		Constructor<?> cons2 = c2.getConstructor(String.class);
		Object o2 = cons2.newInstance("Teste com parametros");
		
		System.out.println("----------Atributos-------------");
		
		//listar atributos
		Map<String, Object> attributes = ReflectionMapper.getAttributesMap(person);

		for(String key : attributes.keySet()) {
			System.out.println(key + ": " + attributes.get(key));
		}
		
		System.out.println("-----------------------");
		
		attributes = ReflectionMapper.getAttributesMap(o);

		for(String key : attributes.keySet()) {
			System.out.println(key + ": " + attributes.get(key));
		}
		
		System.out.println("-----------------------");
		
		attributes = ReflectionMapper.getAttributesMap(o2);

		for(String key : attributes.keySet()) {
			System.out.println(key + ": " + attributes.get(key));
		}
		
		System.out.println("----------Métodos-------------");
		
		//listar metodos
		for (Method method : Pessoa.class.getDeclaredMethods()) {
		    String name = method.getName();
		    System.out.println(name);
		}
		
		System.out.println("-----------------------");
		
		//listar metodos
		for (Method method : Teste.class.getDeclaredMethods()) {
		    String name = method.getName();
		    System.out.println(name);
		}
		System.out.println("-----------------------");
		
		//Visibilidade do metodo
		Method method = o2.getClass().getDeclaredMethod("printUm");
		method.setAccessible(true);
		Object r = method.invoke(o2);

	}
}
