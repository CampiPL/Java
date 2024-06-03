package compliance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;

	JLabel label1;
	JLabel label2;
	
	JTextField text;
	
	JButton okSearch;
	JButton okDeleteAcc;
	JButton okDelete;
	JButton okRet;
	JButton okDate;
	JButton restart;
	
	Log log;
	
	String pt, fname;
	AtomicInteger count, size;
	
	int ret;
	String date, path;
	
	GUI(){
		
		this.label1 = new JLabel();
		this.label2 = new JLabel();
		
		this.text = new JTextField();
		
		this.okSearch = new JButton();
		this.okDeleteAcc = new JButton();
		this.okDelete = new JButton();
		this.okRet = new JButton();
		this.okDate = new JButton();
		this.restart = new JButton();
		
		this.okSearch.setFocusable(false);
		this.okDeleteAcc.setFocusable(false);
		this.okDelete.setFocusable(false);
		this.okRet.setFocusable(false);
		this.okDate.setFocusable(false);
		this.restart.setFocusable(false);
		
		this.okSearch.setText("OK");
		this.okDeleteAcc.setText("OK");
		this.okDelete.setText("OK");
		this.okRet.setText("OK");
		this.okDate.setText("OK");
		
		this.text.setBounds(20, 80, 260, 25);
		
		this.okSearch.setBounds(112, 120, 75, 30);
		this.okDeleteAcc.setBounds(65, 120, 75, 30);
		this.okDelete.setBounds(112, 120, 75, 30);
		this.okRet.setBounds(112, 120, 75, 30);
		this.okDate.setBounds(112, 120, 75, 30);
		
		try {
			this.log = new Log("Log.txt");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
			//this.log.
			log.logger.warning(e.toString());
			this.label1.setText("UWAGA!!! Nie udało się połączyć z plikiem Log.txt");
			this.log.logger.severe("UWAGA!!! Nie udało się połączyć z plikiem Log.txt");
		}
		
		this.okSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(text.getText().toLowerCase().equals("m") || text.getText().toLowerCase().equals("c")) {
					
					date = text.getText();
					clear();
					search();
				}
				else {
					label1.setText("Błąd, wybierz jedną z możliwych opcji");
					text.setText("");
				}
			}
			
		});
		
		this.okDeleteAcc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				clear();
				deleteAcc();
			}
			
		});
		
		this.okDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(text.getText().equals("DeletionData0")) {
					clear();
					delete();
				}
				else {
					label1.setText("Błędne hasło, spróbuj ponownie:");
					text.setText("");
				}
			}
			
		});
		
		this.okRet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				path = text.getText();
				clear();
				okRet();
			}
			
		});
		
		this.okDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(text.getText().matches("\\d+")) {
					ret = Integer.parseInt(text.getText());
					
					clear();
					date();
				}
				else {
					label1.setText("Błąd, podaj wartość liczbową:");
					text.setText("");
				}
			}
			
		});
		
		this.restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				delTemp();
				
				clear();
				
				BufferedWriter writer;
				
				try {
					writer = new BufferedWriter(new FileWriter("Log.txt", true));
				
					writer.append("\n");
				
					writer.close();
				
				} catch (IOException e1) {
					e1.printStackTrace();
					log.logger.warning(e1.toString());
				}
				
				text.setText("");
				
				log.logger.info("Program zrestartowany");
				start();
			}
			
		});
		
		this.setTitle("Retend");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(300,250);
		this.setVisible(true);
		this.add(this.label1);
		this.add(this.label2);
		this.add(this.text);
		this.add(this.okSearch);
		this.add(this.okDeleteAcc);
		this.add(this.okDelete);
		this.add(this.okRet);
		this.add(this.okDate);
		this.add(this.restart);
		
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter("Log.txt", true));
		
			writer.append("\n");
		
			writer.close();
		
		} catch (IOException e1) {
			e1.printStackTrace();
			log.logger.warning(e1.toString());
		}
		
		this.log.logger.info("***Program wystartowany***");
		
		clear();
		
		delTemp();
		
		start();
	}
	
	void clear() {
		
		this.label1.setText("");
		this.label2.setText("");
		
		this.text.setVisible(false);
		
		this.okSearch.setVisible(false);
		this.okDeleteAcc.setVisible(false);
		this.okDelete.setVisible(false);
		this.okRet.setVisible(false);
		this.okDate.setVisible(false);
		this.restart.setVisible(false);
	}
	
	void start(){
		
		this.label1.setBounds(40, 50, 260, 20);
		this.label1.setText("Podaj scieżkę folderu do sprawdzenia:");
		
		this.text.setVisible(true);
		
		this.okRet.setVisible(true);
	}
	
	void okRet() {
		
		this.label1.setText("Podaj okres retencji (w miesiącach):");
		
		this.text.setText("");
		this.text.setVisible(true);
		
		this.okDate.setVisible(true);
	}
	
	void date() {
		
		this.label1.setText("Podaj opcję daty początkowej:");
		
		this.label2.setBounds(20, 170, 260, 20);
		this.label2.setText("c - data powstania, m - data ostatniej mod.");
		
		this.text.setText("");
		this.text.setVisible(true);
		
		this.okSearch.setVisible(true);
	}
	
	void search() {
		
		boolean error = false;
		AtomicInteger access = new AtomicInteger(0);
		
		if(this.path.equals(""))
			this.pt = System.getProperty("user.dir");
		else
			this.pt = this.path;
		
		this.size = new AtomicInteger(0);
		this.count = new AtomicInteger(0);
		
		count = new AtomicInteger(0);
		size = new AtomicInteger(0);
		
		File file = new File("test.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			log.logger.warning(e.toString());
			error = true;
		}
		
		File del = new File("del.txt");
		
		try {
			del.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			log.logger.warning(e.toString());
			error = true;
		}
		
		log.logger.info("Skanuję w folderze " + this.pt);
		
		log.logger.info("Sprawdzany czas retencji: " + ret + " miesięcy");
		
		try (Stream<Path> str = Files.walk(Paths.get(this.pt))){
			
			str.filter(p -> p.toFile().isFile()).forEach(path -> {
			
				FileTime time = null;
				
				if(this.date.equals("c"))
					try {
						log.logger.info("Data do liczenia retencji: data utworzenia");
						time = (FileTime) Files.getAttribute(path, "creationTime");
					} catch (IOException e) {
						e.printStackTrace();
						log.logger.warning(e.toString());
						access.incrementAndGet();
					}
				else
					try {
						log.logger.info("Data do liczenia retencji: data ostatniej modyfikacji");
						time = (FileTime) Files.getAttribute(path, "lastModifiedTime");
					} catch (IOException e) {
						e.printStackTrace();
						log.logger.warning(e.toString());
						access.incrementAndGet();
					}
					
				
				int year = Integer.parseInt(time.toString().split("T")[0].split("-")[0]);
				int month = Integer.parseInt(time.toString().split("T")[0].split("-")[1]);
				int day = Integer.parseInt(time.toString().split("T")[0].split("-")[2]);
				
				LocalDate now = LocalDate.now();
				LocalDate date = LocalDate.of(year, month, day);
				Period period = Period.between(date, now);
				int retention = period.getYears() * 12 + period.getMonths();
				
				if(retention >= this.ret) {
					
					try {
						
						if(count.get()==0)
							Files.write(Paths.get(System.getProperty("user.dir") + "\\del.txt"), ("" + path).getBytes(), StandardOpenOption.APPEND);
						else
							Files.write(Paths.get(System.getProperty("user.dir") + "\\del.txt"), ("\n" + path).getBytes(), StandardOpenOption.APPEND);
						
					} catch (IOException e) {
						e.printStackTrace();
						log.logger.warning(e.toString());
						access.incrementAndGet();
					}
					
					FileTime creationTime = null;
					try {
						creationTime = (FileTime) Files.getAttribute(path, "creationTime");
					} catch (IOException e1) {
						e1.printStackTrace();
						log.logger.warning(e1.toString());
						access.incrementAndGet();
					}
					
					year = Integer.parseInt(time.toString().split("T")[0].split("-")[0]);
					month = Integer.parseInt(time.toString().split("T")[0].split("-")[1]);
					day = Integer.parseInt(time.toString().split("T")[0].split("-")[2]);
					
					Date d = new Date(path.toFile().lastModified());
					DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
					formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
					String lastModified = formatter.format(d);				
					String data = path.toFile().getName() + "\t" + creationTime.toString().split("T")[0] + "\t" + lastModified;
						
					try {
						
						if(count.getAndIncrement()==0)
							Files.write(Paths.get(System.getProperty("user.dir") + "\\test.txt"), "nazwa\tdata utworzenia\tdata modyfikacji".getBytes(), StandardOpenOption.APPEND);
						Files.write(Paths.get(System.getProperty("user.dir") + "\\test.txt"), ("\n" + data).getBytes(), StandardOpenOption.APPEND);
						
					} catch (IOException e) {
						e.printStackTrace();
						log.logger.warning(e.toString());
						access.incrementAndGet();
					}
					
					
				}
				
				size.getAndIncrement();
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			log.logger.warning(e.toString());
			error = true;
		}
		
		if(error || access.get()>0) {
			
			log.logger.warning("Skanowanie folderu " + pt + " zakończone niepowodzeniem");
			this.label1.setBounds(5, 50, 290, 20);
			this.label1.setText("Skanowanie folderu zakończone niepowodzeniem");
			
			if(error)
				log.logger.warning("error");
			
			if(access.get()>0)
				log.logger.warning("access denied: " + access.get() + "");
			
			this.restart.setBounds(110, 120, 80, 30);
			this.restart.setText("Restart");
			this.restart.setVisible(true);
		}
		else {
			
		log.logger.info("Zakończono skanowanie folderu " + this.pt);
		
		try {
			Files.write(Paths.get(System.getProperty("user.dir") + "\\test.txt"), ("\n" + "all:" + size + "\t" + "delete:" + count).getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.fname = this.pt + LocalDateTime.now() + ".txt";
		
		this.fname = this.fname.replaceAll("[\\\\/:*?\"<>|]", "");
		
		if(new File(this.fname).exists())
			new File(this.fname).delete();
		
		file.renameTo(new File(this.fname));
		
		this.label1.setBounds(20, 50, 260, 20);
		this.label1.setText("Wygenerowano raport o znalezionych plikach");
		this.label2.setBounds(40, 70, 220, 20);
		this.label2.setText("Czy chcesz usunąć znalezione pliki?");
		
		this.okDeleteAcc.setVisible(true);
		this.restart.setBounds(160, 120, 75, 30);
		this.restart.setText("Anuluj");
		this.restart.setVisible(true);
		
		}
		
	}
	
	void deleteAcc() {
		
		this.label1.setText("Podaj hasło autoryzacji akcji usunięcia:");
		this.text.setText("");
		this.text.setVisible(true);
		this.okDelete.setVisible(true);
	}
	
	void delete() {
		
		boolean error = false;
		
		log.logger.info("Usuwanie plików w " + this.pt);
		
		AtomicInteger deleted = new AtomicInteger(0);
		
		if(new File("del" + this.fname).exists())
			new File("del" + this.fname).delete();
		
		new File("del.txt").renameTo(new File("del" + this.fname));
		
		try {
			Files.lines(Paths.get("del" + this.fname)).map(x -> {
				
				return new File(x);
			}).forEach(x ->{
				
				deleted.getAndIncrement();
				
				//operacja usuniecia
			});
		} catch (IOException e) {
			e.printStackTrace();
			log.logger.warning(e.toString());
			error = true;
		}
		
		new File("del" + this.fname).delete();
		
		if(new File("Delog " + this.fname).exists())
			new File("Delog " + this.fname).delete();
		
		File delog = new File("Delog " + this.fname);
		
		try {
			delog.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			log.logger.warning(e1.toString());
			error = true;
		}
		
		try {
			Files.write(Paths.get(System.getProperty("user.dir") + "\\Delog " + this.fname),("Znaleziono " + this.size + " plików\n").getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(System.getProperty("user.dir") + "\\Delog " + this.fname),("Do usunięcia kwalifikowało się " + this.count + " plików\n").getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(System.getProperty("user.dir") + "\\Delog " + this.fname),("Usunięto " + deleted + " plików\n").getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(System.getProperty("user.dir") + "\\Delog " + this.fname),("Operacja wykonana " + Calendar.getInstance().getTime()).getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
			log.logger.warning(e.toString());
			error = true;
		}
		
		if(!error) {
			log.logger.info("Usuwanie plików i wygenerowanie raportu zakończone sukcesem");
			this.label1.setText("Usuwanie plików i wygenerowanie raportu");
			this.label2.setBounds(20, 70, 260, 20);
			this.label2.setText("zakończone sukcesem");
		}
		else {
			log.logger.warning("Usuwanie plików i wygenerowanie raportu zakończone niepowodzeniem");
			this.label1.setText("Usuwanie plików i wygenerowanie raportu");
			this.label2.setBounds(20, 70, 260, 20);
			this.label2.setText("zakończone niepowodzeniem");
		}
		
		this.restart.setBounds(110, 120, 80, 30);
		this.restart.setText("Restart");
		this.restart.setVisible(true);
	}
	
	void delTemp() {
		
		if(new File("del.txt").exists())
			new File("del.txt").delete();
		if(new File("test.txt").exists())
			new File("test.txt").delete();
		
	}
	
}
