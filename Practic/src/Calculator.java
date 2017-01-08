/**
 * Created by Йотун on 07.01.2017.
 */
public class Calculator {
    private int result=0;

    public int getResult() {
        return result;
    }
    public void clearResult(){
        result=0;
    }
    public void add(int k,int s){
        result=k+s;
    }
    public void deduct(int k,int s){
        result=k-s;
}
    public void multiply(int k,int s){
        result = k*s;
    }
    public void delete(int k,int s){
        result=k/s;
    }

}
