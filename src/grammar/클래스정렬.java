package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 클래스정렬 {
	
	
	public static void main(String[] args) {
		
		Person [] person = new Person [5]; 
	
		
		person[2] = new Person( 27, 1000);
		person[4] = new Person( 28, 3);
		person[3] = new Person( 28, 10000);			
		person[0] = new Person( 25, 4); 
		person[1] = new Person( 28, 10000000); 
		
		Arrays.sort(person);
	
		for(int i=0; i<5; i++) {
			System.out.println(person[i].age+" "+person[i].money);
		}
		
		System.out.println();
		

		List <Animal>animal = new ArrayList<Animal>(); 
		
		animal.add(new Animal(28,4)); 
		animal.add(new Animal(23, 1000)); 
		animal.add(new Animal(27, 1000)); 
		animal.add(new Animal(28, 10000)); 
		animal.add(new Animal(28, 3)); 
		
//		Collections.sort(animal, new Comparator<Animal>() {
//
//			@Override
//			public int compare(Animal o1, Animal o2) {
//				if(o1.age==o2.age)return o1.type-o2.type; 
//				return o1.age-o2.age; 
//
//			}
//		});
		
		Collections.sort(animal, (o1, o2)->{
			if(o1.age==o2.age)return o1.type-o2.type; 
			return o1.age-o2.age; 			
		});

		
		for(Animal a : animal) {
			System.out.println(a.age+" "+ a.type);
		}
	
	}
	
	
	static class Animal {
		
		int age; 
		int type;
		public Animal() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Animal(int age, int type) {
			super();
			this.age = age;
			this.type = type;
		}
	
	}
	
	
	
	//comparable 은 객체의 정렬 기준을 만들어 주기 위함. 
	//java.lang package
	//Comparable 인터페이스의 구현체는 compareTo 메서드를 구현
	static class Person implements Comparable<Person>{
		
		int age; 
		int money; 
		
		public Person() {
			
		}

		public Person( int age, int money) {
	
			this.age = age; 
			this.money = money; 
		}

		@Override
		public int compareTo(Person o) {
			//나이 오름차순
			//돈도 오름차순 
			if(this.age==o.age) {
				return this.money - o.money; 
			}
			return this.age - o.age; 		
		}
	}
	

}
