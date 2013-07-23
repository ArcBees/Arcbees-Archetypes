#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.admin;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class AdminView extends ViewImpl implements AdminPresenter.MyView {
    public interface Binder extends UiBinder<Widget, AdminView> {
    }

    @UiField
    HTML totalTaskCount;

    @Inject
    public AdminView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void displayTaskCount(Integer totalTasks) {
        if (totalTasks == null) {
            totalTaskCount.setText("0");
        } else {
            totalTaskCount.setText(totalTasks.toString());
        }
    }
}
