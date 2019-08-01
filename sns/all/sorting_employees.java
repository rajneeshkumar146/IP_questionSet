package SnS;

import java.util.Arrays;
import java.util.Scanner;

public class sorting_employees {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			employee[] arr = new employee[n];
			for (int i = 0; i < n; i++) {
				String name = scn.next();
				int sal = scn.nextInt();
				arr[i] = new employee(name, sal);
			}
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i].name + " " + arr[i].salary + " ");
			}
			System.out.println();
		}
	}

	public static class employee implements Comparable<employee> {
		String name;
		int salary;

		employee(String n, int sal) {
			this.name = n;
			this.salary = sal;
		}

		public int compareTo(employee o) {
			if (this.salary == o.salary) {
				return this.name.compareTo(o.name);
			} else {
				return this.salary - o.salary;
			}
		}
	}
}
