/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.monitor.faturamento;

import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;

import javax.faces.event.ActionEvent;



import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SlideEndEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name = "monitorDeFaturamentoViewBean")
public class MonitorDeFaturamentoView implements Serializable {

    private PortalView portal;
    private String strXtitlePacientes = "Horas";
    private String strXtitleExames = "Horas";
    private String strXtitleValor = "Horas";
    private String strYtitlePacientes = "Pacientes";
    private String strYtitleExames = "Exames";
    private String strYtitleValor = "Valor";
    private String strtitlePacientes = "Pacientes";
    private String strtitleExames = "Exames";
    private String strtitleValor = "Valor";
    
    private int intWidthChart = 1024;
    private int intHeightChart = 130;
    
    private int intWidthChartZoom = 1024;
    private int intHeightChartZoom = 420;
    
    
    private boolean blChartRenderedPaciente = true;
    private int intWidthChartZoomPaciente = 1024;
    private int intHeightChartZoomPaciente = 130;
    private boolean blChartRenderedExame = true;
    private int intWidthChartZoomExame = 1024;
    private int intHeightChartZoomExame = 130;
    private boolean blChartRenderedValor = true;
    private int intWidthChartZoomValor = 1024;
    private int intHeightChartZoomValor = 130;
    private boolean blAcumulativo = false;
    private boolean blUnificado = false;
    private String strListLabUnidadesHash;
    private int sliderValueAcumulativo = 100;
    private int sliderValueUnificado = 100;
//    LabUnidade labUnidade = null;
    Date dtBase = new Date();
    List<Color> listColor = new ArrayList<Color>();
    private boolean blPopUnidade = false;
    private String strChartMsg = "Clique no Grafico para mostrar mais informacoes.";
    private int intChoice = 0;
//    private String[] aXisLabelsHrsOfDay = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private String[] aXisLabelsHrsOfWeek = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
//    private String[] aXisLabelsDaysOfMonth = null;
    private String[] aXisLabelsUniversal = null;
    private CartesianChartModel axisChartPacientes;
    private CartesianChartModel axisChartPacientesZoom;
    private String clickedValuePacientes;
    private boolean initialzedPacientes = true;
    private double[][] dataPacientes = null;
    private CartesianChartModel axisChartExames;
    private CartesianChartModel axisChartExamesZoom;
    private String clickedValueExames;
    private boolean initialzedExames = true;
    private double[][] dataExames = null;
    private CartesianChartModel axisChartValor;
    private CartesianChartModel axisChartValorZoom;
    private String clickedValueValor;
    private boolean initialzedValor = true;
    private double[][] dataValor = null;

    public MonitorDeFaturamentoView() {
        super();
        init();
        initilizeCharts();
    }

