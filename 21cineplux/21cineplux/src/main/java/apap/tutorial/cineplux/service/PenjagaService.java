package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    boolean updatePenjaga(PenjagaModel penjaga);
    boolean deletePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjangaByNoPenjaga(Long no_penjaga);
}