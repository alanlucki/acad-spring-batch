package com.example.acadspringbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.acadspringbatch.model.Comercio;

public class ComercioItemProcessor implements ItemProcessor<Comercio,Comercio> {

    private static final Logger LOG = LoggerFactory.getLogger(ComercioItemProcessor.class);

    @Override
    public Comercio process(Comercio item) throws Exception {
        String contrato = item.getContrato() ;
        String comercio = item.getComercio() ;
        String validacion = item.getValidacion() ;

        Comercio comer = new Comercio(contrato,comercio,validacion);
        LOG.info("Convirtiendo ("+item+") a ("+comer+")");
	
        return comer;
    }
    
}