    public void init() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        fillUpColorList();
//        this.sliderValueAcumulativo = 50;
//        this.sliderValueUnificado = 50;

    }

    private void initilizeCharts() {
//        System.out.println("@PostConstruct 2");
//        cleanAllUnits();



//        initialzedListUnidadesSelected();
        buildByDay();
    }

    public int getIntHeightChartZoom() {
        return intHeightChartZoom;
    }

    public void setIntHeightChartZoom(int intHeightChartZoom) {
        this.intHeightChartZoom = intHeightChartZoom;
    }

    public int getIntWidthChartZoom() {
        return intWidthChartZoom;
    }

    public void setIntWidthChartZoom(int intWidthChartZoom) {
        this.intWidthChartZoom = intWidthChartZoom;
    }

    
    
    public int getIntHeightChart() {
        return intHeightChart;
    }

    public void setIntHeightChart(int intHeightChart) {
        this.intHeightChart = intHeightChart;
    }

    public int getIntWidthChart() {
        return intWidthChart;
    }

    public void setIntWidthChart(int intWidthChart) {
        this.intWidthChart = intWidthChart;
    }

    public CartesianChartModel getAxisChartExames() {
        return axisChartExames;
    }

    public void setAxisChartExames(CartesianChartModel axisChartExames) {
        this.axisChartExames = axisChartExames;
    }

    public CartesianChartModel getAxisChartPacientes() {
        return axisChartPacientes;
    }

    public void setAxisChartPacientes(CartesianChartModel axisChartPacientes) {
        this.axisChartPacientes = axisChartPacientes;
    }

    public CartesianChartModel getAxisChartValor() {
        return axisChartValor;
    }

    public void setAxisChartValor(CartesianChartModel axisChartValor) {
        this.axisChartValor = axisChartValor;
    }

    public int getSliderValueAcumulativo() {
        return sliderValueAcumulativo;
    }

    public void setSliderValueAcumulativo(int sliderValue) {

        if (this.sliderValueAcumulativo != sliderValue) {
            if (sliderValue == 0) {
                blAcumulativo = true;
            } else {
                blAcumulativo = false;
            }
            refreshCharts(null);
        }
        this.sliderValueAcumulativo = sliderValue;
    }

    public int getSliderValueUnificado() {
        return sliderValueUnificado;
    }

    public void setSliderValueUnificado(int sliderValueUnificado) {
        if (this.sliderValueUnificado != sliderValueUnificado) {
            if (sliderValueUnificado == 0) {
                blUnificado = true;
            } else {
                blUnificado = false;
            }
            refreshCharts(null);
        }
        this.sliderValueUnificado = sliderValueUnificado;
    }

    public boolean isBlUnificado() {
        return blUnificado;
    }

    public void setBlUnificado(boolean blUnificado) {
        this.blUnificado = blUnificado;
    }

    public boolean isBlAcumulativo() {
        return blAcumulativo;
    }

    public void setBlAcumulativo(boolean blAcumulativo) {
        this.blAcumulativo = blAcumulativo;
    }

    public boolean isBlPopUnidade() {
        return blPopUnidade;
    }

    public void setBlPopUnidade(boolean blPopUnidade) {
        this.blPopUnidade = blPopUnidade;
    }

    public String getStrChartMsg() {
        return strChartMsg;
    }

    public void setStrChartMsg(String strChartMsg) {
        this.strChartMsg = strChartMsg;
    }

    public Date getDtBase() {
        return dtBase;
    }

    public void setDtBase(Date dtBase) {
        this.dtBase = dtBase;
    }

    public double[][] getDataPacientes() {
        return dataPacientes;
    }

    public void setDataPacientes(double[][] dataPacientes) {
        this.dataPacientes = dataPacientes;
    }

    public String getClickedValueExames() {
        return clickedValueExames;
    }

    public void setClickedValueExames(String clickedValueExames) {
        this.clickedValueExames = clickedValueExames;
    }

    public String getClickedValuePacientes() {
        return clickedValuePacientes;
    }

    public void setClickedValuePacientes(String clickedValuePacientes) {
        this.clickedValuePacientes = clickedValuePacientes;
    }

    public String getClickedValueValor() {
        return clickedValueValor;
    }

    public void setClickedValueValor(String clickedValueValor) {
        this.clickedValueValor = clickedValueValor;
    }

    public String getStrYMaxExames() {
        return grabMaxYByChart(buildArrayPointSum(dataExames));
    }

    public String getStrYMaxPacientes() {
        return grabMaxYByChart(buildArrayPointSum(dataPacientes));
    }

    public String getStrYMaxValor() {
        return grabMaxYByChart(buildArrayPointSum(dataValor));
    }

    public boolean isBlChartRenderedExame() {
        return blChartRenderedExame;
    }

    public void setBlChartRenderedExame(boolean blChartRenderedExame) {
        this.blChartRenderedExame = blChartRenderedExame;
    }

    public boolean isBlChartRenderedPaciente() {
        return blChartRenderedPaciente;
    }

    public void setBlChartRenderedPaciente(boolean blChartRenderedPaciente) {
        this.blChartRenderedPaciente = blChartRenderedPaciente;
    }

    public boolean isBlChartRenderedValor() {
        return blChartRenderedValor;
    }

    public void setBlChartRenderedValor(boolean blChartRenderedValor) {
        this.blChartRenderedValor = blChartRenderedValor;
    }

    public int getIntHeightChartZoomExame() {
        return intHeightChartZoomExame;
    }

    public void setIntHeightChartZoomExame(int intHeightChartZoomExame) {
        this.intHeightChartZoomExame = intHeightChartZoomExame;
    }

    public int getIntHeightChartZoomPaciente() {
        return intHeightChartZoomPaciente;
    }

    public void setIntHeightChartZoomPaciente(int intHeightChartZoomPaciente) {
        this.intHeightChartZoomPaciente = intHeightChartZoomPaciente;
    }

    public int getIntHeightChartZoomValor() {
        return intHeightChartZoomValor;
    }

    public void setIntHeightChartZoomValor(int intHeightChartZoomValor) {
        this.intHeightChartZoomValor = intHeightChartZoomValor;
    }

    public int getIntWidthChartZoomExame() {
        return intWidthChartZoomExame;
    }

    public void setIntWidthChartZoomExame(int intWidthChartZoomExame) {
        this.intWidthChartZoomExame = intWidthChartZoomExame;
    }

    public int getIntWidthChartZoomPaciente() {
        return intWidthChartZoomPaciente;
    }

    public void setIntWidthChartZoomPaciente(int intWidthChartZoomPaciente) {
        this.intWidthChartZoomPaciente = intWidthChartZoomPaciente;
    }

    public int getIntWidthChartZoomValor() {
        return intWidthChartZoomValor;
    }

    public void setIntWidthChartZoomValor(int intWidthChartZoomValor) {
        this.intWidthChartZoomValor = intWidthChartZoomValor;
    }

    private String defineStrDayOrHr(String strClicked) {
        String retorno = "";
        if (intChoice == 0) {
            retorno = strClicked + " Horas: ";
        } else if (intChoice == 1) {
            retorno = strClicked + "/" + ArrayItems.formatOnlyMonthAndYear.format(dtBase);
        } else if (intChoice == 2) {
            retorno = strClicked + "/" + ArrayItems.formatOnlyMonthAndYear.format(dtBase);
        }
        return retorno;
    }

    /**
     * Method to tell the page to render or not based on the initialized flag
     *
     * @param component chart component which will be rendered.
     * @return boolean true if OutputChart should be re-rendered; otherwise,
     * false.
     */
    public void newChartPacientes() {


        String[] arrayUniString = builArrayStringUniCodigo();
        Paint[] arrayPaint = buildArrayPaint();
        Shape[] shapes = buildArrayShapes();
        Stroke[] strokes = buildArrayStroke();

        axisChartPacientes = MonitorDeFaturamentoChartBuilder.buildAxisChart(aXisLabelsUniversal, buildArrayPointSum(dataPacientes), strXtitlePacientes, strYtitlePacientes, strtitlePacientes, shapes, strokes, arrayPaint, arrayUniString, intWidthChart, intHeightChart);

    }

    public void newChartExames() {
        String[] arrayUniString = builArrayStringUniCodigo();
        Paint[] arrayPaint = buildArrayPaint();
        Shape[] shapes = buildArrayShapes();
        Stroke[] strokes = buildArrayStroke();
        axisChartExames = MonitorDeFaturamentoChartBuilder.buildAxisChart(aXisLabelsUniversal, buildArrayPointSum(dataExames), strXtitleExames, strYtitleExames, strtitleExames, shapes, strokes, arrayPaint, arrayUniString, intWidthChart, intHeightChart);
    }

    public void newChartValor() {

        String[] arrayUniString = builArrayStringUniCodigo();
        Paint[] arrayPaint = buildArrayPaint();
        Shape[] shapes = buildArrayShapes();
        Stroke[] strokes = buildArrayStroke();
        axisChartValor = MonitorDeFaturamentoChartBuilder.buildAxisChart(aXisLabelsUniversal, buildArrayPointSum(dataValor), strXtitleValor, strYtitleValor, strtitleValor, shapes, strokes, arrayPaint, arrayUniString, intWidthChart, intHeightChart);

    }

    private void buildCharts() {
        initialzedExames = true;
        initialzedPacientes = true;
        initialzedValor = true;

        newChartExames();
        newChartPacientes();
        newChartValor();
        
        System.out.println("--------------------  Building chart for :  Cliente: "  +portal.getStrDbName()+ "       User: "+portal.getLabUsuario().getUsuStCodigo()+" ----------------------");
    }

    public void buildByDay() {


        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Horas";
            strXtitleExames = "Horas";
            strXtitleValor = "Horas";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";


            strListLabUnidadesHash = buidHashListUnidade();
            intChoice = 0;
            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());

            aXisLabelsUniversal = m.getaXisLabelCustom();
            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();

            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }



    }

    public void buildByWeek() {

        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Dias da Semana";
            strXtitleExames = "Dias da Semana";
            strXtitleValor = "Dias da Semana";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";

            strListLabUnidadesHash = buidHashListUnidade();
            intChoice = 1;
            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());


            aXisLabelsUniversal = aXisLabelsHrsOfWeek;
            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();

            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }




    }

    public void buildByMonth() {

        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Dias do Mês";
            strXtitleExames = "Dias do Mês";
            strXtitleValor = "Dias do Mês";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";


            strListLabUnidadesHash = buidHashListUnidade();

            intChoice = 2;

            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());
            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();
            String[] sLabels = m.getaXisLabelCustom();
            aXisLabelsUniversal = new String[sLabels.length];
            for (int i = 0; i < sLabels.length; i++) {
                aXisLabelsUniversal[i] = sLabels[i].substring(0, 2);
            }

            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }





    }

    public void buildByQuarter() {

        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Semana do Mês";
            strXtitleExames = "Semana do Mês";
            strXtitleValor = "Semana do Mês";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";

            strListLabUnidadesHash = buidHashListUnidade();
            intChoice = 3;

            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());

            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();
            String[] sLabel = m.getaXisLabelCustom();
            aXisLabelsUniversal = new String[sLabel.length];
            for (int i = 0; i < sLabel.length; i++) {
                aXisLabelsUniversal[i] = "S." + sLabel[i].substring(0, 1) + " " + sLabel[i].substring(2, sLabel[i].length());
            }


            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }





    }

    public void buildBySemeter() {

        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Meses do Ano";
            strXtitleExames = "Meses do Ano";
            strXtitleValor = "Meses do Ano";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";

            strListLabUnidadesHash = buidHashListUnidade();
            intChoice = 4;

            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());

            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();
            aXisLabelsUniversal = m.getaXisLabelCustom();

            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }




    }

    public void buildByYear() {

        if (portal.getListLabUnidadeSelected() != null && portal.getListLabUnidadeSelected().size() > 0) {
            strXtitlePacientes = "Meses do Ano";
            strXtitleExames = "Meses do Ano";
            strXtitleValor = "Meses do Ano";

            strYtitlePacientes = "Pacientes";
            strYtitleExames = "Exames";
            strYtitleValor = "Valor";

            strtitlePacientes = "Pacientes";
            strtitleExames = "Exames";
            strtitleValor = "Valor";

            strListLabUnidadesHash = buidHashListUnidade();
            intChoice = 5;

            List<LabUnidade> l = portal.getListLabUnidadeSelected();
            MonitorDados m = MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(l, dtBase, intChoice, portal.getStrDbName());

            dataPacientes = m.getDataPacientes();
            dataExames = m.getDataExames();
            dataValor = m.getDataValor();
            aXisLabelsUniversal = m.getaXisLabelCustom();

            buildCharts();
        } else {
            portal.popMsg(0, true, "Escolha ao menos uma Unidade para pode fazer a pesquisa.");
        }





    }

    public void buildByDoubleYear() {
    }

    public void queryByNewBaseDate(ValueChangeEvent event) {
        buildChartsByUserChoice();

    }

    public void dateSelectListener(DateSelectEvent event) {
        this.dtBase = event.getDate();
        buildChartsByUserChoice();
    }

