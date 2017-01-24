package com.ktds.jgu;

import com.ktds.jgu.machine.Machine;
import com.ktds.jgu.customer.Customer;

public class VendingMachine {

	public void start() {
		Machine machine = new Machine("칸타타", 19, 8000);
		Customer customer = new Customer("포카리스웨트", 6000);
		
		customer.buy(machine);
		
		System.out.println(machine);
		System.out.println(customer);
		
	}
	
	public static void main(String[] args) {
		new VendingMachine().start();
	}
}
