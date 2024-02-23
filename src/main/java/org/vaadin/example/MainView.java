package org.vaadin.example;

import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    public MainView() {
        final TextField field1 = new TextField();
        final TextField field2 = new TextField();

        add(field1, field2);

        final Binder<Bean> binder = new Binder<>();

        binder.forField(field1)
            .asRequired()
            .bind(Bean::getValue1, Bean::setValue1);

        binder.forField(field2)
            .asRequired()
            .bind(Bean::getValue2, Bean::setValue2);

        binder.setBean(new Bean());
    }

}
