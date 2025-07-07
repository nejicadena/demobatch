package com.springbatch.demobatch.steps;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.springbatch.demobatch.entities.Person;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j

public class ItemReaderStep implements Tasklet {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        log.info("-------------------> Inicio del paso de la LECTURA <----------------------");

        Reader reader = new FileReader(resourceLoader.getResource("classpath:files/destination/persons.csv").getFile());

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .withSkipLines(1)
                .build();

        List<Person> personsList = new ArrayList<>();
        String[] AtualLine;

        while ((AtualLine = csvReader.readNext()) != null) {
            Person person = new Person();
            person.setName(AtualLine[0]);
            person.setLastName(AtualLine[1]);
            person.setAge(Integer.parseInt(AtualLine[2]));

            personsList.add(person);
        }

        csvReader.close();
        reader.close();

        log.info("-------------------> Fin del paso de la LECTURA <----------------------");

        chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("personsList", personsList);


        return RepeatStatus.FINISHED;
    }
}
