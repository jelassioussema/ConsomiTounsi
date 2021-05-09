package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Publicity;


public interface IPublicityService {
	public List<Publicity> getAllpublicity();
	public  Publicity getByid(int id);
	public void saveOrUpdate(Publicity publicity);
	public void deletepublicity(int id);
	public Publicity updatepublicity(int id, Publicity publicity);
}
