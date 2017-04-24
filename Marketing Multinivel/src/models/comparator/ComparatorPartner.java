package models.comparator;

import java.util.Comparator;

import models.entities.Partner;

public class ComparatorPartner implements Comparator<Partner> {

	@Override
	public int compare(Partner o1, Partner o2) {
		if (o1.getIdLegal() == o2.getIdLegal()) {
			return 0;
		}else {
		return 1;
		}
	}

}
