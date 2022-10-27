package com.example.acadspringbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.acadspringbatch.model.Comercio;

@Component
public class JobListener extends JobExecutionListenerSupport {

    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOG.info("Finalizo el Job, verifica los resultados");
            
            jdbcTemplate
                    .query(
                            "SELECT contrato , comercio , validacion FROM comercio",
                            (rs, row) -> new Comercio(rs.getString(1), rs.getString(2), rs.getString(3)))
                    .forEach(
                            persona -> LOG.info("Resgistro<" + persona + ">"));

        }
        if (jobExecution.getStatus() == BatchStatus.STARTING) {
            LOG.info("Iniciando Job");
        }
        if (jobExecution.getStatus() == BatchStatus.FAILED) {
            LOG.info("Job ha fallado");
        }


    }
}
