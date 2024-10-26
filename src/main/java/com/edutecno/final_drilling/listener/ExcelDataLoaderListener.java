package com.edutecno.final_drilling.listener;

import com.edutecno.final_drilling.dto.HoroscopoDto;
import com.edutecno.final_drilling.modelo.Horoscopo;
import com.edutecno.final_drilling.repository.HoroscopoRepository;
import com.edutecno.final_drilling.repository.HoroscopoRepositoryImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.sql.rowset.spi.XmlReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@WebListener
public class ExcelDataLoaderListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HoroscopoRepository horoscopoRepository = new HoroscopoRepositoryImpl();
        List<Horoscopo> horoscopoList = horoscopoRepository.findAll();
        System.out.println(horoscopoList);
        if (horoscopoList.isEmpty()) {
            String excelPath = "/app/horoscopo/horoscopo.xlsx";
            try(FileInputStream fileInputStream = new FileInputStream(excelPath)) {
                System.out.println("Encuentra el archivo Excel en la ruta");
//                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//                InputStream fis = classLoader.getResourceAsStream("horoscopo.xlsx");
//                String excelPath = "/app/horoscopo.xlsx";
//
//                if (fis == null) {
//                    throw new FileNotFoundException("No se encontró el archivo Excel en el classpath.");
//                }
//            String excelFilePath = "/horoscopo.xlsx";
//            FileInputStream fis = new FileInputStream(new File(excelFilePath));
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    String animal = row.getCell(0).getStringCellValue();
                    Date fechaInicio = row.getCell(1).getDateCellValue();
                    Date fechaFinal = row.getCell(2).getDateCellValue();
//                System.out.println(fechaInicio);
//                System.out.println(fechaFinal);
                    Horoscopo horoscopo = new Horoscopo(animal, fechaInicio, fechaFinal);
                    HoroscopoDto horoscopoDto = new HoroscopoDto(animal, new java.sql.Date(fechaInicio.getTime()), new java.sql.Date(fechaFinal.getTime()));
//                System.out.println(horoscopo);
                    horoscopoRepository.saveHoroscopo(horoscopoDto);
                }

                workbook.close();
//                fileInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
