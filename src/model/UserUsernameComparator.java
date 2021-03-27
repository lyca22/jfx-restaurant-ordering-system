package model;

import java.util.Comparator;

public class UserUsernameComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		int comparation=0;
		String user1=o1.getUsername();
		String user2=o2.getUsername();
		if(user1.compareTo(user2)<0){
			comparation=1;
		}else if(user1.compareTo(user2)>0){
			comparation=-1;
		}else{
			comparation= 0;
		}
		return comparation;
	}

}
