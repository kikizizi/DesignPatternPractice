import java.util.ArrayList;
import java.util.List;

interface Subject{
  public void add(Observer observer);
  public void delete(Observer observer);
  public void notifyObserver();  
}

interface Observer{
  public void update(String var1,String var2,String var3);
}

interface DisplayElement{
  public void display();
}

class VarData implements Subject{
  private List<Observer> observers;
  private String var1;
  private String var2;
  private String var3;

  public VarData(){
    observers = new ArrayList<Observer>();
  }

  @Override
  public void add(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void delete(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObserver() {
    for (Observer observer : observers){
      observer.update(var1,var2,var3);
    }
  }
  
  public void changeData(){
    notifyObserver();
  }

  public void addDatas(String var1,String var2,String var3){
    this.var1=var1;
    this.var2=var2;
    this.var3=var3;
    changeData();
  }
}

class DisplayData1and2 implements DisplayElement, Observer {
  private String var1;
  private String var2;
  private VarData varData;

  public DisplayData1and2(VarData varData){
    this.varData=varData;
    varData.add(this);
  }

  @Override
  public void display() {
    System.out.println("var1 :" +var1+", var2 : "+ var2);
  }

  @Override
  public void update(String var1, String var2, String var3) {
    //무엇을 출력할지에 따라서 선택
    this.var1=var1;
    this.var2=var2;
    display();
  }
}

class DisplayData1and2and3 implements DisplayElement, Observer{
  private String var1;
  private String var2;
  private String var3;
  private VarData varData;

  public DisplayData1and2and3(VarData varData){
    this.varData = varData;
    varData.add(this);
  }

  @Override
  public void display() {
    System.out.println("var1 : " +var1+", var2 : "+ var2+", var3 : "+var3);
  }

  @Override
  public void update(String var1, String var2, String var3) {
    this.var1=var1;
    this.var2=var2;
    this.var3=var3;
    display();
  }

  
}

public class ObserverPattern{
  public static void main(String[] args) {
    VarData vardata = new VarData();
    
    DisplayData1and2 displayData1and2 = new DisplayData1and2(vardata);
    DisplayData1and2and3 displayData1and2and3=new DisplayData1and2and3(vardata);

    vardata.addDatas("김은식","병신","찐따");
    // vardata.addDatas("what", "the", "fword");   
  }
}