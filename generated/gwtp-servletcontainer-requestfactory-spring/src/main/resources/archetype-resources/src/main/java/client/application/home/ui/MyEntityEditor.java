#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.home.ui;

import ${package}.client.request.proxy.MyEntityProxy;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MyEntityEditor extends Composite implements Editor<MyEntityProxy> {
    public interface Binder extends UiBinder<Widget, MyEntityEditor> {
    }

    public interface Driver extends SimpleBeanEditorDriver<MyEntityProxy, MyEntityEditor> {
    }

    @UiField
    TextBox firstName;
    @UiField
    TextBox lastName;

    private final Driver driver;

    @Inject
    public MyEntityEditor(Binder uiBinder, Driver driver) {
        this.driver = driver;

        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(this);
    }

    public void edit(MyEntityProxy myEntity) {
        firstName.setFocus(true);
        driver.edit(myEntity);
    }

    public MyEntityProxy get() {
        MyEntityProxy myEntity = driver.flush();
        if (driver.hasErrors()) {
            return null;
        } else {
            return myEntity;
        }
    }
}
