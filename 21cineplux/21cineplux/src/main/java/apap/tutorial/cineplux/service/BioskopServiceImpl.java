package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {
    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public void updateBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public List<BioskopModel> getBioskopList() { return bioskopDB.findByOrderByNamaBioskopAsc(); }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }

    @Override
    public boolean deleteBioskop(BioskopModel bioskop) {
        LocalTime now = LocalTime.now();
        LocalTime open = bioskop.getWaktuBuka();
        LocalTime close = bioskop.getWaktuTutup();

        boolean tutup = false;
        if (now.compareTo(open) <= 0 || now.compareTo(close) >= 0){
            bioskopDB.delete(bioskop);
            tutup = true;

        }
        return tutup;
    }
}