package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.rest.PenjagaUmur;
import reactor.core.publisher.Mono;

import java.util.List;
public interface PenjagaRestService {
        PenjagaModel createPenjaga(PenjagaModel bioskop);

        List<PenjagaModel> retrieveListPenjaga();

        PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);

        PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate);

        void deletePenjaga(Long noPenjaga);

        PenjagaModel jsonGetUmur (Long noPenjaga);

        List<PenjagaModel> getAllPenjagaByGender (String jenisKelamin);
}
