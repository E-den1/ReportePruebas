package Principal;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.xwpf.usermodel.*;

public class GenerarWord {
	

	public GenerarWord() {
		// TODO Auto-generated constructor stub
	}
	
	private XWPFDocument document = new XWPFDocument();

	public void crear(Metricas metricas) {
		javax.swing.filechooser.FileNameExtensionFilter filtroWord = new FileNameExtensionFilter("Microsoft Word", "docx");
		final JFileChooser miArchivo = new JFileChooser();
		miArchivo.setFileFilter(filtroWord);
		int aceptar = miArchivo.showSaveDialog(null);
		miArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (aceptar == JFileChooser.APPROVE_OPTION) {
			File fileWord = miArchivo.getSelectedFile();
			String nombre = fileWord.getName();
			if(nombre.indexOf('.')==-1) {
				nombre+=".docx";
				fileWord = new File(fileWord.getParentFile(), nombre);
				
			}try {
				
				XWPFParagraph paragraphEncabezado = document.createParagraph();
				paragraphEncabezado.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun encabezado = paragraphEncabezado.createRun();
				encabezado.setFontSize(12);
				encabezado.setFontFamily("Century Gotic");
				
				encabezado.setText(Constantes.ENCABEZADO1);
				encabezado.addBreak();
				encabezado.addBreak();
				encabezado.setText(Constantes.ENCABEZADO2);
				encabezado.addBreak();
				encabezado.setText(Constantes.ENCABEZADO3);
				encabezado.addBreak();
				
				XWPFParagraph paragraphEstado = document.createParagraph();
				paragraphEstado.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun estado = paragraphEstado.createRun();
				
				estado.setFontSize(12);
				estado.setFontFamily("Century Gotic");
				
				estado.setText(Constantes.ESTADO);
				estado.addBreak();
				estado.addBreak();
				estado.setText("Total de casos de prueba: "+metricas.getTotal());
				estado.addBreak();
				estado.setText("Casos Ejecutados: "+metricas.getEjecutados()+", "+metricas.getRespEjecutados()+"%");
				estado.addBreak();
				estado.setText("Exitosos: "+metricas.getExitosos()+", "+metricas.getRespExitosos()+"%");
				estado.addBreak();
				estado.setText("Fallados: "+metricas.getFallados()+", "+metricas.getRespFallados()+"%");
				estado.addBreak();
				estado.setText("No Ejecutados: "+metricas.getNoEjecutados()+", "+metricas.getRespNoEjecutados()+"%");
				estado.addBreak();
				estado.setText("Bloqueados: "+metricas.getBloqueados()+", "+metricas.getRespbloqueados()+"%");
				estado.addBreak();
				estado.setText("Cancelados: "+metricas.getCancelados()+", "+metricas.getRespCancelados()+"%");
				estado.addBreak();
				
				estado.addBreak();
				estado.addBreak();
				
				
				XWPFParagraph paragraphHighlights = document.createParagraph();
				paragraphHighlights.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun highlights = paragraphHighlights.createRun();
				
				highlights.setFontSize(12);
				highlights.setFontFamily("Century Gotic");
				
				highlights.setText(Constantes.HIGHLIGHTS);
				// se pondrá en la interfaz para quesalga en el documento
				highlights.addBreak();
				highlights.addBreak();
				highlights.setText(metricas.getHighlights());
				highlights.addBreak();
				highlights.addBreak();
				
				XWPFParagraph paragraphPasos = document.createParagraph();
				paragraphPasos.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun pasos = paragraphPasos.createRun();
				
				pasos.setFontSize(12);
				pasos.setFontFamily("Century Gotic");
				
				pasos.setText(Constantes.SIG_PASOS);
				pasos.addBreak();
				pasos.addBreak();
				pasos.setText(metricas.getSiguientesp());
				pasos.addBreak();
				pasos.addBreak();
				
				XWPFParagraph paragraphDespedida = document.createParagraph();
				paragraphDespedida.setAlignment(ParagraphAlignment.LEFT);
				XWPFRun despedida = paragraphDespedida.createRun();
				despedida.setBold(true);
				despedida.setFontSize(12);
				despedida.setFontFamily("Century Gotic");
				despedida.setText(Constantes.DESPEDIDA1);
				despedida.addBreak();
				despedida.setText(Constantes.DESPEDIDA2);
				despedida.addBreak();
				despedida.setText(Constantes.DESPEDIDA3);
				despedida.addBreak();
				
				FileOutputStream fos = new FileOutputStream(nombre);
				document.write(fos);
				fos.close();
								
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
