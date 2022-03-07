import model.Polinom;
import view.CalcView;
import controller.Controller;

public class Main {
    public static void main(String[] args) {
        CalcView view = new CalcView();
        Polinom modelPolinom1 = new Polinom();
        Polinom modelPolinom2 = new Polinom();
        Controller controller = new Controller(view, modelPolinom1, modelPolinom2);

    }
}
