package com.springbatch.demobatch.config;

import com.springbatch.demobatch.steps.ItemProcessorStep;
import com.springbatch.demobatch.steps.ItemReaderStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Bean
    public ItemReaderStep itemReaderStep(){
        return new ItemReaderStep();
    };

    @Bean
    public ItemProcessorStep itemProcessorStep(){
        return new ItemProcessorStep();
    }
}
