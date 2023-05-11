package kosa.oop3;

public class Main {

	public static void main(String[] args) {
		
		MySQLDao mySqlDao = new MySQLDao();
		OracleDao oracleDao = new OracleDao();

		Service service = new Service(mySqlDao); //파라미터를 oracleDao로 바꾸기만 해도 됨.
		service.insertService();

		Service serve = new Service(new Dao() {
			@Override
			public void insert() {
				System.out.println("MSSQLDao insert");
			}
		});
		
	}

}
