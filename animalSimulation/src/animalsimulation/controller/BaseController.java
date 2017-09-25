/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsimulation.controller;

import java.util.ArrayList;
import animalsimulation.model.base.BaseModel;
import animalsimulation.view.BaseView;

/**
 *
 * @author jeroen
 */
public abstract class BaseController {
    protected ArrayList<BaseView> views;
    protected BaseModel model;
    
    public BaseController() {
        views = new ArrayList<>();
    }
    
    public void addView(BaseView view) {
        this.views.add(view);
        view.updateView(model);
    }
    
    public void removeView(BaseView view) {
        this.views.remove(view);
    }
    
    protected void updateViews() {
        for(BaseView view : views) {
            view.updateView(model);
        }
    }
}
