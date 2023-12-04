package application;

public class CalcController {
    private CalcModel myModel;
    private ViewInterface myView;

    public CalcController(CalcModel model, ViewInterface view) {
        this.myModel = model;
        this.myView = view;
    }
}