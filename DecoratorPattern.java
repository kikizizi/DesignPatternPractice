interface Component {
  String add(); //재료 추가
}

class BaseComponent implements Component {
  @Override
  public String add() {
      // TODO Auto-generated method stub
      return "에스프레소";
  }
}

abstract class Decorator implements Component {
  private Component coffeeComponent;
  
  public Decorator(Component coffeeComponent) {
      this.coffeeComponent = coffeeComponent;
  }
  
  public String add() {
      return coffeeComponent.add();
  }
}

//우유를 추가해주는 클래스ㅌ 
class MilkDecorator extends Decorator {
  public MilkDecorator(Component coffeeComponent) {
      super(coffeeComponent);
  }
  
  @Override
  public String add() {
      // TODO Auto-generated method stub
      return super.add() + " + 우유";
  }
}

//물을 추가해주는 클래스
class WaterDecorator extends Decorator {
  public WaterDecorator(Component coffeeComponent) {
      super(coffeeComponent);
  }
  
  @Override
  public String add() {
      // TODO Auto-generated method stub
      return super.add() + " + 물";
  }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Component espresso = new BaseComponent();
        System.out.println("에스프레소 : " + espresso.add());
        
        Component americano = new WaterDecorator(new BaseComponent());
        System.out.println("아메리카노 : " + americano.add());
        
        Component latte = new MilkDecorator(new WaterDecorator(new BaseComponent()));
        System.out.println("라떼 : " + latte.add());
    }
}