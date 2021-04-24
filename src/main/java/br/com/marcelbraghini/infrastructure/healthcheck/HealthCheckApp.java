package br.com.marcelbraghini.infrastructure.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class HealthCheckApp implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("microservice");
    }
}
