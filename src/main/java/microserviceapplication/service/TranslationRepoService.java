package microserviceapplication.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TranslationRepoService {

    MessageSource messageSource;

    public List<String> findByKey(List<String> key,Object... arguments){
        try {
            return key.stream()
                    .map(k->messageSource.getMessage(k,arguments,null))
                    .collect(Collectors.toList());
        }catch (NoSuchMessageException e){
            return Collections.emptyList();
        }
    }
}
