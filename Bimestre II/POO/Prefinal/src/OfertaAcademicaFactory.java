public class OfertaAcademicaFactory {
    private static OfertaAcademicaFactory instance;
    private OfertaAcademicaFactory(){
    }

    public static OfertaAcademicaFactory getInstance(){
        if (instance == null){
            instance = new OfertaAcademicaFactory();
        }
        return instance;
    }
    public OfertaAcademica crearOfertaAcademica(String codigo){
        switch (codigo) {
            case "Codigo_front":
                return new Curso("Front", "curso", 2.0, 2.0, 16.00);
            case "Codigo_back":
                return new Curso("BackEnd", "BackEnd", 160.00, 2.0, 120.00);
        }
        return null;
    }
}
