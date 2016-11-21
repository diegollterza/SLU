/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slu.converter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;



/**
 *
 * @author Diego la Terza Pinelli Ferreira
 */
public class ConversorPDF {
    private JasperReportBuilder report;
    private Connection connection;
    private StyleBuilder style;
    
    public ConversorPDF(){
        report = DynamicReports.report();
        style = DynamicReports.stl.style().setFontSize(7);
        connectDB();
    }

    private void connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/db",
                            "postgres", "admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConversorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }
    
    public void geraPDF(ArrayList<String> fields,ArrayList<String> delimiters, boolean flag){
        String sdelimiters = "", sfields = fields.get(0);
        report.columns(Columns.column(fields.get(0).toUpperCase(),fields.get(0),DataTypes.stringType())).setColumnStyle(style);
        if(!delimiters.isEmpty()){
            sdelimiters = "WHERE";
            sdelimiters += " " + delimiters.get(0);
            for(int i = 1; i < delimiters.size();i++){
                sdelimiters += "AND " + delimiters.get(i);
            }
        };
        for(int i = 1; i < fields.size();i++){
            sfields += ", " + fields.get(i);
            report.columns(Columns.column(fields.get(i).toUpperCase(),fields.get(i),DataTypes.stringType())).setColumnStyle(style);
        }
        report.title(Components.text("Teste").setHorizontalAlignment(HorizontalAlignment.RIGHT));
        report.setDataSource("SELECT " + sfields + " FROM Universidades " + sdelimiters +";", connection);
        
        try {
            report.show();
            if(flag){
            report.toPdf(new FileOutputStream("log.pdf"));
            }else{
                report.toXls(new FileOutputStream("log.pdf"));
            }
        } catch (DRException | FileNotFoundException ex) {
            Logger.getLogger(ConversorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
