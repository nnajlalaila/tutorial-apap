package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variable id bioskop ke "idbioskop" untuk di render ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model){
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke "listBioskop" untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if(bioskopService.getBioskopList().contains(bioskopModel)) {
            //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
            model.addAttribute("bioskop", bioskopModel);
            return "view-bioskop";
        }
        model.addAttribute("idBioskop", idBioskop);
        return "viewbyid-notfound";
    }


    @GetMapping("bioskop/view/id-bioskop/{idBioskop}")
    public String viewPakeId(
            @PathVariable String idBioskop,
            Model model
    ){
            //Mendapatkan bioskop sesuai dengan idBioskop
            BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

            if(bioskopService.getBioskopList().contains(bioskopModel)) {
                //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
                model.addAttribute("bioskop", bioskopModel);
                return "view-bioskop";
            }
            model.addAttribute("idBioskop", idBioskop);
            return "viewbyid-notfound";




    }



    @RequestMapping("bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop (
            @PathVariable String idBioskop,
            Model model
    ){
            BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
            if(bioskopService.getBioskopList().contains(bioskop)){
                bioskopService.deleteBioskop(bioskop);
                model.addAttribute("bioskop", bioskop);
                return "delete-success";
            }
            model.addAttribute("idBioskop", idBioskop);
            return "delete-id-not-found";


    }

    @RequestMapping("bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updatePakeId(
            @PathVariable String idBioskop,   @PathVariable  int jumlahStudio,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
        if(bioskopService.getBioskopList().contains(bioskop)){
            bioskopService.updateBioskop(bioskop,jumlahStudio);
            model.addAttribute("bioskop", bioskop);
            //Add variable semua BioskopModel ke "bioskop" untuk dirender dalam thymeleaf
            return "update-success";
        }
        model.addAttribute("idBioskop", idBioskop);
        return "update-id-not-found";





    }

}