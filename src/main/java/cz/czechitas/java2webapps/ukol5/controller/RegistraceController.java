package cz.czechitas.java2webapps.ukol5.controller;

import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {

    private final Random registrationNo = new Random();

    @GetMapping("/")
    public ModelAndView formular() {
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("regForm", new RegistraceForm());
        return modelAndView;

    }

    @PostMapping("")
    public Object form(@ModelAttribute("regForm") @Valid RegistraceForm regForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }

        if (regForm.getDateOfBirth().until(LocalDate.now()).getYears() < 9) {
            bindingResult.rejectValue("dateOfBirth", "", "Participant's age is lower than allowed (child must be at least 9 years of age).");
            return "formular";
        }
        ;
        if (regForm.getDateOfBirth().until(LocalDate.now()).getYears() > 15) {
            bindingResult.rejectValue("dateOfBirth", "", "Participant's age is over the age limit (child must be at younger than 15).");
            return "formular";
        }
        ;
        if (regForm.getFavSports().size() < 2) {
            bindingResult.rejectValue("favSports", "", "At least 2 sports have to be selected.");
            return "formular";
        }

        return new ModelAndView("/registrationCompleted")
                .addObject("kod", Math.abs(registrationNo.nextInt()));

    }


}
