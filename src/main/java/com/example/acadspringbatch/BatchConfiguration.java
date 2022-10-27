package com.example.acadspringbatch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.acadspringbatch.listener.JobListener;
import com.example.acadspringbatch.model.Comercio;
import com.example.acadspringbatch.processor.ComercioItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Comercio> reader() {
        return new FlatFileItemReaderBuilder<Comercio>()
                .name("comercioItemReader")
                .resource(new ClassPathResource("comercios.cvs"))
                .delimited()
                .names(new String[] { "contrato", "comercio", "validacion" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Comercio>() {
                    {
                        setTargetType(Comercio.class);
                    }
                })
                .build();
    }

    @Bean
    public ComercioItemProcessor processor() {
        return new ComercioItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Comercio> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Comercio>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO comercio (contrato, comercio, validacion) VALUES (:contrato, :comercio, :validacion)")
				.dataSource(dataSource)
				.build();
    }

    @Bean
	public Job importComercioJob(JobListener listener, Step step1) {
		return jobBuilderFactory.get("importComercioJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	
	@Bean
	public Step step1(JdbcBatchItemWriter<Comercio> writer) {
		return stepBuilderFactory.get("step1")
				.<Comercio, Comercio> chunk(2)
				.reader(reader())
				.writer(writer)
				.build();
	}

}
