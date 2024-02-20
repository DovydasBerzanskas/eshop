package lt.codeacademy.eshop.mvc;

import java.util.Date;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeAdvice {

    @ModelAttribute("modelDateAttr")
    public Date now() {
        return new Date();
    }

    @ModelAttribute("modelCurrencyAttr")
    public char currency() {
        return '€';
    }
}
