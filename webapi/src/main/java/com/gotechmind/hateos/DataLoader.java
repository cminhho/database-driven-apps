package com.gotechmind.hateos;

import com.gotechmind.hateos.domain.FormField;
import com.gotechmind.hateos.domain.MultiValuedField;
import com.gotechmind.hateos.repository.FormFieldRepository;
import com.gotechmind.hateos.repository.MultiValuedFieldRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    final private FormFieldRepository formFieldRepository;
    final private MultiValuedFieldRepository multiValuedFieldRepository;

    public DataLoader(FormFieldRepository formFieldRepository, MultiValuedFieldRepository multiValuedFieldRepository) {
        this.formFieldRepository = formFieldRepository;
        this.multiValuedFieldRepository = multiValuedFieldRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Loading data...");

        formFieldRepository.save(new FormField(1L, "text", "text", "NAME", false));
        formFieldRepository.save(new FormField(2L, "text", "text", "AGE", false));
        formFieldRepository.save(new FormField(3L, "combo", "combo", "COUNTRY", true));

        multiValuedFieldRepository.save(new MultiValuedField(1L,"India", 3L));
        multiValuedFieldRepository.save(new MultiValuedField(2L,"Japan", 3L));
        multiValuedFieldRepository.save(new MultiValuedField(3L,"Korea", 3L));

    }
}