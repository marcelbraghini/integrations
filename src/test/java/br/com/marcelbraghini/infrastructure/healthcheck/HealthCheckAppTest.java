package br.com.marcelbraghini.infrastructure.healthcheck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HealthCheckAppTest {

    @Mock
    HealthCheckApp healthCheckApp;

    @Test
    public void ShouldRunHealthCheck() {
        healthCheckApp.call();

        verify(healthCheckApp, times(1)).call();
    }
}
