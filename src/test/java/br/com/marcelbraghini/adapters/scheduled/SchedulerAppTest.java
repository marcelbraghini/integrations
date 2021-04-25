package br.com.marcelbraghini.adapters.scheduled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SchedulerAppTest {

    @Mock
    SchedulerApp schedulerApp;

    @Test
    public void ShouldRunScheduled() throws IOException {
        schedulerApp.increment();

        verify(schedulerApp, times(1)).increment();
    }
}
