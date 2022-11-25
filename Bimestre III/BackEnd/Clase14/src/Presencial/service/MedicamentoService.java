package Presencial.service;

import Presencial.dao.IDao;
import Presencial.model.Medicamento;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    }

}