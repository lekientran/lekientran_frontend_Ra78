package com.vti;

import java.util.List;

import com.vti.entity.Address;
import com.vti.entity.User;
import com.vti.repository.AddressRepository;
import com.vti.repository.UserRepository;

public class Program {
	public static void main(String[] args) {
		AddressRepository addressRepository = new AddressRepository();

		UserRepository userRepository = new UserRepository();

		System.out.println("***********GET ALL Users***********");

		List<User> users = userRepository.getAllUsers();

		for (User user : users) {
			System.out.println(user);
		}


		System.out.println("***********GET ALL ADDRESSES***********");

		List<Address> addresses = addressRepository.getAllAddresses();

		for (Address address : addresses) {
			System.out.println(address);
		}





//		UserRepository userRepository = new UserRepository();
//
//		System.out.println("***********GET ALL USERS***********");
//
//		List<User> users = userRepository.getAllUsers();
//
//		for (User user : users) {
//			System.out.println("User: " + user.getUsername());
//			for (UserAddress userAddress : user.getUserAddresses()) {
//				Address address = userAddress.getAddress();
//				System.out.println("Address: " + address.getStreet() + " - " + address.getCity());
//				System.out.println("Registered at: " + userAddress.getRegisteredAt());
//			}
//			System.out.println("");
//		}
	}
}













