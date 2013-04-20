package ${package}.client.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface MyRequestFactory extends RequestFactory {
    MyServiceRequest myService();
}
