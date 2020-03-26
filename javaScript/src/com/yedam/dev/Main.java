package com.yedam.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("Hong" , "111", 20);
		Student s2 = new Student("Hwang" , "S222", 21);
		Student s3 = new Student("Park" , "S333", 22);
		System.out.println(" == 배열 == ");
		Student[] stuAry = { s1, s2, s3 };
		for(Student s : stuAry) {
			System.out.println(s.toString());
		}
		
		System.out.println(" == ArrayList ==");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for (Student s : list) {
			System.out.println(s);
		}
		
		System.out.println(" == Set == ");
		Set<Student> stuSet = new HashSet<Student>();
		stuSet.add(s1);
		stuSet.add(s2);
		stuSet.add(s3);
		
		Iterator<Student> iter = stuSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println(" == Map == "); // key, value
		Map<Integer, Student> stuMap = new HashMap<Integer, Student>();
		stuMap.put(1, s1);
		stuMap.put(2, s2);
		stuMap.put(3, s3);
		
		Set<Integer> iSet = stuMap.keySet();
		Iterator<Integer> iter2 = iSet.iterator();
		while(iter2.hasNext()) {
			Integer iKey = iter2.next(); // key값과 value 값을 찍어볼려고
			System.out.println("key: " +iKey+ ", value: " + stuMap.get(iKey).toString());
		}
		
		System.out.println(" == Map II ==");
		Set<Map.Entry<Integer, Student>> mSet = stuMap.entrySet();
		Iterator<Map.Entry<Integer, Student>> iter3 = mSet.iterator();
		while(iter3.hasNext()) {
			Map.Entry<Integer, Student> rMap = iter3.next();
			System.out.println("key: " + rMap.getKey()
							+", value: " + rMap.getValue());
		}
	}  // End of Main

}
