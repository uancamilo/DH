package Presencial;

import Presencial.dao.BD;
import Presencial.dao.IDao;
import Presencial.dao.MedicamentoDAOH2;
import Presencial.model.Medicamento;
import Presencial.service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //primero: crear las tablas
        BD.crearTablas();
        //segundo: preparar un medicamento para guardar
        Medicamento medicamento=new Medicamento(1,9874,
                "Amoxicilina","Tecno",1500,4000.0);
        IDao<Medicamento> daomed=new MedicamentoDAOH2();
        MedicamentoService medicamentoService= new MedicamentoService(daomed);
        //tercero: guardar un medicamento mediante ayuda del service
        medicamentoService.guardarMedicamento(medicamento);


    }
}