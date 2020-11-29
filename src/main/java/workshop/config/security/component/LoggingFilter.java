package workshop.config.security.component;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@WebFilter
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class LoggingFilter extends OncePerRequestFilter {

    private final static Set<String> NOT_SUPPORTED_URLS = Set.of("swagger", "css", "csrf");

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            logRequest(start, request, response);
            MDC.clear();
        }
    }

    private void logRequest(long start, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isRequestedUrlLoggingSupported(request.getRequestURI())) {
            long timeElapsed = System.currentTimeMillis() - start;
            log.info("Request: {}, Params: {}, Method: {}, Body: {}, Response status: {}, User: {}, IP: {}, Lasted: {} ms",
                    request.getRequestURI(),
                    request.getQueryString(),
                    request.getMethod(),
                    request.getReader().lines().collect(Collectors.joining(System.lineSeparator())),
                    response.getStatus(),
                    MDC.get("username"),
                    MDC.get("ip"),
                    timeElapsed);
        }
    }

    private boolean isRequestedUrlLoggingSupported(String requestURL) {
        return NOT_SUPPORTED_URLS.stream().noneMatch(requestURL::contains);
    }
}
