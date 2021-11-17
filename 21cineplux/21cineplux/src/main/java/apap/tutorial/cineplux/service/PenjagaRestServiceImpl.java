package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.BioskopDetail;
import apap.tutorial.cineplux.rest.PenjagaUmur;
import apap.tutorial.cineplux.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService{
    private final WebClient webClient;
    @Autowired
    private PenjagaDB penjagaDB;

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNopenjaga(noPenjaga);

        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
            LocalTime now = LocalTime.now();
            PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);


            if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
                penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
                penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
                penjaga.setBioskop(penjagaUpdate.getBioskop());
                return penjagaDB.save(penjaga);
            } else {
                throw new UnsupportedOperationException("Bioskop still open!");
            }


    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }
    public PenjagaRestServiceImpl(WebClient.Builder webclientBuilder){
        this.webClient = webclientBuilder.baseUrl(Setting.agifyUrl).build();
    }

    @Override
    public PenjagaModel jsonGetUmur (Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
            Integer umur = this.webClient.get().uri("?name=" + penjaga.getNamaPenjaga().split(" ")[0])
                    .retrieve()
                    .bodyToMono(PenjagaUmur.class).block().getUmur();

            penjaga.setUmurPenjaga(umur);
            penjagaDB.save(penjaga);
            return penjaga;
        }
         else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }


}
