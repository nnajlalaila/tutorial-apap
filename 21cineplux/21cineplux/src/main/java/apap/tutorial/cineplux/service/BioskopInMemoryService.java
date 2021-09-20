package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService {
    private List<BioskopModel> listBioskop;
    private List<BioskopModel> listBioskop2 = new ArrayList<>();

    // Constructor
    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop, int jumlahStudio) {
        bioskop.setJumlahStudio(jumlahStudio);
    }


    @Override
    public void deleteBioskop(BioskopModel bioskop) {
        listBioskop.remove(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {

        for (BioskopModel bioskop : listBioskop) {
            if (bioskop.getIdBioskop().equals(idBioskop)){
                return bioskop;
            }
        }
        return null;
    }

    @Override
    public List<BioskopModel> getBioskopByJS(int jumlahStudio) {

        for (BioskopModel bioskop : listBioskop) {
            if (bioskop.getJumlahStudio() == jumlahStudio){
                listBioskop2.add(bioskop) ;
            }
        }
        return listBioskop2;
    }
}
