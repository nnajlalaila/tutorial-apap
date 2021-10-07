package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;


import java.util. ArrayList;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;
    @Qualifier("filmServiceImpl")
    @Autowired
    private FilmService filmService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop",new BioskopModel());
        return "form-add-bioskop";
    }

//    @PostMapping("/bioskop/add")
//    public String addBioskopsubmit(
//            @ModelAttribute BioskopModel bioskop,
//            Model model
//    ){
//        bioskopService.addBioskop(bioskop);
//        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
//        return "add-bioskop";
//    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute ( "listBioskop",listBioskop);
        return "viewall-bioskop" ;
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop != null){
            List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
            model.addAttribute( "bioskop", bioskop);
            model.addAttribute("listPenjaga", listPenjaga);
            model.addAttribute("listFilm", bioskop.getListFilm());


            return "view-bioskop";
        } else {
            model.addAttribute( "noBioskop", noBioskop);
            return "bioskop-not-found";
        }



    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop != null){
            model.addAttribute( "bioskop", bioskop);
            return"form-update-bioskop" ;
        } else {
            model.addAttribute( "noBioskop", noBioskop);
            return "bioskop-not-found";
        }

    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.updateBioskop(bioskop);
        model.addAttribute( "noBioskop",bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop != null){
            if(bioskop.getListPenjaga().size() == 0 && bioskopService.deleteBioskop(bioskop)){
                model.addAttribute("noBioskop",bioskop.getNoBioskop());
                return "delete-bioskop";
            }

            else if (bioskop.getListPenjaga().size() == 0 && !bioskopService.deleteBioskop(bioskop)){
                model.addAttribute("noBioskop",bioskop.getNoBioskop());
                return "bioskop-buka" ;
            }

            else if (bioskop.getListPenjaga().size() != 0 && bioskopService.deleteBioskop(bioskop)){
                model.addAttribute("noBioskop",bioskop.getNoBioskop());
                return "penjaga-masih" ;
            }

            else {
                model.addAttribute("noBioskop",bioskop.getNoBioskop());
                return "buka-dan-masih" ;
            }

        } else {
            model.addAttribute( "noBioskop", noBioskop);
            return "delete-id-not-found";
        }
    }


    @PostMapping(value = "/bioskop/add/", params = {"addRow"})
    private String addRow(
            @ModelAttribute BioskopModel bioskop,  BindingResult bindingResult,
            Model model
    ){
        if (bioskop.getListFilm() == null) {
            bioskop.setListFilm(new ArrayList<FilmModel>());
        }
        bioskop.getListFilm().add(new FilmModel());
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listAllFilm", filmService.getListFilm());
        return "form-add-bioskop";
    }



    @PostMapping(value="/bioskop/add/", params = {"deleteRow"})
    private String deleteRow(
            @ModelAttribute("bioskopModel") BioskopModel bioskop,
            final BindingResult bindingResult, final HttpServletRequest req,
            Model model
    ){
        final Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
        bioskop.getListFilm().remove(rowId.intValue());


        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listAllFilm", filmService.getListFilm());
        return "form-add-bioskop";
    }


     @PostMapping(value="/bioskop/add/", params = {"save"})
     private String save(@ModelAttribute BioskopModel bioskop, Model model) {
        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
        bioskopService.addBioskop(bioskop);
        return "add-bioskop";
    }
}