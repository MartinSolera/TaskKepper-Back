package com.main.TaskKeeper.Util;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.main.TaskKeeper.Controller.TaskController;
import com.main.TaskKeeper.Model.Task;
import com.main.TaskKeeper.Service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.service.spi.InjectService;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.util.List;
import java.util.Map;


@Component("/tasks")
public class ListarPDF extends AbstractPdfView {


    @Autowired
    TaskService service;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response){

        // Obtener la lista de tareas del modelo
        List<Task> listTask = (List<Task>) model.get("tasks");
        PdfPTable tableTask = new PdfPTable(2);

        // Configurar el tamaño de la página
        document.setPageSize(PageSize.A4);

        listTask.forEach(task -> {
            tableTask.addCell(task.getName());
            tableTask.addCell(task.getDescription());
        });
        document.add(tableTask);
    }

}
