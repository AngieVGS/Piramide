package models.dao;

import java.util.Comparator;
import java.util.Date;

import exceptions.ErrorNotFound;
import exceptions.RegisteredPartner;
import models.comparator.ComparatorPartner;
import models.entities.Genre;
import models.entities.Order;
import models.entities.Partner;
import models.entities.Product;
import structureData.NTree;
import structureData.NodeSimpleList;
import structureData.SimpleList;

@SuppressWarnings("rawtypes")
public class Company extends NTree{
	
	@SuppressWarnings("unchecked")
	public Company(Comparator comparator) {
		super(comparator);
	}

	/**
	 * Crea un nuevo socio
	 * @param id
	 * @param registerDate
	 * @param idLegal
	 * @param name
	 * @param surname
	 * @param genre
	 * @param birthday
	 * @param stratum
	 * @param parent
	 * @return
	 */
	public static Partner createPartner(int id, Date registerDate, int idLegal, String name, String surname,
			Genre genre, Date birthday, int stratum, int parent) {
		return new Partner(id, registerDate, idLegal, name, surname, genre, birthday, stratum, parent);
	}


	/**
	 * Método que agrega un socio con un referido al árbol
	 * @param partner es el referido
	 * @param partnerFather es el socio padre, es decir, quien refirio a partner
	 * @throws RegisteredPartner 
	 */
	public void registerPartner(Partner partner, Partner partnerFather) throws RegisteredPartner {
		if (findParent(partner) == null ) {
			add(partner, partnerFather);	
		}else{
			throw new RegisteredPartner();
		}
	}
	
	public void deletePartner(Partner partnerToDelete) {
		// TO-DO REMOVE
		// partnersTree.remove(partnerToDelete);
	}

	public void editPartner(int idOldPartner, Partner newPartner) throws Exception {
		//searchPartner(idOldPartner).editParnet(newPartner);
	}
	
}