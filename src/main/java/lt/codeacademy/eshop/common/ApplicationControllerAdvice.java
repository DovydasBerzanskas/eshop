package lt.codeacademy.eshop.common;

import lt.codeacademy.eshop.product.exception.ProductNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler
    public String productNotFound(ProductNotFoundException e, Model model) {
        model.addAttribute("productUUID", e.getProductUUID());
        return "product/error/productNotFound";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }
}