//    public void closePopUnidade() {
//        blPopUnidade = false;
//    }
//
//    public void openPopUnidade() {
//        blPopUnidade = true;
//    }
//    public void grabUnidadeFromListSelected(ValueChangeEvent event) {
//            String codigo = ((HtmlSelectBooleanCheckbox) event.getComponent()).getLang();
//            strUnidadeCodigo = codigo;
//            grabLabUnidade();
//    }
//    private void findLabUnidadeToSelect(String uniStCodigo, boolean blStatus) {
//        
//        Iterator iter = portal.getMapLinkedLabUnidade().entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
//            LabUnidade uni = (LabUnidade) pair.getValue();
//            if (uni.getUniStCodigo().equalsIgnoreCase(uniStCodigo)) {
//                if (blStatus) {
//                    uni.setBlSelected(true);
//                } else {
//                    uni.setBlSelected(false);
//                }
//                break;
//            }
//        }
//    }
    private void buildChartsByUserChoice() {

        setStrChartMsg("Clique no Gráfico para mostrar mais informações.");

        switch (intChoice) {
            case 0:
                //by Day
                buildByDay();
//                axisChartPacientes = MonitorDeFaturamentoChartBuilder.buildAxisChart(aXisLabelsHrsOfDay, dataPacientes,"Hrs", "Pacientes", "Pacientes");
                break;

            case 1:
                //by Week
                buildByWeek();
//                axisChartPacientes = MonitorDeFaturamentoChartBuilder.buildAxisChart(aXisLabelsHrsOfWeek, dataPacientes,"Hrs", "Pacientes", "Pacientes");
                break;

            case 2:
                //by Month
                buildByMonth();
                break;

            case 3:
                //by Quarter
                buildByQuarter();
                break;

            case 6:
                //by Semester
                buildBySemeter();
                break;

            case 7:
                //by Year
                buildByYear();
                break;

            case 8:
                //by Two Years
                buildByDoubleYear();
                break;

            default:
                //by Day
                buildByDay();
                break;
        }
    }

    private Paint[] buildArrayPaint() {

        if (blUnificado) {
            Paint[] array = new Color[1];
            array[0] = Color.BLUE;
            return array;
        }

        if (portal.getListLabUnidade() != null && !portal.getListLabUnidade().isEmpty()) {

            Paint[] array = new Color[portal.getListLabUnidade().size()];
            int i = 0;
            for (LabUnidade uni : portal.getListLabUnidade()) {
//                System.out.println(listColor.get(i).toString());
                array[i] = listColor.get(i);
                i++;
            }
            return array;
        }
        return null;
    }

    private Stroke[] buildArrayStroke() {

        if (blUnificado) {
            Stroke[] array = new Stroke[1];
//            array[0] = LineChartProperties.DEFAULT_LINE_STROKE;
            return array;
        }

        if (portal.getListLabUnidade() != null && !portal.getListLabUnidade().isEmpty()) {

            Stroke[] array = new Stroke[portal.getListLabUnidade().size()];
            int i = 0;
            for (LabUnidade uni : portal.getListLabUnidade()) {
//                System.out.println(listColor.get(i).toString());
//                array[i] = LineChartProperties.DEFAULT_LINE_STROKE;
                i++;
            }
            return array;
        }
        return null;

    }

    private String[] builArrayStringUniCodigo() {
        if (blUnificado) {
            String[] array = new String[1];
            array[0] = "Unificado";
            return array;
        }
        if (portal.getListLabUnidadeSelected() != null && !portal.getListLabUnidadeSelected().isEmpty()) {
            String[] array = new String[portal.getListLabUnidadeSelected().size()];
            int i = 0;
            for (LabUnidade uni : portal.getListLabUnidadeSelected()) {
                array[i] = uni.getUniStCodigo();
                i++;
            }
            return array;
        }

        return null;
    }

    private Shape[] buildArrayShapes() {

        if (blUnificado) {
            Shape[] array = new Shape[1];
//            array[0] = PointChartProperties.SHAPE_CIRCLE;
            return array;
        }

        int intShape = 0;

        if (portal.getListLabUnidade() != null && !portal.getListLabUnidade().isEmpty()) {

            Shape[] array = new Shape[portal.getListLabUnidade().size()];
            int i = 0;
            for (LabUnidade uni : portal.getListLabUnidade()) {


                switch (intShape) {
                    case 0:
//                        array[i] = PointChartProperties.SHAPE_CIRCLE;
                        break;
                    case 1:
//                        array[i] = PointChartProperties.SHAPE_DIAMOND;
                        break;
                    case 2:
//                        array[i] = PointChartProperties.SHAPE_SQUARE;
                        break;
                    case 3:
//                        array[i] = PointChartProperties.SHAPE_TRIANGLE;
                        intShape = 0;
                        break;
                    default:
//                        array[i] = PointChartProperties.SHAPE_CIRCLE;
                        intShape = 0;
                        break;

                }


                i++;
                intShape++;
            }
            return array;
        }
        return null;

    }

    private void fillUpColorList() {

        listColor.add(Color.BLUE);
        listColor.add(Color.GREEN);
        listColor.add(Color.RED);
        listColor.add(Color.BLACK);
        listColor.add(Color.ORANGE);

        listColor.add(new Color(0x3E4891));
        listColor.add(new Color(0xE22A83));

        listColor.add(Color.PINK);
        listColor.add(Color.GRAY);
        listColor.add(Color.CYAN);
        listColor.add(Color.DARK_GRAY);
        listColor.add(Color.LIGHT_GRAY);
        listColor.add(Color.MAGENTA);
        listColor.add(Color.YELLOW);



        listColor.add(new Color(0x0D1274));
        listColor.add(new Color(0x0D2274));
        listColor.add(new Color(0x0D3274));
        listColor.add(new Color(0x0D4274));
        listColor.add(new Color(0x0D5274));
        listColor.add(new Color(0x0D6274));
        listColor.add(new Color(0x0D7274));
        listColor.add(new Color(0x0D8274));
        listColor.add(new Color(0x0D9274));
        listColor.add(new Color(0x0D0174));
        listColor.add(new Color(0x0D1274));
        listColor.add(new Color(0x0D4374));
        listColor.add(new Color(0x0D4474));
        listColor.add(new Color(0x0D4574));
        listColor.add(new Color(0x0D4674));
        listColor.add(new Color(0x0D4774));
        listColor.add(new Color(0x0D4874));
        for (int i = 0; i < 1000; i++) {
            listColor.add(new Color(0x0D4874 + i));
        }
    }

    private double[][] buildArrayPointSum(double[][] array) {

        double[][] arrayRertunUnificado = new double[1][array[0].length];
        double[][] arrayRertun = new double[array.length][array[0].length];
        double[][] arrayRertunUnificado2 = new double[1][array[0].length];


        Double dYMaxPac = 0D;
        Double dYMaxEx = 0D;
        Double dYMaxVr = 0D;

        if (blUnificado) {
            arrayRertunUnificado = new double[1][array[0].length];

            for (int i = 0; i < array.length; i++) {
                for (int y = 0; y < array[0].length; y++) {
                    double x = arrayRertunUnificado[0][y] + array[i][y];
                    arrayRertunUnificado[0][y] = x;
                }
            }

        } else {
            arrayRertunUnificado = array;
        }


        if (blAcumulativo) {

            for (int i = 0; i < arrayRertunUnificado.length; i++) {
                double dSum = 0d;

                for (int y = 0; y < arrayRertunUnificado[0].length; y++) {
                    dSum += arrayRertunUnificado[i][y];
                    if (blUnificado) {
                        arrayRertunUnificado2[i][y] = dSum;
                    } else {
                        arrayRertun[i][y] = dSum;
                    }

                }
            }
            if (blUnificado) {
                return arrayRertunUnificado2;
            } else {
                return arrayRertun;
            }

        }

        return arrayRertunUnificado;

    }

    public void refreshCharts(ValueChangeEvent event) {
        if (validadeHashListUnidades()) {
            buildCharts();
        } else {
            portal.popMsg(1, true, "Não é possivel remover ou adicionar unidades durante a utilização da ferramenta acumulativa. Faça uma nova pesquisa !!!");
        }

    }

    public void refreshCharts() {
        refreshCharts(null);
    }

    private String buidHashListUnidade() {
        List<LabUnidade> l = portal.getListLabUnidadeSelected();
        StringBuffer sbListLabUnidadesHash = new StringBuffer();
        if (l != null && !l.isEmpty()) {
            sbListLabUnidadesHash = new StringBuffer();

            for (LabUnidade lu : l) {
                sbListLabUnidadesHash.append(lu.toString());
            }
        }
        return sbListLabUnidadesHash.toString();
    }

    private boolean validadeHashListUnidades() {
        if (strListLabUnidadesHash.equals(buidHashListUnidade())) {
            return true;
        } else {
            return false;
        }
    }

    public void selectAllUnits() {
        Iterator iter = portal.getMapLinkedLabUnidade().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
            ((LabUnidade) pair.getValue()).setBlSelected(true);
        }
