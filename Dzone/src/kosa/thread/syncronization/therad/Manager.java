package kosa.thread.syncronization.therad;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    List<String> list = new ArrayList<String>();//진열장(3개)
    // 병렬 처리하려면 synchonized 키워드 사용해서 선언,생성 하는게 정석.

    //진열장에 빵을 추가
    public synchronized void push(String threadName, String bread) {
        while (list.size() > 3) {
            try {
                System.out.println(threadName + " 대기상태");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.add(bread);
        System.out.println(threadName + " : " + bread + " 만듬");
        this.notify();
    }

    //진열장에서 빵을 구매
    public synchronized void pop(String threadName) {
        while (list.size() == 0) {
            try {
                System.out.println(threadName + " 대기상태");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("진열장 빵갯수: " + list.size());
        String bread = list.remove(list.size() - 1); // 제일 마지막에 있는 빵을 사가기
        System.out.println(threadName + " : " + bread + " 구매");
        this.notify();
    }

}











