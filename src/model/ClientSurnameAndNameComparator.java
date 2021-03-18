package model;

import java.util.Comparator;

public class ClientSurnameAndNameComparator implements Comparator<Client>{

	@Override
	public int compare(Client c1, Client c2) {
		int comparation=0;

		String client1=c1.getSurname();

		String client2=c2.getSurname();
		
		String nameClient1=c1.getName();
		
		String nameClient2=c2.getName();


		if(client1.compareTo(client2)<0){

			comparation=1;

		}else if(client1.compareTo(client2)>0){

			comparation=-1;

		}else{
			
			comparation= nameClient2.compareTo(nameClient1);

		}

		return comparation;

	}

}

