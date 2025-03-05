package ex03;

/**
 * Клас, що створює об'єкт ViewResult (ConcreteCreator).
 */
public class ViewableResult implements Viewable {
    @Override
    public View getView() {
        return new ViewResult();
    }
}