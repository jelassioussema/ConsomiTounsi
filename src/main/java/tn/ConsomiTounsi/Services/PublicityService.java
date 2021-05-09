package tn.ConsomiTounsi.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Repositories.PublicityRep;


@Service
@Transactional
public class PublicityService implements IPublicityService {
	@Autowired 
	PublicityRep prp;
	@Override
	public List<Publicity> getAllpublicity() {
		// TODO Auto-generated method stub
		return prp.findAll();
		
	}

	@Override
	public Publicity getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Publicity publicity) {
		// TODO Auto-generated method stub
		prp.save(publicity);
	}

	@Override
	public void deletepublicity(int id) {
		// TODO Auto-generated method stub
		prp.deleteById(id);
	}

	@Override
	public Publicity updatepublicity(int id, Publicity publicity) {
		// TODO Auto-generated method stub
		Publicity pr1 = prp.findById(id).get();
		pr1.setNom(pr1.getNom());
		pr1.setCanal(pr1.getCanal());
		pr1.setCout(pr1.getCout());
		pr1.setDateDebut(pr1.getDateDebut());
		pr1.setDateFin(pr1.getDateFin());
		pr1.setImage(pr1.getImage());
		pr1.setEmailProprietaire(pr1.getEmailProprietaire());
		pr1.setNumeroProprietaire(pr1.getNumeroProprietaire());
		pr1.setVideo(pr1.getVideo());
		
	
		
		
		return prp.save(pr1);
	}
	

}

