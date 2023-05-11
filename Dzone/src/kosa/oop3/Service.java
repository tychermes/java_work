package kosa.oop3;

public class Service {

	private Dao dao;	// Service와 ~~Dao 클래스는 연관관계
	
	public Service() {}
	
	public Service(Dao dao) {
		super();
		this.dao = dao;
	}

	public void insertService() {
		dao.insert();
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	

}
