
import br.com.hibernate.entities.LabLote;
import br.com.hibernate.entities.LabPaciente;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.entities.LabUsuarioUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ricardo
 */
public class TestPortalRicardo {

    public static void main(String[] args) {
//        LabLote ll = (LabLote) OracleHelper.getObject(LabLote.class, "51025", "DEFAULT");
        
//        int total = 0;
//        int i = 12;
//        long inicio = System.currentTimeMillis();
//        for (int i1 = 0; i1 <= i; i1++) {
//            for (int i2 = 0; i2 <= i; i2++) {
//                for (int i3 = 0; i3 <= i; i3++) {
//                    for(int i4 = 0; i4 <= i; i4++){
//                        for(int i5 = 0; i5 <= i; i5++){
//                            for(int i6 = 0; i6 <= i; i6++){
//                                if (i1 == i2 || i1 == i3 || i1 == i4 || i1 == i5 || i1 == i6 ||
//                                        i2 == i3 || i2 == i4 || i2 == i5 || i2 == i6 || i3 == i4 ||
//                                        i3 == i5 || i3 == i6 ||i4 == i5 || i4 == i6 || i5 == i6) {
//                                    continue;
//                                }
//                                total += 1;
//                                System.out.println(i1 + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + i6);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        Long tempoExec = System.currentTimeMillis() - inicio;
//        if(tempoExec < 1000){
//            System.out.println("Demorou: " + (tempoExec) + " milissegundos");
//        }else if(tempoExec >= 1000 && tempoExec < 60000){
//            System.out.println("Demorou: " + (tempoExec)/100 + " segundos");
//        }else if(tempoExec >= 60000){
//            System.out.println("Demorou: " + (tempoExec)/100/60 + " minutos");
//        }else{
//            System.out.println("Demorou: " + (tempoExec)/100/60/60 + " horas");
//        }
//        System.out.println(new DecimalFormat("#,###").format(total).replace(',', '.'));
        
        
//        LabUsuario lu = OracleHelper.getLabUsuario("RICARDOBR", "NUILIN0", "DEFAULT");
//        System.out.println(lu.getUsuStNome());
//        List<LabUsuarioUnidade> lluu = lu.getListLabUnidadeUsuario();
//        for (LabUsuarioUnidade labUsuarioUnidade : lluu) {
//            System.out.println(labUsuarioUnidade.getUniStCodigo());
//        }
//        LabUsuario lu = (LabUsuario) OracleHelper.getObject(LabUsuario.class, "ANDREAPR", "DEFAULT");
//        System.out.println(lu.getUsuStSenha());
    }
}
