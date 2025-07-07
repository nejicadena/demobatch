package com.springbatch.demobatch.config;

import com.springbatch.demobatch.steps.ItemReaderStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Bean
    public ItemReaderStep itemReaderStep(){
        return new ItemReaderStep();
    };
}
