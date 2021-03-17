package model;

import java.util.Comparator;

public class ClientSurnameComparator implements Comparator<Client>{

	@Override
	public int compare(Client c1, Client c2) {
		int comparation=0;

		String client1=c1.getSurname();

		String client2=c2.getSurname();

		if(client1.compareTo(client2)<0){

			comparation=1;

		}else if( client1.compareTo(client2)>0){

			comparation=-1;

		}else{

			comparation=0;

		}

		return comparation;

	}

}

