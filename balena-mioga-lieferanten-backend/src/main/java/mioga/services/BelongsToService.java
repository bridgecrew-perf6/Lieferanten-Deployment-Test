package mioga.services;

import mioga.entites.BelongsTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class BelongsToService {

    private static final Logger LOGGER = Logger.getLogger(BelongsToService.class.getName()) ;

    @Autowired
    BelongsToService belongsToService;



    public BelongsTo save(BelongsTo belongsTo) {

        return belongsToService.save(belongsTo);
    }


}
