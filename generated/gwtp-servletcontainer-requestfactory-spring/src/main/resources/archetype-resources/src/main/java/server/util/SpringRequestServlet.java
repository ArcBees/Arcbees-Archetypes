package ${package}.server.util;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringRequestServlet extends RequestFactoryServlet {
    static class LoquaciousExceptionHandler implements ExceptionHandler {
        private static final Logger LOG = LoggerFactory.getLogger(LoquaciousExceptionHandler.class);

        @Override
        public ServerFailure createServerFailure(Throwable throwable) {
            LOG.error("Server error", throwable);
            return new ServerFailure(throwable.getMessage(), throwable.getClass().getName(), null, true);
        }
    }

    public SpringRequestServlet() {
        super(new LoquaciousExceptionHandler());
    }
}
