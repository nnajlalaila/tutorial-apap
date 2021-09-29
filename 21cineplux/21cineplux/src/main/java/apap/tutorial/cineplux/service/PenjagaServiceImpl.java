package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {
    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public boolean updatePenjaga(PenjagaModel penjaga) {
        LocalTime now = LocalTime.now();
        LocalTime open = penjaga.getBioskop().getWaktuBuka();
        LocalTime close = penjaga.getBioskop().getWaktuTutup();

        boolean tutup = false;
        if (now.compareTo(open) <= 0 || now.compareTo(close) >= 0){
            penjagaDB.save(penjaga);
            tutup = true;
        }
        return tutup;
    }

    @Override
    public PenjagaModel getPenjangaByNoPenjaga(Long no_penjaga) {
        Optional<PenjagaModel> penjaga= penjagaDB.findByNopenjaga(no_penjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public boolean deletePenjaga(PenjagaModel penjaga) {
        LocalTime now = LocalTime.now();
        LocalTime open = penjaga.getBioskop().getWaktuBuka();
        LocalTime close = penjaga.getBioskop().getWaktuTutup();

        boolean tutup = false;
        if (now.compareTo(open) <= 0 || now.compareTo(close) >= 0){
            penjagaDB.delete(penjaga);
            tutup = true;

        }
        return tutup;
    }

}