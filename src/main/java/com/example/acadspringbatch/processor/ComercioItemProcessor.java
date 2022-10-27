package com.example.acadspringbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.acadspringbatch.model.Comercio;

public class ComercioItemProcessor implements ItemProcessor<Comercio,Comercio> {

    private static final Logger LOG = LoggerFactory.getLogger(ComercioItemProcessor.class);

    @Override
    public Comercio process(Comercio item) throws Exception {
        // TODO Auto-generated method stub

        String contrato = item.getContrato() ;
        String comercio = item.getComercio() ;
        String validacion = item.getValidacion() ;

        Comercio comer = new Comercio(contrato,comercio,validacion);
        LOG.info("INICIAL : " + item.toString() + " - FINAL :" + comer.toString());

        return comer;
    }
    
}
