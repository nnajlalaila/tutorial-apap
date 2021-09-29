package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import apap.tutorial.cineplux.service.PenjagaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {

    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("penjaga/add/{noBioskop}")
    public String addPenjagaForm( @PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagasubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{no_penjaga}")
    public String updatePenjagaForm(
            @PathVariable Long no_penjaga,
            Model model
    ){
        PenjagaModel penjaga = penjagaService.getPenjangaByNoPenjaga(no_penjaga);
        if (penjaga != null){
            model.addAttribute( "penjaga", penjaga);
            return"form-update-penjaga" ;
        } else {
            model.addAttribute( "nopenjaga", no_penjaga);
            return "no-penjaga-not-found";
        }

    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {

        if (penjagaService.updatePenjaga(penjaga)) {
            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
            model.addAttribute("nopenjaga", penjaga.getNopenjaga());
            return "update-penjaga";
        } else {
            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
            return "bioskop-buka";
        }
    }

    @GetMapping("/penjaga/delete/{no_penjaga}")
    public String deletePenjagaForm(
            @PathVariable Long no_penjaga,
            Model model
    ){
        PenjagaModel penjaga = penjagaService.getPenjangaByNoPenjaga(no_penjaga);
        if (penjaga != null){
            if(penjagaService.deletePenjaga(penjaga)){
                model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
                model.addAttribute("nopenjaga", penjaga.getNopenjaga());
                return"delete-penjaga" ;
            } else {
                model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
                return"bioskop-buka" ;
            }
        } else {
            model.addAttribute("nopenjaga", no_penjaga);
            return "no-penjaga-not-found";
        }
    }
}