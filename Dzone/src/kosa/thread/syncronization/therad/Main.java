package kosa.thread.syncronization.therad;

public class Main {

    public static void main(String[] args) {
        Manager m = new Manager();
        
        // 모든 객체가 매니저를 가지도록 인자로 넣어줌
        Baker b1 = new Baker("김탁구", m); 
        Baker b2 = new Baker("박탁구", m);
        Baker b3 = new Baker("이탁구", m);

        Customer c1 = new Customer("김소비", m);
        Customer c2 = new Customer("박소비", m);
        Customer c3 = new Customer("조소비", m);

        b1.start();
        c1.start();

        b2.start();
        c2.start();

        b3.start();
        c3.start();

    }

}