//        initialzedListUnidadesSelected();

    }

    public void cleanAllUnits() {
        Iterator iter = portal.getMapLinkedLabUnidade().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
            ((LabUnidade) pair.getValue()).setBlSelected(false);
        }
//        initialzedListUnidadesSelected();
    }

    public String getUnitsDescription() {
        if (portal.getListLabUnidade() != null && !portal.getListLabUnidade().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            if (blUnificado) {
                sb.append("Descrição Unificado: ");
            } else {
                sb.append("Descrição # ");
            }
            for (LabUnidade lu : portal.getListLabUnidade()) {
                sb.append("Unidade: ").append(lu.getUniStCodigo()).append(" - ").append(lu.getUniStDescricaoResumida()).append(" | ");
            }
            return sb.toString().substring(0, sb.toString().length() - 2);

        } else {
            return "Adicione Unidades.............";
        }
    }

//    private void initialzedListUnidadesSelected() {
//        if(portal.getListLabUnidade().isEmpty()){
//            portal.getMapLinkedLabUnidade().get(this.strUnidadeCodigo).setBlSelected(true);
//            listSetLabUnidade.add(portal.getMapLinkedLabUnidade().get(this.strUnidadeCodigo));
//        }else{
//            for(LabUnidade lu : portal.getListLabUnidade()){
//                if(lu.isBlSelected()){
//                    listSetLabUnidade.add(lu);
//                }
//            }
//        }
//        
//    }
    private String grabMaxYByChart(double[][] data) {

        Double doubleYMas = 10D;

        for (int i = 0; i < data.length; i++) {

            for (int y = 0; y < data[0].length; y++) {
                double x = data[i][y];
                if (x > doubleYMas) {
                    doubleYMas = x;
                }

            }

        }

        doubleYMas = doubleYMas + (doubleYMas * .04);
        return doubleYMas.toString();
    }

    public void onSlideEndAcumulativo(SlideEndEvent event) {

        if (event.getValue() == 0) {
                blAcumulativo = true;
            } else {
                blAcumulativo = false;
            }
        
        if (this.validadeHashListUnidades()) {
            buildCharts();
        } else {
            portal.popMsg(0, true, "Não é possivel usar o recurso 'acumulativo' depois de ter alterado a quantidade de unidades, rode a pesquisa novamente " + event.getValue());
        }




    }

    public void onSlideEndUnificado(SlideEndEvent event) {

        if (event.getValue() == 0) {
                blUnificado = true;
            } else {
                blUnificado = false;
            }
        
        if (this.validadeHashListUnidades()) {
            buildCharts();
        } else {
            portal.popMsg(0, true, "Não é possivel usar o recurso 'unificado' depois de ter alterado a quantidade de unidades, rode a pesquisa novamente " + event.getValue());
        }

    }

    public void zoomChartPaciente() {
        
        RequestContext context = RequestContext.getCurrentInstance();
//        RequestContext.getCurrentInstance().execute
//        FacesContext externalcontext = FacesContext.getCurrentInstance();
        context.execute("widgetvardialogchartPacientesZoom.show();");
//        context.
                
    }
    
    public void zoomChartPaciente(ActionEvent event) {
        
         RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
                
    }
    

    public void zoomChartExame() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("widgetvarmonitorfaturamentopoplistpopexame.show();");
    }

    public void zoomChartValor() {
        
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("widgetvarmonitorfaturamentopoplistpopvalor.show();");

        
    }
    
    
    public String getDatatipFormatIntegers(){
        return "<span style=\"display:none;\">%s</span><span>%s</span>";
     }
    
    public String getDatatipFormatDoubles(){
        return "<span style=\"display:none;\">%s</span><span>%s</span>";
     }
    
    
    
}
