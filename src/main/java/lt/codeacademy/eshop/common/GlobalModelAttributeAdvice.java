package lt.codeacademy.eshop.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

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
